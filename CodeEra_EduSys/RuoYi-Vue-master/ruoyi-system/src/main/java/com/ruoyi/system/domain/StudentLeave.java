package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * student_leave对象 student_leave
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
public class StudentLeave extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 请假ID */
    private Long leaveId;

    /** 学员ID（外键，关联students） */
    @Excel(name = "学员ID", readConverterExp = "外=键，关联students")
    private Long studentId;

    /** 请假类型（病假、事假等） */
    @Excel(name = "请假类型", readConverterExp = "病=假、事假等")
    private String leaveType;

    /** 请假开始日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "请假开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date leaveStartDate;

    /** 请假结束日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "请假结束日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date leaveEndDate;

    /** 审批状态 */
    @Excel(name = "审批状态")
    private String approvalStatus;

    public void setLeaveId(Long leaveId) 
    {
        this.leaveId = leaveId;
    }

    public Long getLeaveId() 
    {
        return leaveId;
    }
    public void setStudentId(Long studentId) 
    {
        this.studentId = studentId;
    }

    public Long getStudentId() 
    {
        return studentId;
    }
    public void setLeaveType(String leaveType) 
    {
        this.leaveType = leaveType;
    }

    public String getLeaveType() 
    {
        return leaveType;
    }
    public void setLeaveStartDate(Date leaveStartDate) 
    {
        this.leaveStartDate = leaveStartDate;
    }

    public Date getLeaveStartDate() 
    {
        return leaveStartDate;
    }
    public void setLeaveEndDate(Date leaveEndDate) 
    {
        this.leaveEndDate = leaveEndDate;
    }

    public Date getLeaveEndDate() 
    {
        return leaveEndDate;
    }
    public void setApprovalStatus(String approvalStatus) 
    {
        this.approvalStatus = approvalStatus;
    }

    public String getApprovalStatus() 
    {
        return approvalStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("leaveId", getLeaveId())
            .append("studentId", getStudentId())
            .append("leaveType", getLeaveType())
            .append("leaveStartDate", getLeaveStartDate())
            .append("leaveEndDate", getLeaveEndDate())
            .append("approvalStatus", getApprovalStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
