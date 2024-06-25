import request from '@/utils/request'

// 查询student_leave列表
export function listLeave(query) {
  return request({
    url: '/system/leave/list',
    method: 'get',
    params: query
  })
}

// 查询student_leave详细
export function getLeave(leaveId) {
  return request({
    url: '/system/leave/' + leaveId,
    method: 'get'
  })
}

// 新增student_leave
export function addLeave(data) {
  return request({
    url: '/system/leave',
    method: 'post',
    data: data
  })
}

// 修改student_leave
export function updateLeave(data) {
  return request({
    url: '/system/leave',
    method: 'put',
    data: data
  })
}

// 删除student_leave
export function delLeave(leaveId) {
  return request({
    url: '/system/leave/' + leaveId,
    method: 'delete'
  })
}
