package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TeachersMapper;
import com.ruoyi.system.domain.Teachers;
import com.ruoyi.system.service.ITeachersService;

/**
 * teachersService业务层处理
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
@Service
public class TeachersServiceImpl implements ITeachersService 
{
    @Autowired
    private TeachersMapper teachersMapper;

    /**
     * 查询teachers
     * 
     * @param teacherId teachers主键
     * @return teachers
     */
    @Override
    public Teachers selectTeachersByTeacherId(Long teacherId)
    {
        return teachersMapper.selectTeachersByTeacherId(teacherId);
    }

    /**
     * 查询teachers列表
     * 
     * @param teachers teachers
     * @return teachers
     */
    @Override
    public List<Teachers> selectTeachersList(Teachers teachers)
    {
        return teachersMapper.selectTeachersList(teachers);
    }

    /**
     * 新增teachers
     * 
     * @param teachers teachers
     * @return 结果
     */
    @Override
    public int insertTeachers(Teachers teachers)
    {
        teachers.setCreateTime(DateUtils.getNowDate());
        return teachersMapper.insertTeachers(teachers);
    }

    /**
     * 修改teachers
     * 
     * @param teachers teachers
     * @return 结果
     */
    @Override
    public int updateTeachers(Teachers teachers)
    {
        teachers.setUpdateTime(DateUtils.getNowDate());
        return teachersMapper.updateTeachers(teachers);
    }

    /**
     * 批量删除teachers
     * 
     * @param teacherIds 需要删除的teachers主键
     * @return 结果
     */
    @Override
    public int deleteTeachersByTeacherIds(Long[] teacherIds)
    {
        return teachersMapper.deleteTeachersByTeacherIds(teacherIds);
    }

    /**
     * 删除teachers信息
     * 
     * @param teacherId teachers主键
     * @return 结果
     */
    @Override
    public int deleteTeachersByTeacherId(Long teacherId)
    {
        return teachersMapper.deleteTeachersByTeacherId(teacherId);
    }
}
