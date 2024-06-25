package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * class_schedule对象 class_schedule
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
public class ClassSchedule extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 课表ID */
    private Long scheduleId;

    /** 班级ID */
    @Excel(name = "班级ID")
    private Long classId;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String courseName;

    /** 课程时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "课程时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date courseTime;

    /** 教师ID */
    @Excel(name = "教师ID")
    private Long teacherId;

    public void setScheduleId(Long scheduleId) 
    {
        this.scheduleId = scheduleId;
    }

    public Long getScheduleId() 
    {
        return scheduleId;
    }
    public void setClassId(Long classId) 
    {
        this.classId = classId;
    }

    public Long getClassId() 
    {
        return classId;
    }
    public void setCourseName(String courseName) 
    {
        this.courseName = courseName;
    }

    public String getCourseName() 
    {
        return courseName;
    }
    public void setCourseTime(Date courseTime) 
    {
        this.courseTime = courseTime;
    }

    public Date getCourseTime() 
    {
        return courseTime;
    }
    public void setTeacherId(Long teacherId) 
    {
        this.teacherId = teacherId;
    }

    public Long getTeacherId() 
    {
        return teacherId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("scheduleId", getScheduleId())
            .append("classId", getClassId())
            .append("courseName", getCourseName())
            .append("courseTime", getCourseTime())
            .append("teacherId", getTeacherId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
