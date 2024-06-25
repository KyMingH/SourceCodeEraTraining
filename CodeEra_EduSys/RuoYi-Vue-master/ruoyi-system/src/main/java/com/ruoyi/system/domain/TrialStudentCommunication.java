package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * TrialStudentCommunication对象 trial_student_communication
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
public class TrialStudentCommunication extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 沟通记录ID（主键） */
    private Long communicationId;

    /** 试听学员ID（外键，关联trial_students） */
    @Excel(name = "试听学员ID", readConverterExp = "外=键，关联trial_students")
    private Long trialStudentId;

    /** 沟通日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "沟通日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date communicationDate;

    /** 沟通内容 */
    @Excel(name = "沟通内容")
    private String communicationContent;

    /** 后续行动计划 */
    @Excel(name = "后续行动计划")
    private String followUpActions;

    public void setCommunicationId(Long communicationId) 
    {
        this.communicationId = communicationId;
    }

    public Long getCommunicationId() 
    {
        return communicationId;
    }
    public void setTrialStudentId(Long trialStudentId) 
    {
        this.trialStudentId = trialStudentId;
    }

    public Long getTrialStudentId() 
    {
        return trialStudentId;
    }
    public void setCommunicationDate(Date communicationDate) 
    {
        this.communicationDate = communicationDate;
    }

    public Date getCommunicationDate() 
    {
        return communicationDate;
    }
    public void setCommunicationContent(String communicationContent) 
    {
        this.communicationContent = communicationContent;
    }

    public String getCommunicationContent() 
    {
        return communicationContent;
    }
    public void setFollowUpActions(String followUpActions) 
    {
        this.followUpActions = followUpActions;
    }

    public String getFollowUpActions() 
    {
        return followUpActions;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("communicationId", getCommunicationId())
            .append("trialStudentId", getTrialStudentId())
            .append("communicationDate", getCommunicationDate())
            .append("communicationContent", getCommunicationContent())
            .append("followUpActions", getFollowUpActions())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
