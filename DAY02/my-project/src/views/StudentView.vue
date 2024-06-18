<template>
    <div>
        <el-table :data="students" style="width: 100%" :border="true">
      <el-table-column type="selection"></el-table-column>
      <el-table-column type="index"></el-table-column>
      <el-table-column prop="name" label="姓名" width="180"></el-table-column>
      <el-table-column prop="gender" label="性别" width="180">
        <!-- 自定义列显示的内容 -->
        <template slot-scope="scope">
            <el-tag type="success" v-if="scope.row.gender == 1">男</el-tag>
            <el-tag type="danger" v-else>女</el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="birthday" label="出生日期" width="180"></el-table-column>
      <el-table-column prop="telephone" label="联系方式" width="180"></el-table-column>
      <el-table-column prop="degree" label="学历" width="180">
        <template slot-scope="scope">
            {{ degreeFormatter(scope.row.degree) }}
        </template>
      </el-table-column>
      <el-table-column prop="desc" label="简介" width="180"></el-table-column>
      <el-table-column prop="state" label="状态" width="180">
        <template slot-scope="scope">
          <el-tag type="success" v-if="scope.row.state == 1">正常</el-tag>
          <el-tag type="danger" v-else>冻结</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
        <div class="operate-buttons">
          <el-button
            size="mini"
            @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
          <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)">删除</el-button>
        </div>
      </template>
    </el-table-column>
        </el-table>
        <div id="page">
          <el-pagination
          background
          layout="sizes, prev, pager, next"
          :total="total"
          :page-size="pageSize"
          :page-sizes="[5, 10, 15, 20]"
          :current-page="pageNum"
          @current-change="handleCurrentChange"
          @size-change="handleSizeChange">
          </el-pagination>
        </div>
        <!-- 如果按钮需要在页面上水平和垂直居中 -->
        <div class="center-container">
          <el-button 
            type="success" 
            icon="el-icon-edit" 
            round 
            class="el-button-centered"
            @click="dialogVisible = true"
          >
            添加
          </el-button>
        </div>
          <div class="parent-container">
          <div class="demo-input-suffix">
            名字：
            <el-input
              placeholder="请输入内容"
              prefix-icon="el-icon-search"
              v-model="query.name">
            </el-input>
          </div>
          <div class="demo-input-suffix">
            性别：
              <div>
                <el-radio v-model="query.gender" label="1">男</el-radio>
                <el-radio v-model="query.gender" label="2">女</el-radio>
              </div>
          </div>
          <div class="demo-input-suffix">
            出生日期：
            <div class="block">
              <span class="demonstration"></span>
              <el-date-picker
                v-model="query.birthday_list"
                type="daterange"
                range-separator="至"
                start-placeholder="开始日期"
                end-placeholder="结束日期">
              </el-date-picker>
            </div>
          </div>
          <div class="demo-input-suffix">
            联系方式：
            <el-input
              placeholder="请输入内容"
              v-model="query.telephone">
              <i slot="prefix" class="el-input__icon el-icon-search"></i>
            </el-input>
          </div>
          <div class="demo-input-suffix">
            学历：
            <el-radio-group v-model="query.degree">
                <el-radio-button label="1">中学</el-radio-button>
                <el-radio-button label="2">高中</el-radio-button>
                <el-radio-button label="3">本科</el-radio-button>
                <el-radio-button label="4">硕士</el-radio-button>
                <el-radio-button label="5">博士</el-radio-button>
                </el-radio-group>
          </div>
          <div class="demo-input-suffix">
            状态：
            <el-radio-group v-model="query.state">
                <el-radio-button label="1">正常</el-radio-button>
                <el-radio-button label="2">冻结</el-radio-button>
                </el-radio-group>
          </div>
        </div>
        <el-dialog
        title="添加学生信息"
        :visible.sync=dialogVisible
        width="40%"
        :before-close="handleClose">
        <template slot-scope="scope">
            <el-form ref="form" :model="form" :rules="rules" label-width="80px">
            <el-form-item label="名字" prop="name">
                <el-input v-model="form.name" placeholder="请输入姓名"></el-input>
            </el-form-item>
            <el-form-item label="性别">
                <template slot-scope="scope">
                    <template>
                    <el-radio v-model="form.gender" label="1">男</el-radio>
                    <el-radio v-model="form.gender" label="2">女</el-radio>
                    </template>
                </template> 
            </el-form-item>
            <el-form-item label="出生日期">
                <el-col :span="11">
                  <el-date-picker
                    type="date"
                    placeholder="选择日期"
                    v-model="form.birthday"
                    @change="handleDateChange"
                    style="width: 100%;">
                  </el-date-picker>
                </el-col>
            </el-form-item>
            <el-form-item label="联系方式" prop="telephone">
                <el-input v-model="form.telephone"></el-input>
            </el-form-item>
            <el-form-item label="学历">
                <el-radio-group v-model="form.degree">
                <el-radio-button label="1">中学</el-radio-button>
                <el-radio-button label="2">高中</el-radio-button>
                <el-radio-button label="3">本科</el-radio-button>
                <el-radio-button label="4">硕士</el-radio-button>
                <el-radio-button label="5">博士</el-radio-button>
                </el-radio-group>
            </el-form-item>
            <el-form-item label="简介">
              <el-input type="textarea" v-model="form.desc"></el-input>
            </el-form-item>
            <el-form-item label="简介">
                <el-radio disabled v-model="form.state" label="1">正常</el-radio>
                <el-radio disabled v-model="form.state" label="0">冻结</el-radio>
              </el-form-item>
            </el-form>
        </template>
        <span slot="footer" class="dialog-footer">
            <el-button @click="dialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="submitForm('form')">确 定</el-button>
        </span>
        </el-dialog>
        <div class="center-button">
          <el-button type="primary" icon="el-icon-search" @click="startquery()">搜索</el-button>
        </div>
    </div>
  </template>

