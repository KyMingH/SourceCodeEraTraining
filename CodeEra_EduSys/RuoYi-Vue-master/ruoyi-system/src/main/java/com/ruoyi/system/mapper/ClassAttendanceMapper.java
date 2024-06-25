package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ClassAttendance;

/**
 * class_attendanceMapper接口
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
public interface ClassAttendanceMapper 
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
     * 删除class_attendance
     * 
     * @param attendanceId class_attendance主键
     * @return 结果
     */
    public int deleteClassAttendanceByAttendanceId(Long attendanceId);

    /**
     * 批量删除class_attendance
     * 
     * @param attendanceIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteClassAttendanceByAttendanceIds(Long[] attendanceIds);
}
