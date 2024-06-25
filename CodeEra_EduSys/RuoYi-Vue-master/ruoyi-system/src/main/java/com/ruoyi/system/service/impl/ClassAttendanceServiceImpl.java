package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ClassAttendanceMapper;
import com.ruoyi.system.domain.ClassAttendance;
import com.ruoyi.system.service.IClassAttendanceService;

/**
 * class_attendanceService业务层处理
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
@Service
public class ClassAttendanceServiceImpl implements IClassAttendanceService 
{
    @Autowired
    private ClassAttendanceMapper classAttendanceMapper;

    /**
     * 查询class_attendance
     * 
     * @param attendanceId class_attendance主键
     * @return class_attendance
     */
    @Override
    public ClassAttendance selectClassAttendanceByAttendanceId(Long attendanceId)
    {
        return classAttendanceMapper.selectClassAttendanceByAttendanceId(attendanceId);
    }

    /**
     * 查询class_attendance列表
     * 
     * @param classAttendance class_attendance
     * @return class_attendance
     */
    @Override
    public List<ClassAttendance> selectClassAttendanceList(ClassAttendance classAttendance)
    {
        return classAttendanceMapper.selectClassAttendanceList(classAttendance);
    }

    /**
     * 新增class_attendance
     * 
     * @param classAttendance class_attendance
     * @return 结果
     */
    @Override
    public int insertClassAttendance(ClassAttendance classAttendance)
    {
        classAttendance.setCreateTime(DateUtils.getNowDate());
        return classAttendanceMapper.insertClassAttendance(classAttendance);
    }

    /**
     * 修改class_attendance
     * 
     * @param classAttendance class_attendance
     * @return 结果
     */
    @Override
    public int updateClassAttendance(ClassAttendance classAttendance)
    {
        classAttendance.setUpdateTime(DateUtils.getNowDate());
        return classAttendanceMapper.updateClassAttendance(classAttendance);
    }

    /**
     * 批量删除class_attendance
     * 
     * @param attendanceIds 需要删除的class_attendance主键
     * @return 结果
     */
    @Override
    public int deleteClassAttendanceByAttendanceIds(Long[] attendanceIds)
    {
        return classAttendanceMapper.deleteClassAttendanceByAttendanceIds(attendanceIds);
    }

    /**
     * 删除class_attendance信息
     * 
     * @param attendanceId class_attendance主键
     * @return 结果
     */
    @Override
    public int deleteClassAttendanceByAttendanceId(Long attendanceId)
    {
        return classAttendanceMapper.deleteClassAttendanceByAttendanceId(attendanceId);
    }
}
