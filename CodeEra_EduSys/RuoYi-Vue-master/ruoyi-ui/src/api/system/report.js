import request from '@/utils/request'

// 查询class_daily_report列表
export function listReport(query) {
  return request({
    url: '/system/report/list',
    method: 'get',
    params: query
  })
}

// 查询class_daily_report详细
export function getReport(reportId) {
  return request({
    url: '/system/report/' + reportId,
    method: 'get'
  })
}

// 新增class_daily_report
export function addReport(data) {
  return request({
    url: '/system/report',
    method: 'post',
    data: data
  })
}

// 修改class_daily_report
export function updateReport(data) {
  return request({
    url: '/system/report',
    method: 'put',
    data: data
  })
}

// 删除class_daily_report
export function delReport(reportId) {
  return request({
    url: '/system/report/' + reportId,
    method: 'delete'
  })
}
