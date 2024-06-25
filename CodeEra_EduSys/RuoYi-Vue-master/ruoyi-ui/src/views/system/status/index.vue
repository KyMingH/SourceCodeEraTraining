<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="状态类型" prop="statusType">
        <el-select v-model="queryParams.statusType" placeholder="请选择状态类型" clearable>
          <el-option
            v-for="dict in dict.type.student_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="状态开始日期">
        <el-date-picker
          v-model="daterangeStatusStartDate"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="状态结束日期">
        <el-date-picker
          v-model="daterangeStatusEndDate"
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
          v-hasPermi="['system:status:add']"
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
          v-hasPermi="['system:status:edit']"
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
          v-hasPermi="['system:status:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:status:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="statusList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="状态ID" align="center" prop="statusId" />
      <el-table-column label="学员ID" align="center" prop="studentId" />
      <el-table-column label="状态类型" align="center" prop="statusType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.student_status" :value="scope.row.statusType"/>
        </template>
      </el-table-column>
      <el-table-column label="状态开始日期" align="center" prop="statusStartDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.statusStartDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="状态结束日期" align="center" prop="statusEndDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.statusEndDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:status:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:status:remove']"
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

    <!-- 添加或修改student_status对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="学员ID" prop="studentId">
          <el-input v-model="form.studentId" placeholder="请输入学员ID" />
        </el-form-item>
        <el-form-item label="状态类型" prop="statusType">
          <el-select v-model="form.statusType" placeholder="请选择状态类型">
            <el-option
              v-for="dict in dict.type.student_status"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="状态开始日期" prop="statusStartDate">
          <el-date-picker clearable
            v-model="form.statusStartDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择状态开始日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="状态结束日期" prop="statusEndDate">
          <el-date-picker clearable
            v-model="form.statusEndDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择状态结束日期">
          </el-date-picker>
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
import { listStatus, getStatus, delStatus, addStatus, updateStatus } from "@/api/system/status";

export default {
  name: "Status",
  dicts: ['student_status'],
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
      // student_status表格数据
      statusList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 备注时间范围
      daterangeStatusStartDate: [],
      // 备注时间范围
      daterangeStatusEndDate: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        statusType: null,
        statusStartDate: null,
        statusEndDate: null,
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
    /** 查询student_status列表 */
    getList() {
      this.loading = true;
      this.queryParams.params = {};
      if (null != this.daterangeStatusStartDate && '' != this.daterangeStatusStartDate) {
        this.queryParams.params["beginStatusStartDate"] = this.daterangeStatusStartDate[0];
        this.queryParams.params["endStatusStartDate"] = this.daterangeStatusStartDate[1];
      }
      if (null != this.daterangeStatusEndDate && '' != this.daterangeStatusEndDate) {
        this.queryParams.params["beginStatusEndDate"] = this.daterangeStatusEndDate[0];
        this.queryParams.params["endStatusEndDate"] = this.daterangeStatusEndDate[1];
      }
      listStatus(this.queryParams).then(response => {
        this.statusList = response.rows;
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
        statusId: null,
        studentId: null,
        statusType: null,
        statusStartDate: null,
        statusEndDate: null,
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
      this.daterangeStatusStartDate = [];
      this.daterangeStatusEndDate = [];
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.statusId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加student_status";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const statusId = row.statusId || this.ids
      getStatus(statusId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改student_status";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.statusId != null) {
            updateStatus(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addStatus(this.form).then(response => {
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
      const statusIds = row.statusId || this.ids;
      this.$modal.confirm('是否确认删除student_status编号为"' + statusIds + '"的数据项？').then(function() {
        return delStatus(statusIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/status/export', {
        ...this.queryParams
      }, `status_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
