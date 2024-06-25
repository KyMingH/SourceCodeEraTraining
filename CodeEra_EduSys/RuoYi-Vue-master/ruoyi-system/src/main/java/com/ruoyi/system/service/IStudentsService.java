package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Students;

/**
 * 学员基本信息Service接口
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
public interface IStudentsService 
{
    /**
     * 查询学员基本信息
     * 
     * @param studentId 学员基本信息主键
     * @return 学员基本信息
     */
    public Students selectStudentsByStudentId(Long studentId);

    /**
     * 查询学员基本信息列表
     * 
     * @param students 学员基本信息
     * @return 学员基本信息集合
     */
    public List<Students> selectStudentsList(Students students);

    /**
     * 新增学员基本信息
     * 
     * @param students 学员基本信息
     * @return 结果
     */
    public int insertStudents(Students students);

    /**
     * 修改学员基本信息
     * 
     * @param students 学员基本信息
     * @return 结果
     */
    public int updateStudents(Students students);

    /**
     * 批量删除学员基本信息
     * 
     * @param studentIds 需要删除的学员基本信息主键集合
     * @return 结果
     */
    public int deleteStudentsByStudentIds(Long[] studentIds);

    /**
     * 删除学员基本信息信息
     * 
     * @param studentId 学员基本信息主键
     * @return 结果
     */
    public int deleteStudentsByStudentId(Long studentId);
}
