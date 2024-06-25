<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="审批人" prop="approver">
        <el-input
          v-model="queryParams.approver"
          placeholder="请输入审批人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="审批状态" prop="approvalStatus">
        <el-select v-model="queryParams.approvalStatus" placeholder="请选择审批状态" clearable>
          <el-option
            v-for="dict in dict.type.approval_status2"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="审批时间" prop="approvalTime">
        <el-date-picker clearable
          v-model="queryParams.approvalTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择审批时间">
        </el-date-picker>
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
          v-hasPermi="['system:classStatusApproval:add']"
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
          v-hasPermi="['system:classStatusApproval:edit']"
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
          v-hasPermi="['system:classStatusApproval:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:classStatusApproval:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="classStatusApprovalList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="审批ID" align="center" prop="approvalId" />
      <el-table-column label="班级ID" align="center" prop="classId" />
      <el-table-column label="审批内容" align="center" prop="approverContent" />
      <el-table-column label="审批人" align="center" prop="approver" />
      <el-table-column label="审批状态" align="center" prop="approvalStatus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.approval_status2" :value="scope.row.approvalStatus"/>
        </template>
      </el-table-column>
      <el-table-column label="审批时间" align="center" prop="approvalTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.approvalTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="审批意见" align="center" prop="approvalRemark" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:classStatusApproval:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:classStatusApproval:remove']"
          >删除</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-s-claim"
            @click="handleApproval(scope.row)"
            v-hasPermi="['system:classStatusApproval:remove']"
          >审批</el-button>
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

    <!-- 添加或修改ClassStatusApproval对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="班级ID" prop="classId">
          <el-input v-model="form.classId" placeholder="请输入班级ID" />
        </el-form-item>
        <el-form-item label="审批内容">
          <editor v-model="form.approverContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="审批人" prop="approver">
          <el-input v-model="form.approver" placeholder="请输入审批人" />
        </el-form-item>
        <el-form-item label="审批状态" prop="approvalStatus">
          <el-select v-model="form.approvalStatus" placeholder="请选择审批状态">
            <el-option
              v-for="dict in dict.type.approval_status2"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="审批时间" prop="approvalTime">
          <el-date-picker clearable
            v-model="form.approvalTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择审批时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="审批意见" prop="approvalRemark">
          <el-input v-model="form.approvalRemark" type="textarea" placeholder="请输入内容" />
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
    <!-- 审批 -->
    <el-dialog :title="title" :visible.sync="open_approval" width="500px" append-to-body>
      <el-form ref="form_approval" :model="form_approval" :rules="rules_approval" label-width="80px">
        <el-form-item label="审批人" prop="approver">
          <el-input v-model="form_approval.approver" placeholder="请输入审批人" />
        </el-form-item>
        <el-form-item label="审批状态" prop="approvalStatus">
          <el-select v-model="form_approval.approvalStatus" placeholder="请选择审批状态">
            <el-option
              v-for="dict in dict.type.approval_status2"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="审批时间" prop="approvalTime">
          <el-date-picker clearable
            v-model="form_approval.approvalTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择审批时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="审批意见" prop="approvalRemark">
          <el-input v-model="form_approval.approvalRemark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form_approval.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm_approval">确 定</el-button>
        <el-button @click="cancel_approval">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listClassStatusApproval, getClassStatusApproval, delClassStatusApproval, addClassStatusApproval, updateClassStatusApproval } from "@/api/system/classStatusApproval";
import { listClasses, getClasses, delClasses, addClasses, updateClasses } from "@/api/system/classes";

