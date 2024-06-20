package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 班级管理对象 education_class
 *
 * @author kkmingKy
 * @date 2024-06-20
 */
public class EducationClass extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 班级名称 */
    @Excel(name = "班级名称")
    private String className;

    /** 班级类型（数据字典） */
    @Excel(name = "班级类型", readConverterExp = "数=据字典")
    private String classType;

    /** 开班时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开班时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date beginTime;

    /** 实际开班时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "实际开班时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date beginTimeReal;

    /** 结课时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结课时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 实际结课时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "实际结课时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTimeReal;

    /** 班主任 */
    @Excel(name = "班主任")
    private String headteacher;

    /** 就业老师 */
    @Excel(name = "就业老师")
    private String teacher;

    /** 班级人数 */
    @Excel(name = "班级人数")
    private Long classSize;

    /** 状态（未开班、已开班、已结课） */
    @Excel(name = "状态", readConverterExp = "未=开班、已开班、已结课")
    private String state;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setClassName(String className)
    {
        this.className = className;
    }

    public String getClassName()
    {
        return className;
    }
    public void setClassType(String classType)
    {
        this.classType = classType;
    }

    public String getClassType()
    {
        return classType;
    }
    public void setBeginTime(Date beginTime)
    {
        this.beginTime = beginTime;
    }

    public Date getBeginTime()
    {
        return beginTime;
    }
    public void setBeginTimeReal(Date beginTimeReal)
    {
        this.beginTimeReal = beginTimeReal;
    }

    public Date getBeginTimeReal()
    {
        return beginTimeReal;
    }
    public void setEndTime(Date endTime)
    {
        this.endTime = endTime;
    }

    public Date getEndTime()
    {
        return endTime;
    }
    public void setEndTimeReal(Date endTimeReal)
    {
        this.endTimeReal = endTimeReal;
    }

    public Date getEndTimeReal()
    {
        return endTimeReal;
    }
    public void setHeadteacher(String headteacher)
    {
        this.headteacher = headteacher;
    }

    public String getHeadteacher()
    {
        return headteacher;
    }
    public void setTeacher(String teacher)
    {
        this.teacher = teacher;
    }

    public String getTeacher()
    {
        return teacher;
    }
    public void setClassSize(Long classSize)
    {
        this.classSize = classSize;
    }

    public Long getClassSize()
    {
        return classSize;
    }
    public void setState(String state)
    {
        this.state = state;
    }

    public String getState()
    {
        return state;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("className", getClassName())
                .append("classType", getClassType())
                .append("beginTime", getBeginTime())
                .append("beginTimeReal", getBeginTimeReal())
                .append("endTime", getEndTime())
                .append("endTimeReal", getEndTimeReal())
                .append("headteacher", getHeadteacher())
                .append("teacher", getTeacher())
                .append("classSize", getClassSize())
                .append("state", getState())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
