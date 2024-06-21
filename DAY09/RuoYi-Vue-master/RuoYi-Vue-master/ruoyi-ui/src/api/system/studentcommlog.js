import request from '@/utils/request'

// 查询沟通记录列表
export function listStudentcommlog(query) {
  return request({
    url: '/system/studentcommlog/list',
    method: 'get',
    params: query
  })
}

// 查询沟通记录详细
export function getStudentcommlog(id) {
  return request({
    url: '/system/studentcommlog/' + id,
    method: 'get'
  })
}

// 新增沟通记录
export function addStudentcommlog(data) {
  return request({
    url: '/system/studentcommlog',
    method: 'post',
    data: data
  })
}

// 修改沟通记录
export function updateStudentcommlog(data) {
  return request({
    url: '/system/studentcommlog',
    method: 'put',
    data: data
  })
}

// 删除沟通记录
export function delStudentcommlog(id) {
  return request({
    url: '/system/studentcommlog/' + id,
    method: 'delete'
  })
}
