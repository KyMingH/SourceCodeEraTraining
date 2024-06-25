<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="姓名" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="性别" prop="gender">
        <el-select v-model="queryParams.gender" placeholder="请选择性别" clearable>
          <el-option
            v-for="dict in dict.type.sys_user_sex"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="学员状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择学员状态" clearable>
          <el-option
            v-for="dict in dict.type.student_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="出生日期">
        <el-date-picker
          v-model="daterangeBirthDate"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="联系电话" prop="contactNumber">
        <el-input
          v-model="queryParams.contactNumber"
          placeholder="请输入联系电话"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="电子邮箱" prop="email">
        <el-input
          v-model="queryParams.email"
          placeholder="请输入电子邮箱"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="紧急系人" prop="emergencyContact">
        <el-input
          v-model="queryParams.emergencyContact"
          placeholder="请输入紧急联系人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="紧急联系" prop="emergencyContactNumber">
        <el-input
          v-model="queryParams.emergencyContactNumber"
          placeholder="请输入紧急联系人电话"
          clearable
          @keyup.enter.native="handleQuery"
        />
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
          v-hasPermi="['system:students:add']"
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
          v-hasPermi="['system:students:edit']"
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
          v-hasPermi="['system:students:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:students:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="studentsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="学员ID" align="center" prop="studentId" />
      <el-table-column label="姓名" align="center" prop="name" />
      <el-table-column label="性别" align="center" prop="gender">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_user_sex" :value="scope.row.gender"/>
        </template>
      </el-table-column>
      <el-table-column label="学员状态" align="center" prop="status">
        <template slot-scope="scope">
          <!-- 使用三元运算符或 v-if-else 来根据状态绑定不同的类 -->
          <el-tag :class="`status-${scope.row.status}`" style="width: 70px;">
            <!-- 这里假设 dict-tag 组件能够根据 value 显示对应的标签文本 -->
            <dict-tag :options="dict.type.student_status" :value="scope.row.status"/>
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column label="出生日期" align="center" prop="birthDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.birthDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="联系电话" align="center" prop="contactNumber" width="110px" />
      <el-table-column label="电子邮箱" align="center" prop="email" width="160px"/>
      <el-table-column label="紧急联系人" align="center" prop="emergencyContact" />
      <el-table-column label="紧急联系人电话" align="center" prop="emergencyContactNumber" width="110px" />
      <el-table-column label="备注" align="center" prop="remark" width="300px"/>
      <el-table-column  fixed="right" label="操作" align="center" class-name="small-padding fixed-width" width="250px">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:students:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:students:remove']"
          >删除</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-s-custom"
            @click="ApplyForStatus(scope.row)"
            v-hasPermi="['system:students:remove']"
            :disabled="scope.row.status == '试听阶段'"
          >状态转换申请</el-button>
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

    <!-- 添加或修改学员基本信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="性别" prop="gender">
          <el-select v-model="form.gender" placeholder="请选择性别">
            <el-option
              v-for="dict in dict.type.sys_user_sex"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="学员状态" prop="status">
          <el-select v-model="form.status" placeholder="请选择学员状态">
            <el-option
              v-for="dict in dict.type.student_status"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="出生日期" prop="birthDate">
          <el-date-picker clearable
            v-model="form.birthDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择出生日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="联系电话" prop="contactNumber">
          <el-input v-model="form.contactNumber" placeholder="请输入联系电话" />
        </el-form-item>
        <el-form-item label="电子邮箱" prop="email">
          <el-input v-model="form.email" placeholder="请输入电子邮箱" />
        </el-form-item>
        <el-form-item label="紧急联系人" prop="emergencyContact">
          <el-input v-model="form.emergencyContact" placeholder="请输入紧急联系人" />
        </el-form-item>
        <el-form-item label="紧急联系人电话" prop="emergencyContactNumber">
          <el-input v-model="form.emergencyContactNumber" placeholder="请输入紧急联系人电话" />
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
    <!-- 状态转换申请 -->
    <el-dialog :title="title" :visible.sync="open_status" width="500px" append-to-body>
      <el-form ref="form_status" :model="form_status" :rules="rules_status" label-width="80px">
        <el-form-item label="学员ID" prop="studentId">
          <el-input v-model="form_status.studentId" disabled/>
        </el-form-item>
        <el-form-item label="学员转换状态" prop="status">
          <el-select v-model="form_status.status" placeholder="请选择学员状态">
            <el-option
              v-for="dict in dict.type.student_status"
              :key="dict.value"
              v-if="dict.label !== '试听阶段'"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm_status">确 定</el-button>
        <el-button @click="cancel_status">取 消</el-button>
      </div>
    </el-dialog>
    <!-- 添加或修改student_application对话框 -->
    <el-dialog :title="title" :visible.sync="open_application" width="500px" append-to-body>
      <el-form ref="form_application" :model="form_application" :rules="rules_application" label-width="80px">
        <el-form-item label="学员ID" prop="studentId">
          <el-input v-model="form_application.studentId" disabled/>
        </el-form-item>
        <el-form-item label="申请类型" prop="applicationType">
          <el-select v-model="form_application.applicationType" placeholder="请选择申请类型">
            <el-option
              v-for="dict in dict.type.application_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
              disabled
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="申请日期" prop="applicationDate">
          <el-date-picker clearable
            v-model="form_application.applicationDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择申请日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="审批状态" prop="approvalStatus">
          <el-select v-model="form_application.approvalStatus" placeholder="请选择审批状态">
            <el-option
              v-for="dict in dict.type.approval_status"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
              disabled
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form_application.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm_application">确 定</el-button>
        <el-button @click="cancel_application">取 消</el-button>
      </div>
    </el-dialog>
     <!-- 添加或修改student_leave对话框 -->
     <el-dialog :title="title" :visible.sync="open_leave" width="500px" append-to-body>
      <el-form ref="form_leave" :model="form_leave" :rules="rules_leave" label-width="80px">
        <el-form-item label="学员ID" prop="studentId">
          <el-input v-model="form_leave.studentId" placeholder="请输入学员ID" disabled/>
        </el-form-item>
        <el-form-item label="请假类型">
          <editor v-model="form_leave.leaveType" :min-height="192"/>
        </el-form-item>
        <el-form-item label="请假开始日期" prop="leaveStartDate">
          <el-date-picker clearable
            v-model="form_leave.leaveStartDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择请假开始日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="请假结束日期" prop="leaveEndDate">
          <el-date-picker clearable
            v-model="form_leave.leaveEndDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择请假结束日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="审批状态" prop="approvalStatus">
          <el-select v-model="form_leave.approvalStatus" placeholder="请选择审批状态">
            <el-option
              v-for="dict in dict.type.approval_status"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
              disabled
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form_leave.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm_leave">确 定</el-button>
        <el-button @click="cancel_leave">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listStudents, getStudents, delStudents, addStudents, updateStudents } from "@/api/system/students";
