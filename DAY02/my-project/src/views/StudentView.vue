<template>
    <div>
        <el-button type="success" icon="el-icon-edit" round @click="dialogVisible = true">添加</el-button>
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
        <el-button
          size="mini"
          @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)">删除</el-button>
        </template>
    </el-table-column>
    </el-table>
    <el-dialog
        title="添加学生信息"
        :visible.sync=dialogVisible
        width="40%"
        :before-close="handleClose">
        <template slot-scope="scope">
            <el-form ref="form" :model="form" label-width="80px">
            <el-form-item label="名字">
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
            <el-form-item label="联系方式">
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
            <el-button type="primary" @click=handleSave()>确 定</el-button>
        </span>
        </el-dialog>
    </div>
  </template>

<script>
// export default: 这行代码表示导出一个默认对象，使得其他文件可以通过import语句引入这个对象。
export default {
  data () { 
    return {
        form: {
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
        birthday: '2003-03-22',
        telephone: '13690555323',
        degree: '2', // 1 中学 2 大学 3 硕士 4 博士 5 博士后
        desc: '这个人很牛逼',
        state: '1' // 0 冻结 1 正常
      },
      {
        id: 2,
        name: '唐静敏',
        gender: '2', // 1 男 2 女
        birthday: '2004-01-11',
        telephone: '17358315860',
        degree: '2', // 1 中学 2 大学 3 硕士 4 博士 5 博士后
        desc: '这个人也很牛逼',
        state: '0' // 0 冻结 1 正常
      }],
      degreeArray: [{
        key: 1,
        label: '中学' 
      },{
        key: 2,
        label: '大学' 
      },{
        key: 3,
        label: '硕士' 
      },{
        key: 4,
        label: '博士' 
      },{
        key: 5,
        label: '博士后' 
      }]
    }
  },
  methods: {
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
      this.handleDelete(index, student, true);
      // 显示编辑对话框
      this.dialogVisible = true;
      // 可以添加其他编辑前需要执行的逻辑
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

</style>