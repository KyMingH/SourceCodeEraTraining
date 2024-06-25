package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ClassScheduleMapper;
import com.ruoyi.system.domain.ClassSchedule;
import com.ruoyi.system.service.IClassScheduleService;

/**
 * class_scheduleService业务层处理
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
@Service
public class ClassScheduleServiceImpl implements IClassScheduleService 
{
    @Autowired
    private ClassScheduleMapper classScheduleMapper;

    /**
     * 查询class_schedule
     * 
     * @param scheduleId class_schedule主键
     * @return class_schedule
     */
    @Override
    public ClassSchedule selectClassScheduleByScheduleId(Long scheduleId)
    {
        return classScheduleMapper.selectClassScheduleByScheduleId(scheduleId);
    }

    /**
     * 查询class_schedule列表
     * 
     * @param classSchedule class_schedule
     * @return class_schedule
     */
    @Override
    public List<ClassSchedule> selectClassScheduleList(ClassSchedule classSchedule)
    {
        return classScheduleMapper.selectClassScheduleList(classSchedule);
    }

    /**
     * 新增class_schedule
     * 
     * @param classSchedule class_schedule
     * @return 结果
     */
    @Override
    public int insertClassSchedule(ClassSchedule classSchedule)
    {
        classSchedule.setCreateTime(DateUtils.getNowDate());
        return classScheduleMapper.insertClassSchedule(classSchedule);
    }

    /**
     * 修改class_schedule
     * 
     * @param classSchedule class_schedule
     * @return 结果
     */
    @Override
    public int updateClassSchedule(ClassSchedule classSchedule)
    {
        classSchedule.setUpdateTime(DateUtils.getNowDate());
        return classScheduleMapper.updateClassSchedule(classSchedule);
    }

    /**
     * 批量删除class_schedule
     * 
     * @param scheduleIds 需要删除的class_schedule主键
     * @return 结果
     */
    @Override
    public int deleteClassScheduleByScheduleIds(Long[] scheduleIds)
    {
        return classScheduleMapper.deleteClassScheduleByScheduleIds(scheduleIds);
    }

    /**
     * 删除class_schedule信息
     * 
     * @param scheduleId class_schedule主键
     * @return 结果
     */
    @Override
    public int deleteClassScheduleByScheduleId(Long scheduleId)
    {
        return classScheduleMapper.deleteClassScheduleByScheduleId(scheduleId);
    }
}
