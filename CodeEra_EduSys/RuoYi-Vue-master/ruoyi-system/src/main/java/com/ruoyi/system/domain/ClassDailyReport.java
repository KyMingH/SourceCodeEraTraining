package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * class_daily_report对象 class_daily_report
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
public class ClassDailyReport extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 日报ID */
    private Long reportId;

    /** 班级ID（外键，关联classes） */
    @Excel(name = "班级ID", readConverterExp = "外=键，关联classes")
    private Long classId;

    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date date;

    /** 报告内容 */
    @Excel(name = "报告内容")
    private String reportContent;

    /** 提交者 */
    @Excel(name = "提交者")
    private String submitter;

    public void setReportId(Long reportId) 
    {
        this.reportId = reportId;
    }

    public Long getReportId() 
    {
        return reportId;
    }
    public void setClassId(Long classId) 
    {
        this.classId = classId;
    }

    public Long getClassId() 
    {
        return classId;
    }
    public void setDate(Date date) 
    {
        this.date = date;
    }

    public Date getDate() 
    {
        return date;
    }
    public void setReportContent(String reportContent) 
    {
        this.reportContent = reportContent;
    }

    public String getReportContent() 
    {
        return reportContent;
    }
    public void setSubmitter(String submitter) 
    {
        this.submitter = submitter;
    }

    public String getSubmitter() 
    {
        return submitter;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("reportId", getReportId())
            .append("classId", getClassId())
            .append("date", getDate())
            .append("reportContent", getReportContent())
            .append("submitter", getSubmitter())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
