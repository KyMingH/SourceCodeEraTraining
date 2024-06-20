package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.EducationClassMapper;
import com.ruoyi.system.domain.EducationClass;
import com.ruoyi.system.service.IEducationClassService;

/**
 * 班级管理Service业务层处理
 * 
 * @author kkmingKy
 * @date 2024-06-20
 */
@Service
public class EducationClassServiceImpl implements IEducationClassService 
{
    @Autowired
    private EducationClassMapper educationClassMapper;

    /**
     * 查询班级管理
     * 
     * @param id 班级管理主键
     * @return 班级管理
     */
    @Override
    public EducationClass selectEducationClassById(Long id)
    {
        return educationClassMapper.selectEducationClassById(id);
    }

    /**
     * 查询班级管理列表
     * 
     * @param educationClass 班级管理
     * @return 班级管理
     */
    @Override
    public List<EducationClass> selectEducationClassList(EducationClass educationClass)
    {
        return educationClassMapper.selectEducationClassList(educationClass);
    }

    /**
     * 新增班级管理
     * 
     * @param educationClass 班级管理
     * @return 结果
     */
    @Override
    public int insertEducationClass(EducationClass educationClass)
    {
        educationClass.setCreateTime(DateUtils.getNowDate());
        return educationClassMapper.insertEducationClass(educationClass);
    }

    /**
     * 修改班级管理
     * 
     * @param educationClass 班级管理
     * @return 结果
     */
    @Override
    public int updateEducationClass(EducationClass educationClass)
    {
        educationClass.setUpdateTime(DateUtils.getNowDate());
        return educationClassMapper.updateEducationClass(educationClass);
    }

    /**
     * 批量删除班级管理
     * 
     * @param ids 需要删除的班级管理主键
     * @return 结果
     */
    @Override
    public int deleteEducationClassByIds(Long[] ids)
    {
        return educationClassMapper.deleteEducationClassByIds(ids);
    }

    /**
     * 删除班级管理信息
     * 
     * @param id 班级管理主键
     * @return 结果
     */
    @Override
    public int deleteEducationClassById(Long id)
    {
        return educationClassMapper.deleteEducationClassById(id);
    }
}
