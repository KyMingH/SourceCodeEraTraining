import request from '@/utils/request'

// 查询StudentProcessApproval列表
export function listStudentProcessApproval(query) {
  return request({
    url: '/system/studentProcessApproval/list',
    method: 'get',
    params: query
  })
}

// 查询StudentProcessApproval详细
export function getStudentProcessApproval(approvalId) {
  return request({
    url: '/system/studentProcessApproval/' + approvalId,
    method: 'get'
  })
}

// 新增StudentProcessApproval
export function addStudentProcessApproval(data) {
  return request({
    url: '/system/studentProcessApproval',
    method: 'post',
    data: data
  })
}

// 修改StudentProcessApproval
export function updateStudentProcessApproval(data) {
  return request({
    url: '/system/studentProcessApproval',
    method: 'put',
    data: data
  })
}

// 删除StudentProcessApproval
export function delStudentProcessApproval(approvalId) {
  return request({
    url: '/system/studentProcessApproval/' + approvalId,
    method: 'delete'
  })
}
