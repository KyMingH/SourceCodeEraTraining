package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.ClassDailyReport;

/**
 * class_daily_reportService接口
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
public interface IClassDailyReportService 
{
    /**
     * 查询class_daily_report
     * 
     * @param reportId class_daily_report主键
     * @return class_daily_report
     */
    public ClassDailyReport selectClassDailyReportByReportId(Long reportId);

    /**
     * 查询class_daily_report列表
     * 
     * @param classDailyReport class_daily_report
     * @return class_daily_report集合
     */
    public List<ClassDailyReport> selectClassDailyReportList(ClassDailyReport classDailyReport);

    /**
     * 新增class_daily_report
     * 
     * @param classDailyReport class_daily_report
     * @return 结果
     */
    public int insertClassDailyReport(ClassDailyReport classDailyReport);

    /**
     * 修改class_daily_report
     * 
     * @param classDailyReport class_daily_report
     * @return 结果
     */
    public int updateClassDailyReport(ClassDailyReport classDailyReport);

    /**
     * 批量删除class_daily_report
     * 
     * @param reportIds 需要删除的class_daily_report主键集合
     * @return 结果
     */
    public int deleteClassDailyReportByReportIds(Long[] reportIds);

    /**
     * 删除class_daily_report信息
     * 
     * @param reportId class_daily_report主键
     * @return 结果
     */
    public int deleteClassDailyReportByReportId(Long reportId);
}
