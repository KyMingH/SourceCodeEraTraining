package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * problem_student对象 problem_student
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
public class ProblemStudent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 记录ID */
    private Long recordId;

    /** 学员ID（外键，关联students） */
    @Excel(name = "学员ID", readConverterExp = "外=键，关联students")
    private Long studentId;

    /** 分类（问题学员类型） */
    @Excel(name = "分类", readConverterExp = "问=题学员类型")
    private String category;

    /** 沟通内容 */
    @Excel(name = "沟通内容")
    private String communicationContent;

    /** 沟通日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "沟通日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date communicationDate;

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
    public void setCategory(String category) 
    {
        this.category = category;
    }

    public String getCategory() 
    {
        return category;
    }
    public void setCommunicationContent(String communicationContent) 
    {
        this.communicationContent = communicationContent;
    }

    public String getCommunicationContent() 
    {
        return communicationContent;
    }
    public void setCommunicationDate(Date communicationDate) 
    {
        this.communicationDate = communicationDate;
    }

    public Date getCommunicationDate() 
    {
        return communicationDate;
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
            .append("category", getCategory())
            .append("communicationContent", getCommunicationContent())
            .append("communicationDate", getCommunicationDate())
            .append("followUpPerson", getFollowUpPerson())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
