<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="沟通日期">
        <el-date-picker
          v-model="daterangeCommunicationDate"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:communication:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:communication:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:communication:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:communication:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="communicationList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="沟通记录ID" align="center" prop="communicationId"  width="100"/>
      <el-table-column label="试听学员ID" align="center" prop="trialStudentId"  width="100"/>
      <el-table-column label="沟通日期" align="center" prop="communicationDate" width="100">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.communicationDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="沟通内容" align="center" prop="communicationContent" width="300"/>
      <el-table-column label="后续行动计划" align="center" prop="followUpActions" width="300"/>
      <el-table-column label="备注" align="center" prop="remark" width="300"/>
      <el-table-column fixed="right" label="操作" align="center" class-name="small-padding fixed-width" width="200">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:communication:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:communication:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改TrialStudentCommunication对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="试听学员ID" prop="trialStudentId">
          <el-input v-model="form.trialStudentId" placeholder="请输入试听学员ID" />
        </el-form-item>
        <el-form-item label="沟通日期" prop="communicationDate">
          <el-date-picker clearable
            v-model="form.communicationDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择沟通日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="沟通内容">
          <editor v-model="form.communicationContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="后续行动计划" prop="followUpActions">
          <el-input v-model="form.followUpActions" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listCommunication, getCommunication, delCommunication, addCommunication, updateCommunication } from "@/api/system/communication";

export default {
  name: "Communication",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // TrialStudentCommunication表格数据
      communicationList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 备注时间范围
      daterangeCommunicationDate: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        communicationDate: null,
        communicationContent: null,
        followUpActions: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询TrialStudentCommunication列表 */
    getList() {
      this.loading = true;
      this.queryParams.params = {};
      if (null != this.daterangeCommunicationDate && '' != this.daterangeCommunicationDate) {
        this.queryParams.params["beginCommunicationDate"] = this.daterangeCommunicationDate[0];
        this.queryParams.params["endCommunicationDate"] = this.daterangeCommunicationDate[1];
      }
      listCommunication(this.queryParams).then(response => {
        this.communicationList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        communicationId: null,
        trialStudentId: null,
        communicationDate: null,
        communicationContent: null,
        followUpActions: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.daterangeCommunicationDate = [];
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.communicationId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加TrialStudentCommunication";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const communicationId = row.communicationId || this.ids
      getCommunication(communicationId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改TrialStudentCommunication";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.communicationId != null) {
            updateCommunication(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCommunication(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const communicationIds = row.communicationId || this.ids;
      this.$modal.confirm('是否确认删除TrialStudentCommunication编号为"' + communicationIds + '"的数据项？').then(function() {
        return delCommunication(communicationIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/communication/export', {
        ...this.queryParams
      }, `communication_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
