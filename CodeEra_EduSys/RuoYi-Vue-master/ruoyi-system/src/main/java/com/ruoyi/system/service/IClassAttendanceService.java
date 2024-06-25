package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.ClassAttendance;

/**
 * class_attendanceService接口
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
public interface IClassAttendanceService 
{
    /**
     * 查询class_attendance
     * 
     * @param attendanceId class_attendance主键
     * @return class_attendance
     */
    public ClassAttendance selectClassAttendanceByAttendanceId(Long attendanceId);

    /**
     * 查询class_attendance列表
     * 
     * @param classAttendance class_attendance
     * @return class_attendance集合
     */
    public List<ClassAttendance> selectClassAttendanceList(ClassAttendance classAttendance);

    /**
     * 新增class_attendance
     * 
     * @param classAttendance class_attendance
     * @return 结果
     */
    public int insertClassAttendance(ClassAttendance classAttendance);

    /**
     * 修改class_attendance
     * 
     * @param classAttendance class_attendance
     * @return 结果
     */
    public int updateClassAttendance(ClassAttendance classAttendance);

    /**
     * 批量删除class_attendance
     * 
     * @param attendanceIds 需要删除的class_attendance主键集合
     * @return 结果
     */
    public int deleteClassAttendanceByAttendanceIds(Long[] attendanceIds);

    /**
     * 删除class_attendance信息
     * 
     * @param attendanceId class_attendance主键
     * @return 结果
     */
    public int deleteClassAttendanceByAttendanceId(Long attendanceId);
}
