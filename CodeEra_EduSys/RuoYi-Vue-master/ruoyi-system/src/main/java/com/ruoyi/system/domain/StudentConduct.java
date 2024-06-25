package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * student_conduct对象 student_conduct
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
public class StudentConduct extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 操行分ID */
    private Long conductId;

    /** 学员ID（外键，关联students） */
    @Excel(name = "学员ID", readConverterExp = "外=键，关联students")
    private Long studentId;

    /** 操行分 */
    @Excel(name = "操行分")
    private Long conductScore;

    /** 操行分变动原因 */
    @Excel(name = "操行分变动原因")
    private String conductChangeReason;

    /** 记录日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "记录日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date recordDate;

    public void setConductId(Long conductId) 
    {
        this.conductId = conductId;
    }

    public Long getConductId() 
    {
        return conductId;
    }
    public void setStudentId(Long studentId) 
    {
        this.studentId = studentId;
    }

    public Long getStudentId() 
    {
        return studentId;
    }
    public void setConductScore(Long conductScore) 
    {
        this.conductScore = conductScore;
    }

    public Long getConductScore() 
    {
        return conductScore;
    }
    public void setConductChangeReason(String conductChangeReason) 
    {
        this.conductChangeReason = conductChangeReason;
    }

    public String getConductChangeReason() 
    {
        return conductChangeReason;
    }
    public void setRecordDate(Date recordDate) 
    {
        this.recordDate = recordDate;
    }

    public Date getRecordDate() 
    {
        return recordDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("conductId", getConductId())
            .append("studentId", getStudentId())
            .append("conductScore", getConductScore())
            .append("conductChangeReason", getConductChangeReason())
            .append("recordDate", getRecordDate())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
