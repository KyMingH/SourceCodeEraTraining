package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StudentsMapper;
import com.ruoyi.system.domain.Students;
import com.ruoyi.system.service.IStudentsService;

/**
 * 学员基本信息Service业务层处理
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
@Service
public class StudentsServiceImpl implements IStudentsService 
{
    @Autowired
    private StudentsMapper studentsMapper;

    /**
     * 查询学员基本信息
     * 
     * @param studentId 学员基本信息主键
     * @return 学员基本信息
     */
    @Override
    public Students selectStudentsByStudentId(Long studentId)
    {
        return studentsMapper.selectStudentsByStudentId(studentId);
    }

    /**
     * 查询学员基本信息列表
     * 
     * @param students 学员基本信息
     * @return 学员基本信息
     */
    @Override
    public List<Students> selectStudentsList(Students students)
    {
        return studentsMapper.selectStudentsList(students);
    }

    /**
     * 新增学员基本信息
     * 
     * @param students 学员基本信息
     * @return 结果
     */
    @Override
    public int insertStudents(Students students)
    {
        students.setCreateTime(DateUtils.getNowDate());
        return studentsMapper.insertStudents(students);
    }

    /**
     * 修改学员基本信息
     * 
     * @param students 学员基本信息
     * @return 结果
     */
    @Override
    public int updateStudents(Students students)
    {
        students.setUpdateTime(DateUtils.getNowDate());
        return studentsMapper.updateStudents(students);
    }

    /**
     * 批量删除学员基本信息
     * 
     * @param studentIds 需要删除的学员基本信息主键
     * @return 结果
     */
    @Override
    public int deleteStudentsByStudentIds(Long[] studentIds)
    {
        return studentsMapper.deleteStudentsByStudentIds(studentIds);
    }

    /**
     * 删除学员基本信息信息
     * 
     * @param studentId 学员基本信息主键
     * @return 结果
     */
    @Override
    public int deleteStudentsByStudentId(Long studentId)
    {
        return studentsMapper.deleteStudentsByStudentId(studentId);
    }
}
