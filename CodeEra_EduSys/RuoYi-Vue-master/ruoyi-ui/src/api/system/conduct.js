import request from '@/utils/request'

// 查询student_conduct列表
export function listConduct(query) {
  return request({
    url: '/system/conduct/list',
    method: 'get',
    params: query
  })
}

// 查询student_conduct详细
export function getConduct(conductId) {
  return request({
    url: '/system/conduct/' + conductId,
    method: 'get'
  })
}

// 新增student_conduct
export function addConduct(data) {
  return request({
    url: '/system/conduct',
    method: 'post',
    data: data
  })
}

// 修改student_conduct
export function updateConduct(data) {
  return request({
    url: '/system/conduct',
    method: 'put',
    data: data
  })
}

// 删除student_conduct
export function delConduct(conductId) {
  return request({
    url: '/system/conduct/' + conductId,
    method: 'delete'
  })
}