<script>
// export default: 这行代码表示导出一个默认对象，使得其他文件可以通过import语句引入这个对象。
export default {
  data () { 
    var validateTelephone = (rule, value, callback) => {
        let pattern = /^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\d{8}$/
        if (value !== '' && !pattern.test(value)){
          callback(new Error('请输入正确的手机号码'))
        }else{
          callback();
        }
      };
    return {
      query:{
        name: '',
        gender: '',
        birthday_list: '',
        telephone: '',
        degree: '',
        desc: '',
        state: '',
      },
      pageNum: 1,
      pageSize: 5,
      total: 0,
      rules: {
          name: [
            { required: true, message: '请输入名字', trigger: 'blur' },
          ],
          telephone: [
            { validator: validateTelephone, trigger: 'blur' }
          ],
      },
      isEditing: false, // 标记是否处于编辑模式
        form: {
          id: 0,
          name: '',
          gender: '',
          birthday: '',
          telephone: '',
          degree: '',
          desc: '',
          state: '1'
        },
      dialogVisible:false,
      students: [{
        id: 1,
        name: '梁铭辉',
        gender: '1', // 1 男 2 女
        birthday: null,
        telephone: '13690555323',
        degree: '2', 
        desc: '这个人很牛逼',
        state: '1' // 0 冻结 1 正常
      }],
      degreeArray: [{
        key: 1,
        label: '中学' 
      },{
        key: 2,
        label: '高中' 
      },{
        key: 3,
        label: '本科' 
      },{
        key: 4,
        label: '硕士' 
      },{
        key: 5,
        label: '博士' 
      }]
    }
  },
  mounted (){
    this.loadStudents()
  },
  methods: {
    startquery(){
      console.log(this.query.birthday_list)
      this.loadQueryStudents()
    },
    handleSizeChange(value){
      this.pageSize = value
      this.loadStudents()
    },
    handleCurrentChange(value)
    {
      this.pageNum = value
      this.loadStudents()
    },
    loadStudents(){
      this.axios.post("/student/page",{
        pageNum : this.pageNum,
        pageSize : this.pageSize
      }).then(res => {
        let { code, message, data } = res.data
        if(code == 200)
        {
          this.students = data.rows
          this.total = data.total
        }else{
          this.$message.error(message)
        }
    })
    },
    loadQueryStudents(){
      this.axios.post("/student/querypage",{
        pageNum : this.pageNum,
        pageSize : this.pageSize,
        name: this.query.name,
        gender: this.query.gender,
        birthdayBegin: this.query.birthday_list[0],
        birthdayEnd: this.query.birthday_list[1],
        telephone: this.query.telephone,
        degree: this.query.degree,
        desc: this.query.desc,
        state: this.query.state,
      }).then(res => {
        let { code, message, data } = res.data
        if(code == 200)
        {
          this.students = data.rows
          this.total = data.total
        }else{
          this.$message.error(message)
        }
    })
    },
    submitForm(form) {
        this.$refs[form].validate((valid) => {
          if (valid) {
            this.handleSaveEdit();
          } else {
          }
        });
      },
    handleDateChange(value) {
    if (value) {
      // 将日期对象转换为字符串，例如：'2024-06-12'
      this.form.birthday = this.formatDate(value);
      }
    },
    formatDate(date) {
      // 确保date是一个日期对象
      const d = new Date(date);
      let month = '' + (d.getMonth() + 1);
      let day = '' + d.getDate();
      let year = d.getFullYear();

      if (month.length < 2) 
        month = '0' + month;
      if (day.length < 2) 
        day = '0' + day;

      return [year, month, day].join('-');
    },
    handleEdit(index, student) {
      // 将当前点击的学生信息填充到表单中
      this.form = { ...student };
      this.isEditing = true; // 设置为编辑模式
      // 显示编辑对话框
      this.dialogVisible = true;
      // 可以添加其他编辑前需要执行的逻辑
    },
    handleSaveEdit() {
      if (!this.isEditing) {
        // 如果不是编辑模式，则调用添加学生的逻辑
        this.handleSave();
      } else {
        // 更新 students 数组中对应的学生记录
        const index = this.students.findIndex(s => s.id === this.form.id);
        if (index !== -1) {
          this.students.splice(index, 1, { ...this.form });
          // 关闭对话框
          this.dialogVisible = false;
          // 提示用户编辑成功
          this.$message({
            message: '编辑成功',
            type: 'success'
          });
          // 重置编辑模式
          this.isEditing = false;
        }
      }
    },
    handleDelete(index, student, Edit) {
    // 向用户确认删除操作
    if(Edit){
      this.students.splice(index, 1);
      return;
    }
    this.$confirm('此操作将永久删除该学生信息, 是否继续?', '提示', {
      confirmButtonText: '确定',
      cancelButtonText: '取消',
      type: 'warning'
    }).then(() => {
      // 从students数组中删除指定的学生记录
      this.students.splice(index, 1);
      // 提示用户删除成功
      this.$message({
        message: '删除成功',
        type: 'success'
      });
    }).catch(() => {
      // 用户取消删除
      this.$message({
        message: '已取消删除',
        type: 'info'
      });
    });
  },
    // 格式化学历
    degreeFormatter (key) { 
      let label = ''
      for (let i = 0; i < this.degreeArray.length; i++){
 
        let degree = this.degreeArray[i]
        if (degree.key == key) {
          label = degree.label
        }
      }
      return label
    },
    handleSave () { 
      this.form.id = this.students.length
      this.students.push(this.form)
      // 关闭输入框
      this.dialogVisible = false
      // 提示添加成功
      this.$message({
      message: '恭喜你，添加成功!',
      type: 'success'
      });
      // 重置form
      this.form = {
      id:0,
      name: '',
      gender: '',
      birthday: '',
      degree: '',
      state: '',
      desc: ''
      }
    }
  }
 }
