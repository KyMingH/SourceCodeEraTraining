import request from '@/utils/request'

// 查询student_application列表
export function listApplication(query) {
  return request({
    url: '/system/application/list',
    method: 'get',
    params: query
  })
}

// 查询student_application详细
export function getApplication(applicationId) {
  return request({
    url: '/system/application/' + applicationId,
    method: 'get'
  })
}

// 新增student_application
export function addApplication(data) {
  return request({
    url: '/system/application',
    method: 'post',
    data: data
  })
}

// 修改student_application
export function updateApplication(data) {
  return request({
    url: '/system/application',
    method: 'put',
    data: data
  })
}

// 删除student_application
export function delApplication(applicationId) {
  return request({
    url: '/system/application/' + applicationId,
    method: 'delete'
  })
}
