package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * class_attendance对象 class_attendance
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
public class ClassAttendance extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 考勤ID */
    private Long attendanceId;

    /** 班级ID（外键，关联classes） */
    @Excel(name = "班级ID", readConverterExp = "外=键，关联classes")
    private Long classId;

    /** 学员ID（外键，关联students） */
    @Excel(name = "学员ID", readConverterExp = "外=键，关联students")
    private Long studentId;

    /** 考勤日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "考勤日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date attendanceDate;

    /** 考勤状态（出勤、缺勤、迟到等） */
    @Excel(name = "考勤状态", readConverterExp = "出=勤、缺勤、迟到等")
    private String attendanceStatus;

    public void setAttendanceId(Long attendanceId) 
    {
        this.attendanceId = attendanceId;
    }

    public Long getAttendanceId() 
    {
        return attendanceId;
    }
    public void setClassId(Long classId) 
    {
        this.classId = classId;
    }

    public Long getClassId() 
    {
        return classId;
    }
    public void setStudentId(Long studentId) 
    {
        this.studentId = studentId;
    }

    public Long getStudentId() 
    {
        return studentId;
    }
    public void setAttendanceDate(Date attendanceDate) 
    {
        this.attendanceDate = attendanceDate;
    }

    public Date getAttendanceDate() 
    {
        return attendanceDate;
    }
    public void setAttendanceStatus(String attendanceStatus) 
    {
        this.attendanceStatus = attendanceStatus;
    }

    public String getAttendanceStatus() 
    {
        return attendanceStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("attendanceId", getAttendanceId())
            .append("classId", getClassId())
            .append("studentId", getStudentId())
            .append("attendanceDate", getAttendanceDate())
            .append("attendanceStatus", getAttendanceStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
