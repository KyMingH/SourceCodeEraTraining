<template>
    <div>
        <el-table
      :data="students"
      style="width: 100%" :border="true">
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
      <el-table-column prop="desc" label="描述" width="180"></el-table-column>
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
    </div>
  </template>

<script>
// export default: 这行代码表示导出一个默认对象，使得其他文件可以通过import语句引入这个对象。
export default {
  data () { 
    return {
      students: [{
        id: 1,
        name: '张三',
        gender: 1, // 1 男 2 女
        birthday: '2000-10-01',
        telephone: '18888888888',
        degree: 3, // 1 中学 2 大学 3 硕士 4 博士 5 博士后
        desc: '这个人很牛逼',
        state: 1 // 0 冻结 1 正常
      },
      {
        id: 2,
        name: '李四',
        gender: 2, // 1 男 2 女
        birthday: '2000-11-01',
        telephone: '18888588888',
        degree: 2, // 1 中学 2 大学 3 硕士 4 博士 5 博士后
        desc: '这个人也很牛逼',
        state: 0 // 0 冻结 1 正常
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
    handleEdit () { 
      alert('修改')
    },
    handleDelete () {
      alert('删除')
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
    }
  }
 }
</script>

<style>

</style>