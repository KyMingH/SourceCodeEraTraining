import request from '@/utils/request'

// 查询ClassStatusApproval列表
export function listClassStatusApproval(query) {
  return request({
    url: '/system/classStatusApproval/list',
    method: 'get',
    params: query
  })
}

// 查询ClassStatusApproval详细
export function getClassStatusApproval(approvalId) {
  return request({
    url: '/system/classStatusApproval/' + approvalId,
    method: 'get'
  })
}

// 新增ClassStatusApproval
export function addClassStatusApproval(data) {
  return request({
    url: '/system/classStatusApproval',
    method: 'post',
    data: data
  })
}

// 修改ClassStatusApproval
export function updateClassStatusApproval(data) {
  return request({
    url: '/system/classStatusApproval',
    method: 'put',
    data: data
  })
}

// 删除ClassStatusApproval
export function delClassStatusApproval(approvalId) {
  return request({
    url: '/system/classStatusApproval/' + approvalId,
    method: 'delete'
  })
}
