import request from '@/utils/request'

// 查询student_status列表
export function listStatus(query) {
  return request({
    url: '/system/status/list',
    method: 'get',
    params: query
  })
}

// 查询student_status详细
export function getStatus(statusId) {
  return request({
    url: '/system/status/' + statusId,
    method: 'get'
  })
}

// 新增student_status
export function addStatus(data) {
  return request({
    url: '/system/status',
    method: 'post',
    data: data
  })
}

// 修改student_status
export function updateStatus(data) {
  return request({
    url: '/system/status',
    method: 'put',
    data: data
  })
}

// 删除student_status
export function delStatus(statusId) {
  return request({
    url: '/system/status/' + statusId,
    method: 'delete'
  })
}
