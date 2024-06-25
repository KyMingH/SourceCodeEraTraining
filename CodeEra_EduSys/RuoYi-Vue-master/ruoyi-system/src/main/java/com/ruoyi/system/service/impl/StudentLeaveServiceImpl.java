package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StudentLeaveMapper;
import com.ruoyi.system.domain.StudentLeave;
import com.ruoyi.system.service.IStudentLeaveService;

/**
 * student_leaveService业务层处理
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
@Service
public class StudentLeaveServiceImpl implements IStudentLeaveService 
{
    @Autowired
    private StudentLeaveMapper studentLeaveMapper;

    /**
     * 查询student_leave
     * 
     * @param leaveId student_leave主键
     * @return student_leave
     */
    @Override
    public StudentLeave selectStudentLeaveByLeaveId(Long leaveId)
    {
        return studentLeaveMapper.selectStudentLeaveByLeaveId(leaveId);
    }

    /**
     * 查询student_leave列表
     * 
     * @param studentLeave student_leave
     * @return student_leave
     */
    @Override
    public List<StudentLeave> selectStudentLeaveList(StudentLeave studentLeave)
    {
        return studentLeaveMapper.selectStudentLeaveList(studentLeave);
    }

    /**
     * 新增student_leave
     * 
     * @param studentLeave student_leave
     * @return 结果
     */
//    @Override
//    public int insertStudentLeave(StudentLeave studentLeave)
//    {
//        studentLeave.setCreateTime(DateUtils.getNowDate());
//        return studentLeaveMapper.insertStudentLeave(studentLeave);
//    }
    @Override
    public Long insertStudentLeave(StudentLeave studentLeave) {
        studentLeave.setCreateTime(DateUtils.getNowDate());
        int rowsAffected = studentLeaveMapper.insertStudentLeave(studentLeave);
        if (rowsAffected > 0) {
            // 插入成功，并且 leaveId 应该已经被 MyBatis 设置
            return studentLeave.getLeaveId();
        } else {
            // 处理插入失败的情况，例如抛出自定义异常
            throw new RuntimeException("Inserting student leave failed.");
        }
    }

    /**
     * 修改student_leave
     * 
     * @param studentLeave student_leave
     * @return 结果
     */
    @Override
    public int updateStudentLeave(StudentLeave studentLeave)
    {
        studentLeave.setUpdateTime(DateUtils.getNowDate());
        return studentLeaveMapper.updateStudentLeave(studentLeave);
    }

    /**
     * 批量删除student_leave
     * 
     * @param leaveIds 需要删除的student_leave主键
     * @return 结果
     */
    @Override
    public int deleteStudentLeaveByLeaveIds(Long[] leaveIds)
    {
        return studentLeaveMapper.deleteStudentLeaveByLeaveIds(leaveIds);
    }

    /**
     * 删除student_leave信息
     * 
     * @param leaveId student_leave主键
     * @return 结果
     */
    @Override
    public int deleteStudentLeaveByLeaveId(Long leaveId)
    {
        return studentLeaveMapper.deleteStudentLeaveByLeaveId(leaveId);
    }
}
