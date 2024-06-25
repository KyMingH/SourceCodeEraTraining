<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="试听课程" prop="trialCourse">
        <el-input
          v-model="queryParams.trialCourse"
          placeholder="请输入试听课程"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="试听日期">
        <el-date-picker
          v-model="daterangeTrialDate"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="转化状态" prop="conversionStatus">
        <el-select v-model="queryParams.conversionStatus" placeholder="请选择转化状态" clearable>
          <el-option
            v-for="dict in dict.type.sys_yes_no"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
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
          v-hasPermi="['system:trial_studentsM:add']"
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
          v-hasPermi="['system:trial_studentsM:edit']"
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
          v-hasPermi="['system:trial_studentsM:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:trial_studentsM:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="trial_studentsMList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="试听学员ID" align="center" prop="trialStudentId" />
      <el-table-column label="学员ID" align="center" prop="studentId" />
      <el-table-column label="试听课程" align="center" prop="trialCourse" />
      <el-table-column label="试听日期" align="center" prop="trialDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.trialDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="转化状态" align="center" prop="conversionStatus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_yes_no" :value="scope.row.conversionStatus"/>
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
            v-hasPermi="['system:trial_studentsM:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:trial_studentsM:remove']"
          >删除</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-circle-check"
            @click="handleChange(scope.row)"
            v-hasPermi="['system:trial_studentsM:remove']"
          >申请转正</el-button>
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

    <!-- 添加或修改trial_studentsM对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="学员ID" prop="studentId">
          <el-input v-model="form.studentId" placeholder="请输入学员ID" />
        </el-form-item>
        <el-form-item label="试听课程" prop="trialCourse">
          <el-input v-model="form.trialCourse" placeholder="请输入试听课程" />
        </el-form-item>
        <el-form-item label="试听日期" prop="trialDate">
          <el-date-picker clearable
            v-model="form.trialDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择试听日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="转化状态" prop="conversionStatus">
          <el-select v-model="form.conversionStatus" placeholder="请选择转化状态">
            <el-option
              v-for="dict in dict.type.sys_yes_no"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
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
import { listTrial_studentsM, getTrial_studentsM, delTrial_studentsM, addTrial_studentsM, updateTrial_studentsM } from "@/api/system/trial_studentsM";
import { listStudentRegularApproval, getStudentRegularApproval, delStudentRegularApproval, addStudentRegularApproval, updateStudentRegularApproval } from "@/api/system/studentRegularApproval";

export default {
  name: "Trial_studentsM",
  dicts: ['sys_yes_no'],
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
      // trial_studentsM表格数据
      trial_studentsMList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 备注时间范围
      daterangeTrialDate: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        trialCourse: null,
        trialDate: null,
        conversionStatus: null,
      },
      // 表单参数
      form: {},
      form_RegularApproval: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 转正按钮 */
    handleChange(row) {
        this.form_RegularApproval.studentId = row.studentId
        this.form_RegularApproval.trialStudentId = row.trialStudentId
        this.form_RegularApproval.approvalStatus = '待审核'
        addStudentRegularApproval(this.form_RegularApproval).then(response => {
              this.$modal.msgSuccess("申请成功");
            });
    },
    /** 查询trial_studentsM列表 */
    getList() {
      this.loading = true;
      this.queryParams.params = {};
      if (null != this.daterangeTrialDate && '' != this.daterangeTrialDate) {
        this.queryParams.params["beginTrialDate"] = this.daterangeTrialDate[0];
        this.queryParams.params["endTrialDate"] = this.daterangeTrialDate[1];
      }
      listTrial_studentsM(this.queryParams).then(response => {
        this.trial_studentsMList = response.rows;
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
        trialStudentId: null,
        studentId: null,
        trialCourse: null,
        trialDate: null,
        conversionStatus: null,
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
      this.daterangeTrialDate = [];
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.trialStudentId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加trial_studentsM";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const trialStudentId = row.trialStudentId || this.ids
      getTrial_studentsM(trialStudentId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改trial_studentsM";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.trialStudentId != null) {
            updateTrial_studentsM(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addTrial_studentsM(this.form).then(response => {
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
      const trialStudentIds = row.trialStudentId || this.ids;
      this.$modal.confirm('是否确认删除trial_studentsM编号为"' + trialStudentIds + '"的数据项？').then(function() {
        return delTrial_studentsM(trialStudentIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/trial_studentsM/export', {
        ...this.queryParams
      }, `trial_studentsM_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
