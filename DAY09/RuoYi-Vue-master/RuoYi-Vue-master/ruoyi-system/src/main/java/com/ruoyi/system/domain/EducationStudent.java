package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生管理对象 education_student
 *
 * @author kkmingKy
 * @date 2024-06-21
 */
public class EducationStudent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String name;

    /** 学生性别 */
    @Excel(name = "学生性别")
    private String gender;

    /** 大学名称 */
    @Excel(name = "大学名称")
    private String nameUniversity;

    /** 大学专业 */
    @Excel(name = "大学专业")
    private String collegeMajors;

    /** 学生学历 */
    @Excel(name = "学生学历")
    private String degree;

    /** 毕业时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "毕业时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date graduationTime;

    /** 是否全日制 */
    @Excel(name = "是否全日制")
    private String fullTimeStatus;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phoneNumber;

    /** 身份证号码 */
    @Excel(name = "身份证号码")
    private String idNumber;

    /** 所在班级 */
    @Excel(name = "所在班级")
    private String currentClass;

    /** 班主任 */
    @Excel(name = "班主任")
    private String homeroomTeacher;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getGender()
    {
        return gender;
    }
    public void setNameUniversity(String nameUniversity)
    {
        this.nameUniversity = nameUniversity;
    }

    public String getNameUniversity()
    {
        return nameUniversity;
    }
    public void setCollegeMajors(String collegeMajors)
    {
        this.collegeMajors = collegeMajors;
    }

    public String getCollegeMajors()
    {
        return collegeMajors;
    }
    public void setDegree(String degree)
    {
        this.degree = degree;
    }

    public String getDegree()
    {
        return degree;
    }
    public void setGraduationTime(Date graduationTime)
    {
        this.graduationTime = graduationTime;
    }

    public Date getGraduationTime()
    {
        return graduationTime;
    }
    public void setFullTimeStatus(String fullTimeStatus)
    {
        this.fullTimeStatus = fullTimeStatus;
    }

    public String getFullTimeStatus()
    {
        return fullTimeStatus;
    }
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    public void setIdNumber(String idNumber)
    {
        this.idNumber = idNumber;
    }

    public String getIdNumber()
    {
        return idNumber;
    }
    public void setCurrentClass(String currentClass)
    {
        this.currentClass = currentClass;
    }

    public String getCurrentClass()
    {
        return currentClass;
    }
    public void setHomeroomTeacher(String homeroomTeacher)
    {
        this.homeroomTeacher = homeroomTeacher;
    }

    public String getHomeroomTeacher()
    {
        return homeroomTeacher;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("gender", getGender())
                .append("nameUniversity", getNameUniversity())
                .append("collegeMajors", getCollegeMajors())
                .append("degree", getDegree())
                .append("graduationTime", getGraduationTime())
                .append("fullTimeStatus", getFullTimeStatus())
                .append("phoneNumber", getPhoneNumber())
                .append("idNumber", getIdNumber())
                .append("currentClass", getCurrentClass())
                .append("homeroomTeacher", getHomeroomTeacher())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
