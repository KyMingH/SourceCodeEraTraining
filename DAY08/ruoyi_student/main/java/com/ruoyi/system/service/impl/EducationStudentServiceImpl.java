package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.EducationStudentMapper;
import com.ruoyi.system.domain.EducationStudent;
import com.ruoyi.system.service.IEducationStudentService;

/**
 * 学生管理Service业务层处理
 * 
 * @author kkmingKy
 * @date 2024-06-20
 */
@Service
public class EducationStudentServiceImpl implements IEducationStudentService 
{
    @Autowired
    private EducationStudentMapper educationStudentMapper;

    /**
     * 查询学生管理
     * 
     * @param id 学生管理主键
     * @return 学生管理
     */
    @Override
    public EducationStudent selectEducationStudentById(Long id)
    {
        return educationStudentMapper.selectEducationStudentById(id);
    }

    /**
     * 查询学生管理列表
     * 
     * @param educationStudent 学生管理
     * @return 学生管理
     */
    @Override
    public List<EducationStudent> selectEducationStudentList(EducationStudent educationStudent)
    {
        return educationStudentMapper.selectEducationStudentList(educationStudent);
    }

    /**
     * 新增学生管理
     * 
     * @param educationStudent 学生管理
     * @return 结果
     */
    @Override
    public int insertEducationStudent(EducationStudent educationStudent)
    {
        educationStudent.setCreateTime(DateUtils.getNowDate());
        return educationStudentMapper.insertEducationStudent(educationStudent);
    }

    /**
     * 修改学生管理
     * 
     * @param educationStudent 学生管理
     * @return 结果
     */
    @Override
    public int updateEducationStudent(EducationStudent educationStudent)
    {
        educationStudent.setUpdateTime(DateUtils.getNowDate());
        return educationStudentMapper.updateEducationStudent(educationStudent);
    }

    /**
     * 批量删除学生管理
     * 
     * @param ids 需要删除的学生管理主键
     * @return 结果
     */
    @Override
    public int deleteEducationStudentByIds(Long[] ids)
    {
        return educationStudentMapper.deleteEducationStudentByIds(ids);
    }

    /**
     * 删除学生管理信息
     * 
     * @param id 学生管理主键
     * @return 结果
     */
    @Override
    public int deleteEducationStudentById(Long id)
    {
        return educationStudentMapper.deleteEducationStudentById(id);
    }
}
