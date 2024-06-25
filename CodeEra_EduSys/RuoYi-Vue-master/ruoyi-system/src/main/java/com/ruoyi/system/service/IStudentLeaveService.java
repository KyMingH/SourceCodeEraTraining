package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.StudentLeave;

/**
 * student_leaveService接口
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
public interface IStudentLeaveService 
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
    public Long insertStudentLeave(StudentLeave studentLeave);

    /**
     * 修改student_leave
     * 
     * @param studentLeave student_leave
     * @return 结果
     */
    public int updateStudentLeave(StudentLeave studentLeave);

    /**
     * 批量删除student_leave
     * 
     * @param leaveIds 需要删除的student_leave主键集合
     * @return 结果
     */
    public int deleteStudentLeaveByLeaveIds(Long[] leaveIds);

    /**
     * 删除student_leave信息
     * 
     * @param leaveId student_leave主键
     * @return 结果
     */
    public int deleteStudentLeaveByLeaveId(Long leaveId);
}
