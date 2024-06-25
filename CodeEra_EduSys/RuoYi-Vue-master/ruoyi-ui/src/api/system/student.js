import request from '@/utils/request'

// 查询problem_student列表
export function listStudent(query) {
  return request({
    url: '/system/student/list',
    method: 'get',
    params: query
  })
}

// 查询problem_student详细
export function getStudent(recordId) {
  return request({
    url: '/system/student/' + recordId,
    method: 'get'
  })
}

// 新增problem_student
export function addStudent(data) {
  return request({
    url: '/system/student',
    method: 'post',
    data: data
  })
}

// 修改problem_student
export function updateStudent(data) {
  return request({
    url: '/system/student',
    method: 'put',
    data: data
  })
}

// 删除problem_student
export function delStudent(recordId) {
  return request({
    url: '/system/student/' + recordId,
    method: 'delete'
  })
}
