package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.ClassActivities;

/**
 * class_activitiesService接口
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
public interface IClassActivitiesService 
{
    /**
     * 查询class_activities
     * 
     * @param activityId class_activities主键
     * @return class_activities
     */
    public ClassActivities selectClassActivitiesByActivityId(Long activityId);

    /**
     * 查询class_activities列表
     * 
     * @param classActivities class_activities
     * @return class_activities集合
     */
    public List<ClassActivities> selectClassActivitiesList(ClassActivities classActivities);

    /**
     * 新增class_activities
     * 
     * @param classActivities class_activities
     * @return 结果
     */
    public int insertClassActivities(ClassActivities classActivities);

    /**
     * 修改class_activities
     * 
     * @param classActivities class_activities
     * @return 结果
     */
    public int updateClassActivities(ClassActivities classActivities);

    /**
     * 批量删除class_activities
     * 
     * @param activityIds 需要删除的class_activities主键集合
     * @return 结果
     */
    public int deleteClassActivitiesByActivityIds(Long[] activityIds);

    /**
     * 删除class_activities信息
     * 
     * @param activityId class_activities主键
     * @return 结果
     */
    public int deleteClassActivitiesByActivityId(Long activityId);
}
