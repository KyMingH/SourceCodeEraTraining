import request from '@/utils/request'

// 查询trial_studentsM列表
export function listTrial_studentsM(query) {
  return request({
    url: '/system/trial_studentsM/list',
    method: 'get',
    params: query
  })
}

// 查询trial_studentsM详细
export function getTrial_studentsM(trialStudentId) {
  return request({
    url: '/system/trial_studentsM/' + trialStudentId,
    method: 'get'
  })
}

// 新增trial_studentsM
export function addTrial_studentsM(data) {
  return request({
    url: '/system/trial_studentsM',
    method: 'post',
    data: data
  })
}

// 修改trial_studentsM
export function updateTrial_studentsM(data) {
  return request({
    url: '/system/trial_studentsM',
    method: 'put',
    data: data
  })
}

// 删除trial_studentsM
export function delTrial_studentsM(trialStudentId) {
  return request({
    url: '/system/trial_studentsM/' + trialStudentId,
    method: 'delete'
  })
}
