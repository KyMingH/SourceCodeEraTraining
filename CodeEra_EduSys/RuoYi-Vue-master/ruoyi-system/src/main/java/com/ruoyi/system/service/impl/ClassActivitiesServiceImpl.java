package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ClassActivitiesMapper;
import com.ruoyi.system.domain.ClassActivities;
import com.ruoyi.system.service.IClassActivitiesService;

/**
 * class_activitiesService业务层处理
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
@Service
public class ClassActivitiesServiceImpl implements IClassActivitiesService 
{
    @Autowired
    private ClassActivitiesMapper classActivitiesMapper;

    /**
     * 查询class_activities
     * 
     * @param activityId class_activities主键
     * @return class_activities
     */
    @Override
    public ClassActivities selectClassActivitiesByActivityId(Long activityId)
    {
        return classActivitiesMapper.selectClassActivitiesByActivityId(activityId);
    }

    /**
     * 查询class_activities列表
     * 
     * @param classActivities class_activities
     * @return class_activities
     */
    @Override
    public List<ClassActivities> selectClassActivitiesList(ClassActivities classActivities)
    {
        return classActivitiesMapper.selectClassActivitiesList(classActivities);
    }

    /**
     * 新增class_activities
     * 
     * @param classActivities class_activities
     * @return 结果
     */
    @Override
    public int insertClassActivities(ClassActivities classActivities)
    {
        classActivities.setCreateTime(DateUtils.getNowDate());
        return classActivitiesMapper.insertClassActivities(classActivities);
    }

    /**
     * 修改class_activities
     * 
     * @param classActivities class_activities
     * @return 结果
     */
    @Override
    public int updateClassActivities(ClassActivities classActivities)
    {
        classActivities.setUpdateTime(DateUtils.getNowDate());
        return classActivitiesMapper.updateClassActivities(classActivities);
    }

    /**
     * 批量删除class_activities
     * 
     * @param activityIds 需要删除的class_activities主键
     * @return 结果
     */
    @Override
    public int deleteClassActivitiesByActivityIds(Long[] activityIds)
    {
        return classActivitiesMapper.deleteClassActivitiesByActivityIds(activityIds);
    }

    /**
     * 删除class_activities信息
     * 
     * @param activityId class_activities主键
     * @return 结果
     */
    @Override
    public int deleteClassActivitiesByActivityId(Long activityId)
    {
        return classActivitiesMapper.deleteClassActivitiesByActivityId(activityId);
    }
}
