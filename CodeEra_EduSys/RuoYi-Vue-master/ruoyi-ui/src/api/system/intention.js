import request from '@/utils/request'

// 查询student_intention列表
export function listIntention(query) {
  return request({
    url: '/system/intention/list',
    method: 'get',
    params: query
  })
}

// 查询student_intention详细
export function getIntention(recordId) {
  return request({
    url: '/system/intention/' + recordId,
    method: 'get'
  })
}

// 新增student_intention
export function addIntention(data) {
  return request({
    url: '/system/intention',
    method: 'post',
    data: data
  })
}

// 修改student_intention
export function updateIntention(data) {
  return request({
    url: '/system/intention',
    method: 'put',
    data: data
  })
}

// 删除student_intention
export function delIntention(recordId) {
  return request({
    url: '/system/intention/' + recordId,
    method: 'delete'
  })
}
