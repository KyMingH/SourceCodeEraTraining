import request from '@/utils/request'

// 查询LeaveApproval列表
export function listLeaveApproval(query) {
  return request({
    url: '/system/leaveApproval/list',
    method: 'get',
    params: query
  })
}

// 查询LeaveApproval详细
export function getLeaveApproval(approvalId) {
  return request({
    url: '/system/leaveApproval/' + approvalId,
    method: 'get'
  })
}

// 新增LeaveApproval
export function addLeaveApproval(data) {
  return request({
    url: '/system/leaveApproval',
    method: 'post',
    data: data
  })
}

// 修改LeaveApproval
export function updateLeaveApproval(data) {
  return request({
    url: '/system/leaveApproval',
    method: 'put',
    data: data
  })
}

// 删除LeaveApproval
export function delLeaveApproval(approvalId) {
  return request({
    url: '/system/leaveApproval/' + approvalId,
    method: 'delete'
  })
}
