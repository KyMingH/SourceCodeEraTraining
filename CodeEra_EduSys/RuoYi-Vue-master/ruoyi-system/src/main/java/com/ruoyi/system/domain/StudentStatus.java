package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * student_status对象 student_status
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
public class StudentStatus extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 状态ID */
    private Long statusId;

    /** 学员ID（外键，关联students） */
    @Excel(name = "学员ID", readConverterExp = "外=键，关联students")
    private Long studentId;

    /** 状态类型（就业中、试听阶段、正式学员、留级、休学、退学等） */
    @Excel(name = "状态类型", readConverterExp = "就=业中、试听阶段、正式学员、留级、休学、退学等")
    private String statusType;

    /** 状态开始日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "状态开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date statusStartDate;

    /** 状态结束日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "状态结束日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date statusEndDate;

    public void setStatusId(Long statusId) 
    {
        this.statusId = statusId;
    }

    public Long getStatusId() 
    {
        return statusId;
    }
    public void setStudentId(Long studentId) 
    {
        this.studentId = studentId;
    }

    public Long getStudentId() 
    {
        return studentId;
    }
    public void setStatusType(String statusType) 
    {
        this.statusType = statusType;
    }

    public String getStatusType() 
    {
        return statusType;
    }
    public void setStatusStartDate(Date statusStartDate) 
    {
        this.statusStartDate = statusStartDate;
    }

    public Date getStatusStartDate() 
    {
        return statusStartDate;
    }
    public void setStatusEndDate(Date statusEndDate) 
    {
        this.statusEndDate = statusEndDate;
    }

    public Date getStatusEndDate() 
    {
        return statusEndDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("statusId", getStatusId())
            .append("studentId", getStudentId())
            .append("statusType", getStatusType())
            .append("statusStartDate", getStatusStartDate())
            .append("statusEndDate", getStatusEndDate())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
