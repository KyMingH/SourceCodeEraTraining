package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * StudentRegularApproval对象 student_regular_approval
 * 
 * @author ttKymingH
 * @date 2024-06-25
 */
public class StudentRegularApproval extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 审批ID（主键） */
    private Long approvalId;

    /** 学员ID（外键，关联students） */
    @Excel(name = "学员ID", readConverterExp = "外=键，关联students")
    private Long studentId;

    /** 试听学员ID（外键，关联trial_students） */
    @Excel(name = "试听学员ID", readConverterExp = "外=键，关联trial_students")
    private Long trialStudentId;

    /** 审批人 */
    @Excel(name = "审批人")
    private String approver;

    /** 审批状态 */
    @Excel(name = "审批状态")
    private String approvalStatus;

    /** 审批时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "审批时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date approvalTime;

    /** 审批意见 */
    @Excel(name = "审批意见")
    private String approvalRemark;

    public void setApprovalId(Long approvalId) 
    {
        this.approvalId = approvalId;
    }

    public Long getApprovalId() 
    {
        return approvalId;
    }
    public void setStudentId(Long studentId) 
    {
        this.studentId = studentId;
    }

    public Long getStudentId() 
    {
        return studentId;
    }
    public void setTrialStudentId(Long trialStudentId) 
    {
        this.trialStudentId = trialStudentId;
    }

    public Long getTrialStudentId() 
    {
        return trialStudentId;
    }
    public void setApprover(String approver) 
    {
        this.approver = approver;
    }

    public String getApprover() 
    {
        return approver;
    }
    public void setApprovalStatus(String approvalStatus) 
    {
        this.approvalStatus = approvalStatus;
    }

    public String getApprovalStatus() 
    {
        return approvalStatus;
    }
    public void setApprovalTime(Date approvalTime) 
    {
        this.approvalTime = approvalTime;
    }

    public Date getApprovalTime() 
    {
        return approvalTime;
    }
    public void setApprovalRemark(String approvalRemark) 
    {
        this.approvalRemark = approvalRemark;
    }

    public String getApprovalRemark() 
    {
        return approvalRemark;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("approvalId", getApprovalId())
            .append("studentId", getStudentId())
            .append("trialStudentId", getTrialStudentId())
            .append("approver", getApprover())
            .append("approvalStatus", getApprovalStatus())
            .append("approvalTime", getApprovalTime())
            .append("approvalRemark", getApprovalRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
