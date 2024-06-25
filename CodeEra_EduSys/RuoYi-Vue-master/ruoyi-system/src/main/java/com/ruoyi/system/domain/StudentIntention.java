package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * student_intention对象 student_intention
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
public class StudentIntention extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 记录ID */
    private Long recordId;

    /** 学员ID（外键，关联students） */
    @Excel(name = "学员ID", readConverterExp = "外=键，关联students")
    private Long studentId;

    /** 意向描述 */
    @Excel(name = "意向描述")
    private String intentionDescription;

    /** 记录日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "记录日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date recordDate;

    /** 跟进人 */
    @Excel(name = "跟进人")
    private String followUpPerson;

    public void setRecordId(Long recordId) 
    {
        this.recordId = recordId;
    }

    public Long getRecordId() 
    {
        return recordId;
    }
    public void setStudentId(Long studentId) 
    {
        this.studentId = studentId;
    }

    public Long getStudentId() 
    {
        return studentId;
    }
    public void setIntentionDescription(String intentionDescription) 
    {
        this.intentionDescription = intentionDescription;
    }

    public String getIntentionDescription() 
    {
        return intentionDescription;
    }
    public void setRecordDate(Date recordDate) 
    {
        this.recordDate = recordDate;
    }

    public Date getRecordDate() 
    {
        return recordDate;
    }
    public void setFollowUpPerson(String followUpPerson) 
    {
        this.followUpPerson = followUpPerson;
    }

    public String getFollowUpPerson() 
    {
        return followUpPerson;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("recordId", getRecordId())
            .append("studentId", getStudentId())
            .append("intentionDescription", getIntentionDescription())
            .append("recordDate", getRecordDate())
            .append("followUpPerson", getFollowUpPerson())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
