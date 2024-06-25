package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * trial_students对象 trial_students
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
public class TrialStudents extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 试听学员ID */
    private Long trialStudentId;

    /** 学员ID（外键，关联students） */
    @Excel(name = "学员ID", readConverterExp = "外=键，关联students")
    private Long studentId;

    /** 试听课程 */
    @Excel(name = "试听课程")
    private String trialCourse;

    /** 试听日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "试听日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date trialDate;

    /** 转化状态（是否已转正式学员） */
    @Excel(name = "转化状态", readConverterExp = "是=否已转正式学员")
    private Integer conversionStatus;

    public void setTrialStudentId(Long trialStudentId) 
    {
        this.trialStudentId = trialStudentId;
    }

    public Long getTrialStudentId() 
    {
        return trialStudentId;
    }
    public void setStudentId(Long studentId) 
    {
        this.studentId = studentId;
    }

    public Long getStudentId() 
    {
        return studentId;
    }
    public void setTrialCourse(String trialCourse) 
    {
        this.trialCourse = trialCourse;
    }

    public String getTrialCourse() 
    {
        return trialCourse;
    }
    public void setTrialDate(Date trialDate) 
    {
        this.trialDate = trialDate;
    }

    public Date getTrialDate() 
    {
        return trialDate;
    }
    public void setConversionStatus(Integer conversionStatus) 
    {
        this.conversionStatus = conversionStatus;
    }

    public Integer getConversionStatus() 
    {
        return conversionStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("trialStudentId", getTrialStudentId())
            .append("studentId", getStudentId())
            .append("trialCourse", getTrialCourse())
            .append("trialDate", getTrialDate())
            .append("conversionStatus", getConversionStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
