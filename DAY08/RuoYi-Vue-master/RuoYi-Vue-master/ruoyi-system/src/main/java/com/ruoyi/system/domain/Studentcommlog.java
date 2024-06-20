package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 沟通记录对象 studentcommlog
 * 
 * @author ttmingKy
 * @date 2024-06-20
 */
public class Studentcommlog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 沟通时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "沟通时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date communicationTime;

    /** 沟通学生 */
    @Excel(name = "沟通学生")
    private String studentInvolved;

    /** 沟通老师 */
    @Excel(name = "沟通老师")
    private String teacherInvolved;

    /** 沟通问题 */
    @Excel(name = "沟通问题")
    private String communicationIssue;

    /** 沟通反馈 */
    @Excel(name = "沟通反馈")
    private String feedbackReceived;

    /** 计划下次沟通日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计划下次沟通日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date nextCommunicationSchedule;

    /** 沟通效果（评级） */
    @Excel(name = "沟通效果", readConverterExp = "评=级")
    private String communicationEffectivenessRating;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCommunicationTime(Date communicationTime) 
    {
        this.communicationTime = communicationTime;
    }

    public Date getCommunicationTime() 
    {
        return communicationTime;
    }
    public void setStudentInvolved(String studentInvolved) 
    {
        this.studentInvolved = studentInvolved;
    }

    public String getStudentInvolved() 
    {
        return studentInvolved;
    }
    public void setTeacherInvolved(String teacherInvolved) 
    {
        this.teacherInvolved = teacherInvolved;
    }

    public String getTeacherInvolved() 
    {
        return teacherInvolved;
    }
    public void setCommunicationIssue(String communicationIssue) 
    {
        this.communicationIssue = communicationIssue;
    }

    public String getCommunicationIssue() 
    {
        return communicationIssue;
    }
    public void setFeedbackReceived(String feedbackReceived) 
    {
        this.feedbackReceived = feedbackReceived;
    }

    public String getFeedbackReceived() 
    {
        return feedbackReceived;
    }
    public void setNextCommunicationSchedule(Date nextCommunicationSchedule) 
    {
        this.nextCommunicationSchedule = nextCommunicationSchedule;
    }

    public Date getNextCommunicationSchedule() 
    {
        return nextCommunicationSchedule;
    }
    public void setCommunicationEffectivenessRating(String communicationEffectivenessRating) 
    {
        this.communicationEffectivenessRating = communicationEffectivenessRating;
    }

    public String getCommunicationEffectivenessRating() 
    {
        return communicationEffectivenessRating;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("communicationTime", getCommunicationTime())
            .append("studentInvolved", getStudentInvolved())
            .append("teacherInvolved", getTeacherInvolved())
            .append("communicationIssue", getCommunicationIssue())
            .append("feedbackReceived", getFeedbackReceived())
            .append("nextCommunicationSchedule", getNextCommunicationSchedule())
            .append("communicationEffectivenessRating", getCommunicationEffectivenessRating())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
