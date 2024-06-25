import request from '@/utils/request'

// 查询ClassMeetings列表
export function listMeetings(query) {
  return request({
    url: '/system/meetings/list',
    method: 'get',
    params: query
  })
}

// 查询ClassMeetings详细
export function getMeetings(meetingId) {
  return request({
    url: '/system/meetings/' + meetingId,
    method: 'get'
  })
}

// 新增ClassMeetings
export function addMeetings(data) {
  return request({
    url: '/system/meetings',
    method: 'post',
    data: data
  })
}

// 修改ClassMeetings
export function updateMeetings(data) {
  return request({
    url: '/system/meetings',
    method: 'put',
    data: data
  })
}

// 删除ClassMeetings
export function delMeetings(meetingId) {
  return request({
    url: '/system/meetings/' + meetingId,
    method: 'delete'
  })
}
