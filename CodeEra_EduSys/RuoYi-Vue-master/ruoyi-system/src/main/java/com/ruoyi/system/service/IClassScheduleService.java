package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.ClassSchedule;

/**
 * class_scheduleService接口
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
public interface IClassScheduleService 
{
    /**
     * 查询class_schedule
     * 
     * @param scheduleId class_schedule主键
     * @return class_schedule
     */
    public ClassSchedule selectClassScheduleByScheduleId(Long scheduleId);

    /**
     * 查询class_schedule列表
     * 
     * @param classSchedule class_schedule
     * @return class_schedule集合
     */
    public List<ClassSchedule> selectClassScheduleList(ClassSchedule classSchedule);

    /**
     * 新增class_schedule
     * 
     * @param classSchedule class_schedule
     * @return 结果
     */
    public int insertClassSchedule(ClassSchedule classSchedule);

    /**
     * 修改class_schedule
     * 
     * @param classSchedule class_schedule
     * @return 结果
     */
    public int updateClassSchedule(ClassSchedule classSchedule);

    /**
     * 批量删除class_schedule
     * 
     * @param scheduleIds 需要删除的class_schedule主键集合
     * @return 结果
     */
    public int deleteClassScheduleByScheduleIds(Long[] scheduleIds);

    /**
     * 删除class_schedule信息
     * 
     * @param scheduleId class_schedule主键
     * @return 结果
     */
    public int deleteClassScheduleByScheduleId(Long scheduleId);
}
