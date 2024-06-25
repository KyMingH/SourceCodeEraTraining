package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ClassDailyReportMapper;
import com.ruoyi.system.domain.ClassDailyReport;
import com.ruoyi.system.service.IClassDailyReportService;

/**
 * class_daily_reportService业务层处理
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
@Service
public class ClassDailyReportServiceImpl implements IClassDailyReportService 
{
    @Autowired
    private ClassDailyReportMapper classDailyReportMapper;

    /**
     * 查询class_daily_report
     * 
     * @param reportId class_daily_report主键
     * @return class_daily_report
     */
    @Override
    public ClassDailyReport selectClassDailyReportByReportId(Long reportId)
    {
        return classDailyReportMapper.selectClassDailyReportByReportId(reportId);
    }

    /**
     * 查询class_daily_report列表
     * 
     * @param classDailyReport class_daily_report
     * @return class_daily_report
     */
    @Override
    public List<ClassDailyReport> selectClassDailyReportList(ClassDailyReport classDailyReport)
    {
        return classDailyReportMapper.selectClassDailyReportList(classDailyReport);
    }

    /**
     * 新增class_daily_report
     * 
     * @param classDailyReport class_daily_report
     * @return 结果
     */
    @Override
    public int insertClassDailyReport(ClassDailyReport classDailyReport)
    {
        classDailyReport.setCreateTime(DateUtils.getNowDate());
        return classDailyReportMapper.insertClassDailyReport(classDailyReport);
    }

    /**
     * 修改class_daily_report
     * 
     * @param classDailyReport class_daily_report
     * @return 结果
     */
    @Override
    public int updateClassDailyReport(ClassDailyReport classDailyReport)
    {
        classDailyReport.setUpdateTime(DateUtils.getNowDate());
        return classDailyReportMapper.updateClassDailyReport(classDailyReport);
    }

    /**
     * 批量删除class_daily_report
     * 
     * @param reportIds 需要删除的class_daily_report主键
     * @return 结果
     */
    @Override
    public int deleteClassDailyReportByReportIds(Long[] reportIds)
    {
        return classDailyReportMapper.deleteClassDailyReportByReportIds(reportIds);
    }

    /**
     * 删除class_daily_report信息
     * 
     * @param reportId class_daily_report主键
     * @return 结果
     */
    @Override
    public int deleteClassDailyReportByReportId(Long reportId)
    {
        return classDailyReportMapper.deleteClassDailyReportByReportId(reportId);
    }
}
