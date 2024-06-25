import request from '@/utils/request'

// 查询alumni_follow_up列表
export function listUp(query) {
  return request({
    url: '/system/up/list',
    method: 'get',
    params: query
  })
}

// 查询alumni_follow_up详细
export function getUp(followUpId) {
  return request({
    url: '/system/up/' + followUpId,
    method: 'get'
  })
}

// 新增alumni_follow_up
export function addUp(data) {
  return request({
    url: '/system/up',
    method: 'post',
    data: data
  })
}

// 修改alumni_follow_up
export function updateUp(data) {
  return request({
    url: '/system/up',
    method: 'put',
    data: data
  })
}

// 删除alumni_follow_up
export function delUp(followUpId) {
  return request({
    url: '/system/up/' + followUpId,
    method: 'delete'
  })
}