</script>

<style>
#page {
  position: absolute;
  right: 0;
}
/* 外层容器使用Flexbox布局来居中并排列子元素 */
.parent-container {
  display: flex;
  justify-content: center; /* 水平居中所有子元素 */
  flex-wrap: wrap; /* 允许子元素在一行放不下时换行 */
  padding: 20px; /* 可选，根据需要添加内边距 */
}

/* 限制每个demo-input-suffix的宽度，并设置间隔 */
.demo-input-suffix {
  flex: 0 1 45%; /* 每个子元素占据可用空间的45%，但不超过其自然宽度 */
  margin: 10px; /* 子元素之间的间隔 */
  box-sizing: border-box; /* 边框计算在宽度内 */
}

/* 确保每个demo-input-suffix内部的el-input也适当缩放 */
.demo-input-suffix .el-input {
  width: 100%; /* 让输入框宽度充满其父容器 */
}

/* 按钮样式 */
.el-button-centered {
  width: 120px; /* 设置按钮的宽度，可以根据需要调整 */
  margin: 20px; /* 设置外边距，提供间隔空间感 */
  padding: 10px; /* 设置内边距，使按钮文本和图标有更多空间 */
  border-radius: 20px; /* 设置圆角 */
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* 添加阴影 */
}

/* 如果按钮在容器内居中 */
.center-container {
  display: flex;
  justify-content: center; /* 水平居中 */
  align-items: center; /* 垂直居中 */
  min-height: 10vh; /* 设置最小高度为视窗高度 */
}

/* 可选：如果你希望按钮在点击时有反馈效果 */
.el-button-centered:active {
  transform: scale(0.98); /* 点击时缩小 */
  box-shadow: 0 2px 6px rgba(0, 0, 0, 0.2); /* 点击时更深的阴影 */
}
/* 插槽的父元素样式 */
.operate-buttons {
  display: flex;        /* 使用Flexbox布局 */
  justify-content: center; /* 水平居中 */
  align-items: center;   /*垂直居中*/
  gap: 8px;              /* 按钮之间的间隔 */
}

/* 可选：如果你希望按钮在点击时有反馈效果 */
.operate-buttons .el-button:active {
  transform: scale(0.98); /* 点击时缩小 */
}

.center-button {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%; /* 或者设置一个具体的高度 */
}
</style>