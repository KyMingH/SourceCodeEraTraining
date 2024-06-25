package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * alumni_follow_up对象 alumni_follow_up
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
public class AlumniFollowUp extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 回访ID */
    private Long followUpId;

    /** 学员ID（外键，关联students） */
    @Excel(name = "学员ID", readConverterExp = "外=键，关联students")
    private Long studentId;

    /** 回访日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "回访日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date followUpDate;

    /** 回访内容 */
    @Excel(name = "回访内容")
    private String followUpContent;

    /** 回访人 */
    @Excel(name = "回访人")
    private String followUpPerson;

    public void setFollowUpId(Long followUpId) 
    {
        this.followUpId = followUpId;
    }

    public Long getFollowUpId() 
    {
        return followUpId;
    }
    public void setStudentId(Long studentId) 
    {
        this.studentId = studentId;
    }

    public Long getStudentId() 
    {
        return studentId;
    }
    public void setFollowUpDate(Date followUpDate) 
    {
        this.followUpDate = followUpDate;
    }

    public Date getFollowUpDate() 
    {
        return followUpDate;
    }
    public void setFollowUpContent(String followUpContent) 
    {
        this.followUpContent = followUpContent;
    }

    public String getFollowUpContent() 
    {
        return followUpContent;
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
            .append("followUpId", getFollowUpId())
            .append("studentId", getStudentId())
            .append("followUpDate", getFollowUpDate())
            .append("followUpContent", getFollowUpContent())
            .append("followUpPerson", getFollowUpPerson())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