export default {
  name: "ClassStatusApproval",
  dicts: ['approval_status2'],
  data() {
    return {
      //目前班级ID
      classId_: null,
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
      // ClassStatusApproval表格数据
      classStatusApprovalList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      open_approval: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        approverContent: null,
        approver: null,
        approvalStatus: null,
        approvalTime: null,
        approvalRemark: null,
      },
      // 表单参数
      form: {},
      form_approval: {},
      form_classes: {},
      // 表单校验
      rules: {
        classId: [
          { required: true, message: "班级ID不能为空", trigger: "blur" }
        ],
        approverContent: [
          { required: true, message: "审批内容不能为空", trigger: "blur" }
        ],
        approvalStatus: [
          { required: true, message: "审批状态不能为空", trigger: "change" }
        ],
      },
      rules_approval: {

      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 审批按钮 */
    handleApproval(row) {
      this.reset_approval();
      this.classId_ = row.classId
      const approvalId = row.approvalId || this.ids
      getClassStatusApproval(approvalId).then(response => {
        this.form_approval = response.data;
        this.open_approval = true;
        this.title = "审批";
      });
    },
    /** 查询ClassStatusApproval列表 */
    getList() {
      this.loading = true;
      listClassStatusApproval(this.queryParams).then(response => {
        this.classStatusApprovalList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    cancel_approval() {
      this.open_approval = false;
      this.reset_approval();
    },
    // 表单重置
    reset() {
      this.form = {
        approvalId: null,
        classId: null,
        approverContent: null,
        approver: null,
        approvalStatus: null,
        approvalTime: null,
        approvalRemark: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null
      };
      this.resetForm("form");
    },
    reset_approval() {
      this.form_approval = {
        approvalId: null,
        classId: null,
        approverContent: null,
        approver: null,
        approvalStatus: null,
        approvalTime: null,
        approvalRemark: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null
      };
      this.resetForm("form_approval");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.approvalId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加ClassStatusApproval";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const approvalId = row.approvalId || this.ids
      getClassStatusApproval(approvalId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改ClassStatusApproval";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.approvalId != null) {
            updateClassStatusApproval(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addClassStatusApproval(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    submitForm_approval() {
      this.$refs["form_approval"].validate(valid => {
        if (valid) {
          // 确保审批状态是 '01'
          if (this.form_approval.approvalStatus === '01') {
            // 先获取课程信息
            getClasses(this.classId_).then(response => {
              if (response && response.data) {
                // 提取新的课程状态
                let newClassStatus = this.extractNewStatus(this.form_approval.approverContent);
                this.form_classes = response.data;
                this.form_classes.classStatus = newClassStatus;
                
                // 保存更新后的课程信息
                return updateClasses(this.form_classes); // 使用 return 以便于链式调用
              }
            })
            .then(response => {
              // 这里应该是保存课程信息后的操作
              // 例如，可以添加成功消息提示
            })
            .catch(error => {
              console.error("更新课程信息失败：", error);
              this.$modal.msgError("更新课程信息失败"); // 假设这是显示错误消息的方法
            });
          }

          // 执行审批操作
          updateClassStatusApproval(this.form_approval).then(response => {
            if (response && response.code === 200) { // 根据实际响应格式检查响应码
              this.$modal.msgSuccess("审批完成");
              this.open_approval = false;
              this.getList(); // 刷新列表
            } else {
              // 处理非200响应码的情况
              this.$modal.msgError("审批失败：" + (response.message || '未知错误'));
            }
          })
          .catch(error => {
            console.error("审批操作失败：", error);
            this.$modal.msgError("审批操作失败"); // 假设这是显示错误消息的方法
          });
        }
      });
    },
    // 辅助方法，用于从审批内容中提取新的课程状态
    extractNewStatus(approverContent) {
      // 假设 "修改成" 后面跟着的就是新的课程状态
      const startIndex = approverContent.indexOf("修改成") + 3;
      let newStatus = approverContent.substring(startIndex).trim();
      // 确保提取的状态不包含非法字符或异常值
      if (!newStatus || typeof newStatus !== 'string') {
        throw new Error('无效的课程状态');
      }
      return newStatus;
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const approvalIds = row.approvalId || this.ids;
      this.$modal.confirm('是否确认删除ClassStatusApproval编号为"' + approvalIds + '"的数据项？').then(function() {
        return delClassStatusApproval(approvalIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/classStatusApproval/export', {
        ...this.queryParams
      }, `classStatusApproval_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
