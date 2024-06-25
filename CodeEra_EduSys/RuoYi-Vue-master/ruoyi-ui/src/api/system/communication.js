import request from '@/utils/request'

// 查询TrialStudentCommunication列表
export function listCommunication(query) {
  return request({
    url: '/system/communication/list',
    method: 'get',
    params: query
  })
}

// 查询TrialStudentCommunication详细
export function getCommunication(communicationId) {
  return request({
    url: '/system/communication/' + communicationId,
    method: 'get'
  })
}

// 新增TrialStudentCommunication
export function addCommunication(data) {
  return request({
    url: '/system/communication',
    method: 'post',
    data: data
  })
}

// 修改TrialStudentCommunication
export function updateCommunication(data) {
  return request({
    url: '/system/communication',
    method: 'put',
    data: data
  })
}

// 删除TrialStudentCommunication
export function delCommunication(communicationId) {
  return request({
    url: '/system/communication/' + communicationId,
    method: 'delete'
  })
}
