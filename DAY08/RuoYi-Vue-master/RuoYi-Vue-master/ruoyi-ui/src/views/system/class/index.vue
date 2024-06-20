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
      <el-form-item label="班级类型" prop="classType">
        <el-select v-model="queryParams.classType" placeholder="请选择班级类型" clearable>
          <el-option
            v-for="dict in dict.type.education_class_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="开班时间" prop="beginTime">
        <el-date-picker clearable
          v-model="queryParams.beginTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择开班时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="实际开班">
        <el-date-picker
          v-model="daterangeBeginTimeReal"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="结课时间" prop="endTime">
        <el-date-picker clearable
          v-model="queryParams.endTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择结课时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="实际结课">
        <el-date-picker
          v-model="daterangeEndTimeReal"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="班主任" prop="headteacher">
        <el-input
          v-model="queryParams.headteacher"
          placeholder="请输入班主任"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="就业老师" prop="teacher">
        <el-input
          v-model="queryParams.teacher"
          placeholder="请输入就业老师"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="班级人数" prop="classSize">
        <el-input
          v-model="queryParams.classSize"
          placeholder="请输入班级人数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="状态" prop="state">
        <el-input
          v-model="queryParams.state"
          placeholder="请输入状态"
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
          v-hasPermi="['system:class:add']"
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
          v-hasPermi="['system:class:edit']"
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
          v-hasPermi="['system:class:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:class:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="classList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" align="center" prop="id" />
      <el-table-column label="班级名称" align="center" prop="className" />
      <el-table-column label="班级类型" align="center" prop="classType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.education_class_type" :value="scope.row.classType"/>
        </template>
      </el-table-column>
      <el-table-column label="开班时间" align="center" prop="beginTime" width="150">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.beginTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="实际开班" align="center" prop="beginTimeReal" width="150">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.beginTimeReal, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="结课时间" align="center" prop="endTime" width="150">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.endTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="实际结课" align="center" prop="endTimeReal" width="150">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.endTimeReal, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="班主任" align="center" prop="headteacher" />
      <el-table-column label="就业老师" align="center" prop="teacher" />
      <el-table-column label="班级人数" align="center" prop="classSize" />
      <el-table-column label="状态" align="center">
        <template slot-scope="scope">
          <!-- 根据 scope.row.state 的值动态设置 el-tag 的 type 属性 -->
          <el-tag :type="getStateType(scope.row.state)">
            {{ scope.row.state }}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark" width="150" />
      <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width" width="220">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:class:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:class:remove']"
          >删除</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-s-flag"
            v-bind:disabled = "scope.row.beginTimeReal !== null"
            @click="handleBegin(scope.row)"
            v-hasPermi="['system:class:edit']"
          >开课</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-finished"
            v-bind:disabled = "!(scope.row.beginTimeReal !== null&scope.row.endTimeReal == null)"
            @click="handleEnd(scope.row)"
            v-hasPermi="['system:class:remove']"
          >结课</el-button>
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

    <!-- 添加或修改班级管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="班级名称" prop="className">
          <el-input v-model="form.className" placeholder="请输入班级名称" />
        </el-form-item>
        <el-form-item label="班级类型" prop="classType">
          <el-select v-model="form.classType" placeholder="请选择班级类型">
            <el-option
              v-for="dict in dict.type.education_class_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="开班时间" prop="beginTime">
          <el-date-picker clearable
            v-model="form.beginTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择开班时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="实际开班时间" prop="beginTimeReal">
          <el-date-picker clearable
            v-model="form.beginTimeReal"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择实际开班时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="结课时间" prop="endTime">
          <el-date-picker clearable
            v-model="form.endTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择结课时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="实际结课时间" prop="endTimeReal">
          <el-date-picker clearable
            v-model="form.endTimeReal"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择实际结课时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="班主任" prop="headteacher">
          <el-input v-model="form.headteacher" placeholder="请输入班主任" />
        </el-form-item>
        <el-form-item label="就业老师" prop="teacher">
          <el-input v-model="form.teacher" placeholder="请输入就业老师" />
        </el-form-item>
        <el-form-item label="班级人数" prop="classSize">
          <el-input v-model="form.classSize" placeholder="请输入班级人数" />
        </el-form-item>
        <el-form-item label="状态" prop="state">
          <el-input v-model="form.state" placeholder="请输入状态" />
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
import { listClass, getClass, delClass, addClass, updateClass, beginClass, endClass } from "@/api/system/class";

export default {
  name: "Class",
  dicts: ['education_class_type'],
  data() {
    return {
      learning: false,
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
      // 班级管理表格数据
      classList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 备注时间范围
      daterangeBeginTimeReal: [],
      // 备注时间范围
      daterangeEndTimeReal: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        className: null,
        classType: null,
        beginTime: null,
        beginTimeReal: null,
        endTime: null,
        endTimeReal: null,
        headteacher: null,
        teacher: null,
        classSize: null,
        state: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        className: [
          { required: true, message: "班级名称不能为空", trigger: "blur" }
        ],
        classType: [
          { required: true, message: "班级类型不能为空", trigger: "change" }
        ],
        beginTime: [
          { required: true, message: "开班时间不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    getStateType(stateValue) {
      switch (stateValue) {
        case '已开课':
          return 'success'; // 假设 'active' 状态用绿色表示
        case '未开课':
          return 'info'; // 假设 'inactive' 状态用蓝色表示
        case '已结课':
          return 'danger'; // 假设 'pending' 状态用红色表示
        default:
          return 'warning'; // 默认状态用黄色表示
      }
  },
    /** 查询班级管理列表 */
    getList() {
      this.loading = true;
      this.queryParams.params = {};
      if (null != this.daterangeBeginTimeReal && '' != this.daterangeBeginTimeReal) {
        this.queryParams.params["beginBeginTimeReal"] = this.daterangeBeginTimeReal[0];
        this.queryParams.params["endBeginTimeReal"] = this.daterangeBeginTimeReal[1];
      }
      if (null != this.daterangeEndTimeReal && '' != this.daterangeEndTimeReal) {
        this.queryParams.params["beginEndTimeReal"] = this.daterangeEndTimeReal[0];
        this.queryParams.params["endEndTimeReal"] = this.daterangeEndTimeReal[1];
      }
      listClass(this.queryParams).then(response => {
        this.classList = response.rows;
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
        className: null,
        classType: null,
        beginTime: null,
        beginTimeReal: null,
        endTime: null,
        endTimeReal: null,
        headteacher: null,
        teacher: null,
        classSize: null,
        state: null,
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
      this.daterangeBeginTimeReal = [];
      this.daterangeEndTimeReal = [];
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
      this.title = "添加班级管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getClass(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改班级管理";
      });
    },
    /** 开课按钮 */
    handleBegin(row){
      this.reset();
      const id = row.id || this.ids
      getClass(id).then(response => {
        this.form = response.data;
        this.title = "开课";
        beginClass(this.form).then(response => {
          this.$modal.msgSuccess("修改成功");
          this.getList();
        });
      })
    },
    /** 结课按钮 */
    handleEnd(row){
      this.reset();
      const id = row.id || this.ids
      getClass(id).then(response => {
        this.form = response.data;
        this.title = "结课";
        endClass(this.form).then(response => {
          this.$modal.msgSuccess("修改成功");
          this.getList();
        });
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateClass(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addClass(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除班级管理编号为"' + ids + '"的数据项？').then(function() {
        return delClass(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/class/export', {
        ...this.queryParams
      }, `class_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
