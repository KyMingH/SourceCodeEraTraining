import request from '@/utils/request'

// 查询classes列表
export function listClasses(query) {
  return request({
    url: '/system/classes/list',
    method: 'get',
    params: query
  })
}

// 查询classes详细
export function getClasses(classId) {
  return request({
    url: '/system/classes/' + classId,
    method: 'get'
  })
}

// 新增classes
export function addClasses(data) {
  return request({
    url: '/system/classes',
    method: 'post',
    data: data
  })
}

// 修改classes
export function updateClasses(data) {
  return request({
    url: '/system/classes',
    method: 'put',
    data: data
  })
}

// 删除classes
export function delClasses(classId) {
  return request({
    url: '/system/classes/' + classId,
    method: 'delete'
  })
}
