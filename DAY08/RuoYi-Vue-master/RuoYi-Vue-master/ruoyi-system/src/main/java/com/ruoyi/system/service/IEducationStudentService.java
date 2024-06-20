package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.EducationStudent;

/**
 * 学生管理Service接口
 * 
 * @author kkmingKy
 * @date 2024-06-20
 */
public interface IEducationStudentService 
{
    /**
     * 查询学生管理
     * 
     * @param id 学生管理主键
     * @return 学生管理
     */
    public EducationStudent selectEducationStudentById(Long id);

    /**
     * 查询学生管理列表
     * 
     * @param educationStudent 学生管理
     * @return 学生管理集合
     */
    public List<EducationStudent> selectEducationStudentList(EducationStudent educationStudent);

    /**
     * 新增学生管理
     * 
     * @param educationStudent 学生管理
     * @return 结果
     */
    public int insertEducationStudent(EducationStudent educationStudent);

    /**
     * 修改学生管理
     * 
     * @param educationStudent 学生管理
     * @return 结果
     */
    public int updateEducationStudent(EducationStudent educationStudent);

    /**
     * 批量删除学生管理
     * 
     * @param ids 需要删除的学生管理主键集合
     * @return 结果
     */
    public int deleteEducationStudentByIds(Long[] ids);

    /**
     * 删除学生管理信息
     * 
     * @param id 学生管理主键
     * @return 结果
     */
    public int deleteEducationStudentById(Long id);
}
