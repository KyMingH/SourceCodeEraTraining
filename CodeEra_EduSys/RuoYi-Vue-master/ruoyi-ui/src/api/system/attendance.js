import request from '@/utils/request'

// 查询class_attendance列表
export function listAttendance(query) {
  return request({
    url: '/system/attendance/list',
    method: 'get',
    params: query
  })
}

// 查询class_attendance详细
export function getAttendance(attendanceId) {
  return request({
    url: '/system/attendance/' + attendanceId,
    method: 'get'
  })
}

// 新增class_attendance
export function addAttendance(data) {
  return request({
    url: '/system/attendance',
    method: 'post',
    data: data
  })
}

// 修改class_attendance
export function updateAttendance(data) {
  return request({
    url: '/system/attendance',
    method: 'put',
    data: data
  })
}

// 删除class_attendance
export function delAttendance(attendanceId) {
  return request({
    url: '/system/attendance/' + attendanceId,
    method: 'delete'
  })
}
