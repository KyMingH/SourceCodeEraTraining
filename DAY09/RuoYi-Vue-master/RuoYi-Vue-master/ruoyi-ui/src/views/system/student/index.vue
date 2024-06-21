<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="学生姓名" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入学生姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学生性别" prop="gender">
        <el-select v-model="queryParams.gender" placeholder="请选择学生性别" clearable>
          <el-option
            v-for="dict in dict.type.sys_user_sex"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="大学名称" prop="nameUniversity">
        <el-input
          v-model="queryParams.nameUniversity"
          placeholder="请输入大学名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="大学专业" prop="collegeMajors">
        <el-input
          v-model="queryParams.collegeMajors"
          placeholder="请输入大学专业"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学生学历" prop="degree">
        <el-input
          v-model="queryParams.degree"
          placeholder="请输入学生学历"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="毕业时间">
        <el-date-picker
          v-model="daterangeGraduationTime"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="联系电话" prop="phoneNumber">
        <el-input
          v-model="queryParams.phoneNumber"
          placeholder="请输入联系电话"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="身份证号码" prop="idNumber">
        <el-input
          v-model="queryParams.idNumber"
          placeholder="请输入身份证号码"
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
          v-hasPermi="['system:student:add']"
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
          v-hasPermi="['system:student:edit']"
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
          v-hasPermi="['system:student:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:student:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="studentList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" align="center" prop="id" width="50"/>
      <el-table-column label="学生姓名" align="center" prop="name" />
      <el-table-column label="所在班级" align="center" prop="currentClass" />
      <el-table-column label="学生性别" align="center" prop="gender">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_user_sex" :value="scope.row.gender"/>
        </template>
      </el-table-column>
      <el-table-column label="大学名称" align="center" prop="nameUniversity" />
      <el-table-column label="大学专业" align="center" prop="collegeMajors" />
      <el-table-column label="学生学历" align="center" prop="degree" />
      <el-table-column label="毕业时间" align="center" prop="graduationTime" width="120">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.graduationTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="是否全日制" align="center" prop="fullTimeStatus" />
      <el-table-column label="联系电话" align="center" prop="phoneNumber" width="110"/>
      <el-table-column label="身份证号码" align="center" prop="idNumber" width="180"/>
      <el-table-column label="班主任" align="center" prop="homeroomTeacher" />
      <el-table-column label="备注" align="center" prop="remark" width="180"/>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width" width="200" fixed="right">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:student:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:student:remove']"
          >删除</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-sort"
            @click="handleSwitch(scope.row)"
            v-hasPermi="['system:student:edit']"
          >转班</el-button>
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

    <!-- 添加或修改学生管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="学生姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入学生姓名" />
        </el-form-item>
        <el-form-item label="学生性别" prop="gender">
          <el-select v-model="form.gender" placeholder="请选择学生性别">
            <el-option
              v-for="dict in dict.type.sys_user_sex"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="大学名称" prop="nameUniversity">
          <el-input v-model="form.nameUniversity" placeholder="请输入大学名称" />
        </el-form-item>
        <el-form-item label="大学专业" prop="collegeMajors">
          <el-input v-model="form.collegeMajors" placeholder="请输入大学专业" />
        </el-form-item>
        <el-form-item label="学生学历" prop="degree">
          <el-input v-model="form.degree" placeholder="请输入学生学历" />
        </el-form-item>
        <el-form-item label="毕业时间" prop="graduationTime">
          <el-date-picker clearable
            v-model="form.graduationTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择毕业时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="全日制">
          <template>
            <el-radio v-model="form.fullTimeStatus" label="是">是</el-radio>
            <el-radio v-model="form.fullTimeStatus" label="否">否</el-radio>
          </template>
        </el-form-item>
        <el-form-item label="联系电话" prop="phoneNumber">
          <el-input v-model="form.phoneNumber" placeholder="请输入联系电话" />
        </el-form-item>
        <el-form-item label="身份证号" prop="idNumber">
          <el-input v-model="form.idNumber" placeholder="请输入身份证号码" />
        </el-form-item>
        <el-form-item label="所在班级">
          <el-select v-model="form.currentClass" placeholder="所在班级">
            <el-option
              v-for="class_ in classList"
              :key="class_.id"
              :label="class_.className"
              :value="class_.className"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
    <!-- 记录转班记录对话框 -->
    <el-dialog :title="title" :visible.sync="switch_open" width="500px" append-to-body>
      <el-form ref="switch_form" :model="switch_form" :rules="switch_rules" label-width="80px">
        <el-form-item label="学生ID" prop="studentId">
          <el-input v-model="switch_form.studentId" disabled/>
        </el-form-item>
        <el-form-item label="转班时间" prop="transferDate">
          <el-date-picker clearable
            v-model="switch_form.transferDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择转班时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="转出班级" prop="fromClass">
          <el-select v-model="switch_form.fromClass" placeholder="转出班级" disabled>
            <el-option
              v-for="class_ in classList"
              :key="class_.id"
              :label="class_.className"
              :value="class_.className"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="转入班级" prop="toClass">
          <el-select v-model="switch_form.toClass" placeholder="转入班级">
            <el-option
              v-for="class_ in classList"
              :key="class_.id"
              :label="class_.className"
              :value="class_.className"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="转班原因" prop="reason">
          <el-input v-model="switch_form.reason" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="switch_submitForm">确 定</el-button>
        <el-button @click="switch_cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listStudent, getStudent, delStudent, addStudent, updateStudent } from "@/api/system/student";
