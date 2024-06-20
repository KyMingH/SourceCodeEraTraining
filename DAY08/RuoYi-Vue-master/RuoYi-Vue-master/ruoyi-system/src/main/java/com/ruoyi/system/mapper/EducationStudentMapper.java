package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.EducationStudent;

/**
 * 学生管理Mapper接口
 * 
 * @author kkmingKy
 * @date 2024-06-20
 */
public interface EducationStudentMapper 
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
     * 删除学生管理
     * 
     * @param id 学生管理主键
     * @return 结果
     */
    public int deleteEducationStudentById(Long id);

    /**
     * 批量删除学生管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEducationStudentByIds(Long[] ids);
}
