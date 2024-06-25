import request from '@/utils/request'

// 查询class_activities列表
export function listActivities(query) {
  return request({
    url: '/system/activities/list',
    method: 'get',
    params: query
  })
}

// 查询class_activities详细
export function getActivities(activityId) {
  return request({
    url: '/system/activities/' + activityId,
    method: 'get'
  })
}

// 新增class_activities
export function addActivities(data) {
  return request({
    url: '/system/activities',
    method: 'post',
    data: data
  })
}

// 修改class_activities
export function updateActivities(data) {
  return request({
    url: '/system/activities',
    method: 'put',
    data: data
  })
}

// 删除class_activities
export function delActivities(activityId) {
  return request({
    url: '/system/activities/' + activityId,
    method: 'delete'
  })
}