import { listClass, updateClass } from "@/api/system/class";
import { updateRecords, addRecords} from "@/api/system/records"
export default {
  name: "Student",
  dicts: ['sys_user_sex'],
  data() {
    return {
      //转班表格
      switch_open: false,
      //班级列表
      classList: [],
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
      // 学生管理表格数据
      studentList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 备注时间范围
      daterangeGraduationTime: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        gender: null,
        nameUniversity: null,
        collegeMajors: null,
        degree: null,
        graduationTime: null,
        fullTimeStatus: null,
        phoneNumber: null,
        idNumber: null,
        currentClass: null,
        homeroomTeacher: null,
      },
      // 表单参数
      form: {},
      switch_form: {},
      // 表单校验
      switch_rules:{
        studentId: [
          { required: true, message: "学生ID不能为空", trigger: "blur" }
        ],
        fromClass: [
          { required: true, message: "转出班级不能为空", trigger: "change" }
        ],
        toClass: [
          { required: true, message: "转入班级不能为空", trigger: "change" }
        ],
        transferDate: [
          { required: true, message: "转班时间不能为空", trigger: "blur" }
        ],
      },
      rules: {
        name: [
          { required: true, message: "学生姓名不能为空", trigger: "blur" }
        ],
        gender: [
          { required: true, message: "学生性别不能为空", trigger: "change" }
        ],
        nameUniversity: [
          { required: true, message: "大学名称不能为空", trigger: "blur" }
        ],
        collegeMajors: [
          { required: true, message: "大学专业不能为空", trigger: "blur" }
        ],
        degree: [
          { required: true, message: "学生学历不能为空", trigger: "blur" }
        ],
        graduationTime: [
          { required: true, message: "毕业时间不能为空", trigger: "blur" }
        ],
        fullTimeStatus: [
          { required: true, message: "是否全日制不能为空", trigger: "change" }
        ],
        phoneNumber: [
          { required: true, message: "联系电话不能为空", trigger: "blur" }
        ],
        idNumber: [
          { required: true, message: "身份证号码不能为空", trigger: "blur" }
        ],
        currentClass: [
          { required: true, message: "所在班级不能为空", trigger: "change" }
        ],
        homeroomTeacher: [
          { required: true, message: "班主任不能为空", trigger: "change" }
        ],
      }
    };
  },
  created() {
    this.getList();
    this.getClassList();
  },
  methods: {
    /** 转班按钮 */
    handleSwitch(row){
      this.form = row
      this.switch_form.studentId = row.idNumber
      this.switch_open = true
      this.switch_form.fromClass = row.currentClass
    },
    /** 获取班级列表 */
    getClassList(){
      this.loading = true;
      this.queryParams.params = {};
      if (null != this.daterangeGraduationTime && '' != this.daterangeGraduationTime) {
        this.queryParams.params["beginGraduationTime"] = this.daterangeGraduationTime[0];
        this.queryParams.params["endGraduationTime"] = this.daterangeGraduationTime[1];
      }
      listClass(this.queryParams).then(response => {
        this.classList = response.rows;
        this.total = response.total;
        this.loading = false;
      })
    },
    /** 查询学生管理列表 */
    getList() {
      this.loading = true;
      this.queryParams.params = {};
      if (null != this.daterangeGraduationTime && '' != this.daterangeGraduationTime) {
        this.queryParams.params["beginGraduationTime"] = this.daterangeGraduationTime[0];
        this.queryParams.params["endGraduationTime"] = this.daterangeGraduationTime[1];
      }
      listStudent(this.queryParams).then(response => {
        this.studentList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 取消转班按钮
    switch_cancel() {
      this.switch_open = false;
      this.switch_reset();
    },
    // 转班表单重置
    switch_reset() {
      this.switch_form= {
        id: null,
        studentId: null,
        fromClass: null,
        toClass: null,
        transferDate: null,
        reason: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null
      };
      this.resetForm("switch_form");
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        name: null,
        gender: null,
        nameUniversity: null,
        collegeMajors: null,
        degree: null,
        graduationTime: null,
        fullTimeStatus: null,
        phoneNumber: null,
        idNumber: null,
        currentClass: null,
        homeroomTeacher: null,
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
      this.daterangeGraduationTime = [];
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加学生管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getStudent(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改学生管理";
      });
    },
    /** 转班提交按钮 */
    switch_submitForm() {
      this.form.currentClass = this.switch_form.toClass
      updateStudent(this.form).then(response => {
            });
      addRecords(this.switch_form).then(response => {
              this.$modal.msgSuccess("转班成功");
              this.switch_open = false;
              this.getList();
            })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateStudent(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addStudent(this.form).then(response => {
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
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除学生管理编号为"' + ids + '"的数据项？').then(function() {
        return delStudent(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/student/export', {
        ...this.queryParams
      }, `student_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
