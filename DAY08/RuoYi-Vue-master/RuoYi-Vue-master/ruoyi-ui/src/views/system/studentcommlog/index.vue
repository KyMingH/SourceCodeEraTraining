<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="沟通时间">
        <el-date-picker
          v-model="daterangeCommunicationTime"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="沟通学生" prop="studentInvolved">
        <el-input
          v-model="queryParams.studentInvolved"
          placeholder="请输入沟通学生"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="沟通老师" prop="teacherInvolved">
        <el-input
          v-model="queryParams.teacherInvolved"
          placeholder="请输入沟通老师"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="计划沟通">
        <el-date-picker
          v-model="daterangeNextCommunicationSchedule"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="沟通效果" prop="communicationEffectivenessRating">
        <el-select v-model="queryParams.communicationEffectivenessRating" placeholder="请选择沟通效果" clearable>
          <el-option
            v-for="dict in dict.type.communication_effectiveness_rating"
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
          v-hasPermi="['system:studentcommlog:add']"
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
          v-hasPermi="['system:studentcommlog:edit']"
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
          v-hasPermi="['system:studentcommlog:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:studentcommlog:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="studentcommlogList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" align="center" prop="id" />
      <el-table-column label="沟通时间" align="center" prop="communicationTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.communicationTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="沟通学生" align="center" prop="studentInvolved" />
      <el-table-column label="沟通老师" align="center" prop="teacherInvolved" />
      <el-table-column label="沟通问题" align="center" prop="communicationIssue" />
      <el-table-column label="沟通反馈" align="center" prop="feedbackReceived" />
      <el-table-column label="计划下次沟通日期" align="center" prop="nextCommunicationSchedule" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.nextCommunicationSchedule, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="沟通效果" align="center" prop="communicationEffectivenessRating">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.communication_effectiveness_rating" :value="scope.row.communicationEffectivenessRating"/>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width" width="120">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:studentcommlog:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:studentcommlog:remove']"
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

    <!-- 添加或修改沟通记录对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="沟通时间" prop="communicationTime">
          <el-date-picker clearable
            v-model="form.communicationTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择沟通时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="沟通学生" prop="studentInvolved">
          <el-input v-model="form.studentInvolved" placeholder="请输入沟通学生" />
        </el-form-item>
        <el-form-item label="沟通老师" prop="teacherInvolved">
          <el-input v-model="form.teacherInvolved" placeholder="请输入沟通老师" />
        </el-form-item>
        <el-form-item label="沟通问题" prop="communicationIssue">
          <el-input v-model="form.communicationIssue" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="沟通反馈" prop="feedbackReceived">
          <el-input v-model="form.feedbackReceived" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="计划下次沟通日期" prop="nextCommunicationSchedule">
          <el-date-picker clearable
            v-model="form.nextCommunicationSchedule"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择计划下次沟通日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="沟通效果" prop="communicationEffectivenessRating">
          <el-select v-model="form.communicationEffectivenessRating" placeholder="请选择沟通效果">
            <el-option
              v-for="dict in dict.type.communication_effectiveness_rating"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
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
  </div>
</template>

<script>
import { listStudentcommlog, getStudentcommlog, delStudentcommlog, addStudentcommlog, updateStudentcommlog } from "@/api/system/studentcommlog";

export default {
  name: "Studentcommlog",
  dicts: ['communication_effectiveness_rating'],
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
      // 沟通记录表格数据
      studentcommlogList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 备注时间范围
      daterangeCommunicationTime: [],
      // 备注时间范围
      daterangeNextCommunicationSchedule: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        communicationTime: null,
        studentInvolved: null,
        teacherInvolved: null,
        communicationIssue: null,
        feedbackReceived: null,
        nextCommunicationSchedule: null,
        communicationEffectivenessRating: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        communicationTime: [
          { required: true, message: "沟通时间不能为空", trigger: "blur" }
        ],
        studentInvolved: [
          { required: true, message: "沟通学生不能为空", trigger: "blur" }
        ],
        teacherInvolved: [
          { required: true, message: "沟通老师不能为空", trigger: "blur" }
        ],
        communicationIssue: [
          { required: true, message: "沟通问题不能为空", trigger: "blur" }
        ],
        feedbackReceived: [
          { required: true, message: "沟通反馈不能为空", trigger: "blur" }
        ],
        communicationEffectivenessRating: [
          { required: true, message: "沟通效果不能为空", trigger: "change" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询沟通记录列表 */
    getList() {
      this.loading = true;
      this.queryParams.params = {};
      if (null != this.daterangeCommunicationTime && '' != this.daterangeCommunicationTime) {
        this.queryParams.params["beginCommunicationTime"] = this.daterangeCommunicationTime[0];
        this.queryParams.params["endCommunicationTime"] = this.daterangeCommunicationTime[1];
      }
      if (null != this.daterangeNextCommunicationSchedule && '' != this.daterangeNextCommunicationSchedule) {
        this.queryParams.params["beginNextCommunicationSchedule"] = this.daterangeNextCommunicationSchedule[0];
        this.queryParams.params["endNextCommunicationSchedule"] = this.daterangeNextCommunicationSchedule[1];
      }
      listStudentcommlog(this.queryParams).then(response => {
        this.studentcommlogList = response.rows;
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
        id: null,
        communicationTime: null,
        studentInvolved: null,
        teacherInvolved: null,
        communicationIssue: null,
        feedbackReceived: null,
        nextCommunicationSchedule: null,
        communicationEffectivenessRating: null,
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
      this.daterangeCommunicationTime = [];
      this.daterangeNextCommunicationSchedule = [];
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
      this.title = "添加沟通记录";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getStudentcommlog(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改沟通记录";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateStudentcommlog(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addStudentcommlog(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除沟通记录编号为"' + ids + '"的数据项？').then(function() {
        return delStudentcommlog(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/studentcommlog/export', {
        ...this.queryParams
      }, `studentcommlog_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
