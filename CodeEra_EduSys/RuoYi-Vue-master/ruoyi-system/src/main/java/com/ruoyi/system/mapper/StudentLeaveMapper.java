package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.StudentLeave;

/**
 * student_leaveMapper接口
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
public interface StudentLeaveMapper 
{
    /**
     * 查询student_leave
     * 
     * @param leaveId student_leave主键
     * @return student_leave
     */
    public StudentLeave selectStudentLeaveByLeaveId(Long leaveId);

    /**
     * 查询student_leave列表
     * 
     * @param studentLeave student_leave
     * @return student_leave集合
     */
    public List<StudentLeave> selectStudentLeaveList(StudentLeave studentLeave);

    /**
     * 新增student_leave
     * 
     * @param studentLeave student_leave
     * @return 结果
     */
    public int insertStudentLeave(StudentLeave studentLeave);

    /**
     * 修改student_leave
     * 
     * @param studentLeave student_leave
     * @return 结果
     */
    public int updateStudentLeave(StudentLeave studentLeave);

    /**
     * 删除student_leave
     * 
     * @param leaveId student_leave主键
     * @return 结果
     */
    public int deleteStudentLeaveByLeaveId(Long leaveId);

    /**
     * 批量删除student_leave
     * 
     * @param leaveIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStudentLeaveByLeaveIds(Long[] leaveIds);
}
