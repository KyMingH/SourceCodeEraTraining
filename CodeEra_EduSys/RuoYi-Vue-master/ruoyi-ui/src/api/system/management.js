import request from '@/utils/request'

// 查询class_management列表
export function listManagement(query) {
  return request({
    url: '/system/management/list',
    method: 'get',
    params: query
  })
}

// 查询class_management详细
export function getManagement(operationId) {
  return request({
    url: '/system/management/' + operationId,
    method: 'get'
  })
}

// 新增class_management
export function addManagement(data) {
  return request({
    url: '/system/management',
    method: 'post',
    data: data
  })
}

// 修改class_management
export function updateManagement(data) {
  return request({
    url: '/system/management',
    method: 'put',
    data: data
  })
}

// 删除class_management
export function delManagement(operationId) {
  return request({
    url: '/system/management/' + operationId,
    method: 'delete'
  })
}
