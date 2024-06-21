package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 记录转班记录对象 education_transfer_records
 * 
 * @author ttMingKy
 * @date 2024-06-21
 */
public class EducationTransferRecords extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 学生ID */
    @Excel(name = "学生ID")
    private Long studentId;

    /** 转出班级 */
    @Excel(name = "转出班级")
    private String fromClass;

    /** 转入班级 */
    @Excel(name = "转入班级")
    private String toClass;

    /** 转班时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "转班时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date transferDate;

    /** 转班原因 */
    @Excel(name = "转班原因")
    private String reason;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setStudentId(Long studentId) 
    {
        this.studentId = studentId;
    }

    public Long getStudentId() 
    {
        return studentId;
    }
    public void setFromClass(String fromClass) 
    {
        this.fromClass = fromClass;
    }

    public String getFromClass() 
    {
        return fromClass;
    }
    public void setToClass(String toClass) 
    {
        this.toClass = toClass;
    }

    public String getToClass() 
    {
        return toClass;
    }
    public void setTransferDate(Date transferDate) 
    {
        this.transferDate = transferDate;
    }

    public Date getTransferDate() 
    {
        return transferDate;
    }
    public void setReason(String reason) 
    {
        this.reason = reason;
    }

    public String getReason() 
    {
        return reason;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("studentId", getStudentId())
            .append("fromClass", getFromClass())
            .append("toClass", getToClass())
            .append("transferDate", getTransferDate())
            .append("reason", getReason())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
