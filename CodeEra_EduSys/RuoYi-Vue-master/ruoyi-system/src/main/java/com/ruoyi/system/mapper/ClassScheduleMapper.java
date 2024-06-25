package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ClassSchedule;

/**
 * class_scheduleMapper接口
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
public interface ClassScheduleMapper 
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
     * 删除class_schedule
     * 
     * @param scheduleId class_schedule主键
     * @return 结果
     */
    public int deleteClassScheduleByScheduleId(Long scheduleId);

    /**
     * 批量删除class_schedule
     * 
     * @param scheduleIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteClassScheduleByScheduleIds(Long[] scheduleIds);
}
