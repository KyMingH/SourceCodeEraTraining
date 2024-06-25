package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * ClassMeetings对象 class_meetings
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
public class ClassMeetings extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 会议ID（主键） */
    private Long meetingId;

    /** 班级ID（外键，关联classes） */
    @Excel(name = "班级ID", readConverterExp = "外=键，关联classes")
    private Long classId;

    /** 会议类型 */
    @Excel(name = "会议类型")
    private String meetingType;

    /** 会议日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "会议日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date meetingDate;

    /** 会议内容 */
    @Excel(name = "会议内容")
    private String meetingContent;

    /** 会议结果或决议 */
    @Excel(name = "会议结果或决议")
    private String meetingOutcome;

    public void setMeetingId(Long meetingId) 
    {
        this.meetingId = meetingId;
    }

    public Long getMeetingId() 
    {
        return meetingId;
    }
    public void setClassId(Long classId) 
    {
        this.classId = classId;
    }

    public Long getClassId() 
    {
        return classId;
    }
    public void setMeetingType(String meetingType) 
    {
        this.meetingType = meetingType;
    }

    public String getMeetingType() 
    {
        return meetingType;
    }
    public void setMeetingDate(Date meetingDate) 
    {
        this.meetingDate = meetingDate;
    }

    public Date getMeetingDate() 
    {
        return meetingDate;
    }
    public void setMeetingContent(String meetingContent) 
    {
        this.meetingContent = meetingContent;
    }

    public String getMeetingContent() 
    {
        return meetingContent;
    }
    public void setMeetingOutcome(String meetingOutcome) 
    {
        this.meetingOutcome = meetingOutcome;
    }

    public String getMeetingOutcome() 
    {
        return meetingOutcome;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("meetingId", getMeetingId())
            .append("classId", getClassId())
            .append("meetingType", getMeetingType())
            .append("meetingDate", getMeetingDate())
            .append("meetingContent", getMeetingContent())
            .append("meetingOutcome", getMeetingOutcome())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
