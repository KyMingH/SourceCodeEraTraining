package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * class_activities对象 class_activities
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
public class ClassActivities extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 活动ID */
    private Long activityId;

    /** 班级ID（外键，关联classes） */
    @Excel(name = "班级ID", readConverterExp = "外=键，关联classes")
    private Long classId;

    /** 活动名称 */
    @Excel(name = "活动名称")
    private String activityName;

    /** 活动日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "活动日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date activityDate;

    /** 活动描述 */
    @Excel(name = "活动描述")
    private String activityDescription;

    public void setActivityId(Long activityId) 
    {
        this.activityId = activityId;
    }

    public Long getActivityId() 
    {
        return activityId;
    }
    public void setClassId(Long classId) 
    {
        this.classId = classId;
    }

    public Long getClassId() 
    {
        return classId;
    }
    public void setActivityName(String activityName) 
    {
        this.activityName = activityName;
    }

    public String getActivityName() 
    {
        return activityName;
    }
    public void setActivityDate(Date activityDate) 
    {
        this.activityDate = activityDate;
    }

    public Date getActivityDate() 
    {
        return activityDate;
    }
    public void setActivityDescription(String activityDescription) 
    {
        this.activityDescription = activityDescription;
    }

    public String getActivityDescription() 
    {
        return activityDescription;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("activityId", getActivityId())
            .append("classId", getClassId())
            .append("activityName", getActivityName())
            .append("activityDate", getActivityDate())
            .append("activityDescription", getActivityDescription())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
