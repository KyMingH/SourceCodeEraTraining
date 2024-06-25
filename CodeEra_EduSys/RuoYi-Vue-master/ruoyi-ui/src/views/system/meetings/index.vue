<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="会议类型" prop="meetingType">
        <el-select v-model="queryParams.meetingType" placeholder="请选择会议类型" clearable>
          <el-option
            v-for="dict in dict.type.meeting_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="会议日期">
        <el-date-picker
          v-model="daterangeMeetingDate"
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
          v-hasPermi="['system:meetings:add']"
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
          v-hasPermi="['system:meetings:edit']"
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
          v-hasPermi="['system:meetings:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:meetings:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="meetingsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="会议ID" align="center" prop="meetingId" />
      <el-table-column label="班级ID" align="center" prop="classId" />
      <el-table-column label="会议类型" align="center" prop="meetingType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.meeting_type" :value="scope.row.meetingType"/>
        </template>
      </el-table-column>
      <el-table-column label="会议日期" align="center" prop="meetingDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.meetingDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="会议内容" align="center" prop="meetingContent" />
      <el-table-column label="会议结果或决议" align="center" prop="meetingOutcome" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:meetings:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:meetings:remove']"
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

    <!-- 添加或修改ClassMeetings对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="班级ID" prop="classId">
          <el-input v-model="form.classId" placeholder="请输入班级ID" />
        </el-form-item>
        <el-form-item label="会议类型" prop="meetingType">
          <el-select v-model="form.meetingType" placeholder="请选择会议类型">
            <el-option
              v-for="dict in dict.type.meeting_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="会议日期" prop="meetingDate">
          <el-date-picker clearable
            v-model="form.meetingDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择会议日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="会议内容">
          <editor v-model="form.meetingContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="会议结果或决议" prop="meetingOutcome">
          <el-input v-model="form.meetingOutcome" type="textarea" placeholder="请输入内容" />
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
import { listMeetings, getMeetings, delMeetings, addMeetings, updateMeetings } from "@/api/system/meetings";

export default {
  name: "Meetings",
  dicts: ['meeting_type'],
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
      // ClassMeetings表格数据
      meetingsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 备注时间范围
      daterangeMeetingDate: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        meetingType: null,
        meetingDate: null,
        meetingContent: null,
        meetingOutcome: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        classId: [
          { required: true, message: "班级ID不能为空", trigger: "blur" }
        ],
        meetingDate: [
          { required: true, message: "会议日期不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询ClassMeetings列表 */
    getList() {
      this.loading = true;
      this.queryParams.params = {};
      if (null != this.daterangeMeetingDate && '' != this.daterangeMeetingDate) {
        this.queryParams.params["beginMeetingDate"] = this.daterangeMeetingDate[0];
        this.queryParams.params["endMeetingDate"] = this.daterangeMeetingDate[1];
      }
      listMeetings(this.queryParams).then(response => {
        this.meetingsList = response.rows;
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
        meetingId: null,
        classId: null,
        meetingType: null,
        meetingDate: null,
        meetingContent: null,
        meetingOutcome: null,
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
      this.daterangeMeetingDate = [];
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.meetingId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加ClassMeetings";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const meetingId = row.meetingId || this.ids
      getMeetings(meetingId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改ClassMeetings";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.meetingId != null) {
            updateMeetings(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addMeetings(this.form).then(response => {
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
      const meetingIds = row.meetingId || this.ids;
      this.$modal.confirm('是否确认删除ClassMeetings编号为"' + meetingIds + '"的数据项？').then(function() {
        return delMeetings(meetingIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/meetings/export', {
        ...this.queryParams
      }, `meetings_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
