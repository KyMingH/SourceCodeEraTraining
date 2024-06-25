import request from '@/utils/request'

// 查询teachers列表
export function listTeachers(query) {
  return request({
    url: '/system/teachers/list',
    method: 'get',
    params: query
  })
}

// 查询teachers详细
export function getTeachers(teacherId) {
  return request({
    url: '/system/teachers/' + teacherId,
    method: 'get'
  })
}

// 新增teachers
export function addTeachers(data) {
  return request({
    url: '/system/teachers',
    method: 'post',
    data: data
  })
}

// 修改teachers
export function updateTeachers(data) {
  return request({
    url: '/system/teachers',
    method: 'put',
    data: data
  })
}

// 删除teachers
export function delTeachers(teacherId) {
  return request({
    url: '/system/teachers/' + teacherId,
    method: 'delete'
  })
}
