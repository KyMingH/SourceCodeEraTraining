import request from '@/utils/request'

// 查询学员基本信息列表
export function listStudents(query) {
  return request({
    url: '/system/students_/list',
    method: 'get',
    params: query
  })
}

// 查询学员基本信息详细
export function getStudents(studentId) {
  return request({
    url: '/system/students_/' + studentId,
    method: 'get'
  })
}

// 新增学员基本信息
export function addStudents(data) {
  return request({
    url: '/system/students_',
    method: 'post',
    data: data
  })
}

// 修改学员基本信息
export function updateStudents(data) {
  return request({
    url: '/system/students_',
    method: 'put',
    data: data
  })
}

// 删除学员基本信息
export function delStudents(studentId) {
  return request({
    url: '/system/students_/' + studentId,
    method: 'delete'
  })
}
