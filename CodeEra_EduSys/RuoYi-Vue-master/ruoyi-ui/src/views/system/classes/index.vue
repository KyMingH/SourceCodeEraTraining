<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="班级名称" prop="className">
        <el-input
          v-model="queryParams.className"
          placeholder="请输入班级名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="开始日期">
        <el-date-picker
          v-model="daterangeStartDate"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="结束日期">
        <el-date-picker
          v-model="daterangeEndDate"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="班级状态" prop="classStatus">
        <el-select v-model="queryParams.classStatus" placeholder="请选择班级状态" clearable>
          <el-option
            v-for="dict in dict.type.class_status"
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
          v-hasPermi="['system:classes:add']"
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
          v-hasPermi="['system:classes:edit']"
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
          v-hasPermi="['system:classes:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:classes:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="classesList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="班级ID" align="center" prop="classId" />
      <el-table-column label="班级名称" align="center" prop="className" />
      <el-table-column label="开始日期" align="center" prop="startDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.startDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="结束日期" align="center" prop="endDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.endDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="班级状态" align="center" prop="classStatus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.class_status" :value="scope.row.classStatus"/>
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
            v-hasPermi="['system:classes:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:classes:remove']"
          >删除</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-s-management"
            @click="ApplyForStatus(scope.row)"
            v-hasPermi="['system:classes:remove']"
          >状态申请</el-button>
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

    <!-- 添加或修改classes对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="班级名称" prop="className">
          <el-input v-model="form.className" placeholder="请输入班级名称" />
        </el-form-item>
        <el-form-item label="开始日期" prop="startDate">
          <el-date-picker clearable
            v-model="form.startDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择开始日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="结束日期" prop="endDate">
          <el-date-picker clearable
            v-model="form.endDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择结束日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="班级状态" prop="classStatus">
          <el-select v-model="form.classStatus" placeholder="请选择班级状态">
            <el-option
              v-for="dict in dict.type.class_status"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
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
    <!-- 状态申请 -->
    <el-dialog :title="title" :visible.sync="open_status" width="500px" append-to-body>
      <el-form ref="form_status" :model="form_status" :rules="rules_status" label-width="80px">
        <el-form-item label="班级ID" prop="classId">
          <el-input v-model="form_status.classId" disabled/>
        </el-form-item>
        <el-form-item label="班级状态" prop="classStatus">
          <el-select v-model="form_status.classStatus" placeholder="请选择班级状态">
            <el-option
              v-for="dict in dict.type.class_status"
              :key="dict.value"
              :label="dict.label"
              :value="dict.label"
            ></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm_status">确 定</el-button>
        <el-button @click="cancel_status">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listClasses, getClasses, delClasses, addClasses, updateClasses } from "@/api/system/classes";
import { listClassStatusApproval, getClassStatusApproval, delClassStatusApproval, addClassStatusApproval, updateClassStatusApproval } from "@/api/system/classStatusApproval";

export default {
  name: "Classes",
  dicts: ['class_status'],
  data() {
    return {
      //目前班级状态
      class_status: null,
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
      // classes表格数据
      classesList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      open_status: false,
      // 备注时间范围
      daterangeStartDate: [],
      // 备注时间范围
      daterangeEndDate: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        className: null,
        startDate: null,
        endDate: null,
        classStatus: null,
      },
      // 表单参数
      form: {},
      form_status: {},
      form_StatusApproval: {},
      // 表单校验
      rules: {
      },
      rules_status: {
          classStatus: [
            { validator: this.checkStatus, trigger: 'blur' }
          ],
      },
    };
  },
  created() {
    this.getList();
  },
  methods: {
    checkStatus(rules_status, value, callback) {
      // 假设 stu_status 是你要比较的特定状态值
      if (value == this.class_status) {
        // 如果 value 等于 stu_status，验证不通过
        callback(new Error('不能选择该状态'));
      } else {
        // 否则，验证通过
        callback();
      }
    },
    /** 状态申请 */
    ApplyForStatus(row) {
      this.reset_status();
      this.class_status = row.classStatus;
      const classId = row.classId || this.ids
      getClasses(classId).then(response => {
        this.form_status = response.data;
        this.open_status = true;
        this.title = "修改班级状态";
      });
    },
    /** 查询classes列表 */
    getList() {
      this.loading = true;
      this.queryParams.params = {};
      if (null != this.daterangeStartDate && '' != this.daterangeStartDate) {
        this.queryParams.params["beginStartDate"] = this.daterangeStartDate[0];
        this.queryParams.params["endStartDate"] = this.daterangeStartDate[1];
      }
      if (null != this.daterangeEndDate && '' != this.daterangeEndDate) {
        this.queryParams.params["beginEndDate"] = this.daterangeEndDate[0];
        this.queryParams.params["endEndDate"] = this.daterangeEndDate[1];
      }
      listClasses(this.queryParams).then(response => {
        this.classesList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    cancel_status() {
      this.open_status = false;
      this.reset_status();
    },
    // 表单重置
    reset() {
      this.form = {
        classId: null,
        className: null,
        startDate: null,
        endDate: null,
        classStatus: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null
      };
      this.resetForm("form");
    },
    reset_status() {
      this.form_status = {
        classId: null,
        className: null,
        startDate: null,
        endDate: null,
        classStatus: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null
      };
      this.resetForm("form_status");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.daterangeStartDate = [];
      this.daterangeEndDate = [];
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.classId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加classes";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const classId = row.classId || this.ids
      getClasses(classId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改classes";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.classId != null) {
            updateClasses(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addClasses(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    submitForm_status() {
      this.$refs.form_status.validate((valid) => {
        if (valid) {
          // 如果表单验证通过，执行提交操作
          this.form_StatusApproval.classId = this.form_status.classId
          this.form_StatusApproval.approvalStatus = '待审核'
          this.form_StatusApproval.approverContent = this.class_status + '修改成' + this.form_status.classStatus
          addClassStatusApproval(this.form_StatusApproval).then(response => {
              this.$modal.msgSuccess("申请成功");
            });
          this.open_status = false
        } else {
          // 表单验证失败
          console.error('表单验证失败');
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const classIds = row.classId || this.ids;
      this.$modal.confirm('是否确认删除classes编号为"' + classIds + '"的数据项？').then(function() {
        return delClasses(classIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/classes/export', {
        ...this.queryParams
      }, `classes_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
