package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * class_management对象 class_management
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
public class ClassManagement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 操作ID */
    private Long operationId;

    /** 班级ID（外键，关联classes） */
    @Excel(name = "班级ID", readConverterExp = "外=键，关联classes")
    private Long classId;

    /** 操作类型（添加/修改/删除） */
    @Excel(name = "操作类型", readConverterExp = "添=加/修改/删除")
    private String operationType;

    /** 操作日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "操作日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date operationDate;

    /** 操作员 */
    @Excel(name = "操作员")
    private String operator;

    public void setOperationId(Long operationId) 
    {
        this.operationId = operationId;
    }

    public Long getOperationId() 
    {
        return operationId;
    }
    public void setClassId(Long classId) 
    {
        this.classId = classId;
    }

    public Long getClassId() 
    {
        return classId;
    }
    public void setOperationType(String operationType) 
    {
        this.operationType = operationType;
    }

    public String getOperationType() 
    {
        return operationType;
    }
    public void setOperationDate(Date operationDate) 
    {
        this.operationDate = operationDate;
    }

    public Date getOperationDate() 
    {
        return operationDate;
    }
    public void setOperator(String operator) 
    {
        this.operator = operator;
    }

    public String getOperator() 
    {
        return operator;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("operationId", getOperationId())
            .append("classId", getClassId())
            .append("operationType", getOperationType())
            .append("operationDate", getOperationDate())
            .append("operator", getOperator())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
