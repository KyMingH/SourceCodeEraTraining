import request from '@/utils/request'

// 查询StudentRegularApproval列表
export function listStudentRegularApproval(query) {
  return request({
    url: '/system/studentRegularApproval/list',
    method: 'get',
    params: query
  })
}

// 查询StudentRegularApproval详细
export function getStudentRegularApproval(approvalId) {
  return request({
    url: '/system/studentRegularApproval/' + approvalId,
    method: 'get'
  })
}

// 新增StudentRegularApproval
export function addStudentRegularApproval(data) {
  return request({
    url: '/system/studentRegularApproval',
    method: 'post',
    data: data
  })
}

// 修改StudentRegularApproval
export function updateStudentRegularApproval(data) {
  return request({
    url: '/system/studentRegularApproval',
    method: 'put',
    data: data
  })
}

// 删除StudentRegularApproval
export function delStudentRegularApproval(approvalId) {
  return request({
    url: '/system/studentRegularApproval/' + approvalId,
    method: 'delete'
  })
}