import { listLeave, getLeave, delLeave, addLeave, updateLeave } from "@/api/system/leave";
import { listApplication, getApplication, delApplication, addApplication, updateApplication } from "@/api/system/application";
import { listLeaveApproval, getLeaveApproval, delLeaveApproval, addLeaveApproval, updateLeaveApproval } from "@/api/system/leaveApproval";
import { listStudentProcessApproval, getStudentProcessApproval, delStudentProcessApproval, addStudentProcessApproval, updateStudentProcessApproval } from "@/api/system/studentProcessApproval";


export default {
  name: "Students",
  dicts: ['sys_user_sex', 'student_status', 'approval_status', 'application_type', 'approval_status2'],
  data() {
    return {
      //目前学生状态
      stu_status: '',
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
      // 学员基本信息表格数据
      studentsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      open_status: false,
      open_leave: false,
      open_application: false,
      // 备注时间范围
      daterangeBirthDate: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        gender: null,
        status: null,
        birthDate: null,
        contactNumber: null,
        email: null,
        emergencyContact: null,
        emergencyContactNumber: null,
      },
      // 表单参数
      form: {},
      form_status: {},
      form_leave: {},
      form_application: {},
      form_LeaveApproval: {},
      form_ProcessApproval: {},
      // 表单校验
      rules: {
        name: [
          { required: true, message: "姓名不能为空", trigger: "blur" }
        ]
      },
      rules_status: {
          status: [
            { validator: this.checkStatus, trigger: 'blur' }
          ],
      },
      rules_leave: {

      },
      rules_application: {

      },
    };
  },
  created() {
    this.getList();
  },
  methods: {
    checkStatus(rules_status, value, callback) {
      // 假设 stu_status 是你要比较的特定状态值
      if (value == this.stu_status) {
        // 如果 value 等于 stu_status，验证不通过
        callback(new Error('不能选择该状态'));
      } else {
        // 否则，验证通过
        callback();
      }
    },
    /** 状态申请按钮 */
    ApplyForStatus(row) {
      this.stu_status = row.status;
      this.reset_status();
      const studentId = row.studentId || this.ids
      getStudents(studentId).then(response => {
        this.form_status = response.data;
        this.open_status = true;
        this.title = "修改学员状态信息";
      });
    },
    /** 查询学员基本信息列表 */
    getList() {
      this.loading = true;
      this.queryParams.params = {};
      if (null != this.daterangeBirthDate && '' != this.daterangeBirthDate) {
        this.queryParams.params["beginBirthDate"] = this.daterangeBirthDate[0];
        this.queryParams.params["endBirthDate"] = this.daterangeBirthDate[1];
      }
      listStudents(this.queryParams).then(response => {
        this.studentsList = response.rows;
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
    cancel_leave() {
      this.open_leave = false;
      this.reset_leave();
    },
    cancel_application() {
      this.open_application = false;
      this.reset_application();
    },
    // 表单重置
    reset() {
      this.form = {
        studentId: null,
        name: null,
        gender: null,
        status: null,
        birthDate: null,
        contactNumber: null,
        email: null,
        emergencyContact: null,
        emergencyContactNumber: null,
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
        studentId: null,
        name: null,
        gender: null,
        status: null,
        birthDate: null,
        contactNumber: null,
        email: null,
        emergencyContact: null,
        emergencyContactNumber: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null
      };
      this.resetForm("form_status");
    },
    reset_leave() {
      this.form_leave = {
        leaveId: null,
        studentId: null,
        leaveType: null,
        leaveStartDate: null,
        leaveEndDate: null,
        approvalStatus: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null
      };
      this.resetForm("form_leave");
    },
    reset_application() {
      this.form = {
        applicationId: null,
        studentId: null,
        applicationType: null,
        applicationDate: null,
        approvalStatus: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null
      };
      this.resetForm("form_application");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.daterangeBirthDate = [];
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.studentId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加学员基本信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const studentId = row.studentId || this.ids
      getStudents(studentId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改学员基本信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.studentId != null) {
            updateStudents(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addStudents(this.form).then(response => {
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
          if (this.form_status.status == '05')
          {   
              this.open_status = false;
              this.open_leave = true;
              this.title = '申请请假表'
              this.reset_leave();
              this.form_leave.studentId = this.form_status.studentId
              this.form_leave.approvalStatus = '审核中'
          }else{
              this.open_status = false;
              this.open_application = true;
              this.title = '过程请假表'
              this.reset_application();
              this.form_application.studentId = this.form_status.studentId
              this.form_application.applicationType = this.form_status.status
              this.form_application.approvalStatus = '审核中'
          }
        } else {
          // 表单验证失败
          console.error('表单验证失败');
        }
      });
    },
    submitForm_leave() {
      // 添加请假记录
      addLeave(this.form_leave).then(response => {
        // 确保 response.data 包含新的 leave_id
        if (response.data) {
          this.form_LeaveApproval.leaveId = response.data; // 设置 leave_id 用于审批记录
          this.$modal.msgSuccess("申请成功");
          this.open_leave = false;
          
          // 请假记录添加成功后，设置审批状态为 '待审核'
          this.form_LeaveApproval.approvalStatus = '待审核';
          
          // 添加审批记录
          addLeaveApproval(this.form_LeaveApproval).then(response => {
            // 处理审批记录添加成功的逻辑
            this.$modal.msgSuccess("审批申请提交成功");
            // 这里可以添加关闭审批表单的逻辑，如果需要的话
          }).catch(error => {
            // 处理审批记录添加失败的错误
            this.$modal.msgError("审批申请提交失败：" + error.message);
          });
        } else {
          // 如果 response.data 不存在，说明添加请假记录失败
          this.$modal.msgError("添加请假记录失败，请重试");
        }
      }).catch(error => {
        // 处理添加请假记录失败的错误
        this.$modal.msgError("添加请假记录失败：" + error.message);
      });
    },
    submitForm_application() {
      this.$refs["form_application"].validate(valid => {
        if (valid) {
            addApplication(this.form_application).then(response => {
              this.$modal.msgSuccess("申请成功");
              this.open_application = false;
            });
            this.form_ProcessApproval.studentId = this.form_application.studentId;
            this.form_ProcessApproval.processType = this.form_application.applicationType;
            this.form_ProcessApproval.approvalStatus = '待审核';
            addStudentProcessApproval(this.form_ProcessApproval).then(response => {
            });
          }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const studentIds = row.studentId || this.ids;
      this.$modal.confirm('是否确认删除学员基本信息编号为"' + studentIds + '"的数据项？').then(function() {
        return delStudents(studentIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/students/export', {
        ...this.queryParams
      }, `students_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
<style>
.status-00 {
  background-color: #FFD700; /* 金色，代表财富和机会，适合 '试听阶段' */
  color: #fff;
  width: 60px; /* 固定宽度，根据需要调整 */
}

.status-01 {
  background-color: #4CAF50; /* 绿色，代表成长和成功，适合 '正式学员' */
  color: #fff;
  width: 60px;
}

.status-02 {
  background-color: #f44336; /* 红色，代表警示和重视，适合 '留级' */
  color: #fff;
  width: 60px;
}

.status-03 {
  background-color: #2196F3; /* 蓝色，代表平静和稳定，适合 '休学' */
  color: #fff;
  width: 60px;
}

.status-04 {
  background-color: #9C27B0; /* 紫色，代表结束和新开始，适合 '退学' */
  color: #fff;
  width: 60px;
}

.status-05 {
  background-color: #FF9800; /* 橙色，代表活跃和注意，适合 '请假中' */
  color: #fff;
  width: 60px;
}
</style>