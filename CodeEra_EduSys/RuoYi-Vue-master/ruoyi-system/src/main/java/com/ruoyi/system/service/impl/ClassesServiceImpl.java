package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ClassesMapper;
import com.ruoyi.system.domain.Classes;
import com.ruoyi.system.service.IClassesService;

/**
 * classesService业务层处理
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
@Service
public class ClassesServiceImpl implements IClassesService 
{
    @Autowired
    private ClassesMapper classesMapper;

    /**
     * 查询classes
     * 
     * @param classId classes主键
     * @return classes
     */
    @Override
    public Classes selectClassesByClassId(Long classId)
    {
        return classesMapper.selectClassesByClassId(classId);
    }

    /**
     * 查询classes列表
     * 
     * @param classes classes
     * @return classes
     */
    @Override
    public List<Classes> selectClassesList(Classes classes)
    {
        return classesMapper.selectClassesList(classes);
    }

    /**
     * 新增classes
     * 
     * @param classes classes
     * @return 结果
     */
    @Override
    public int insertClasses(Classes classes)
    {
        classes.setCreateTime(DateUtils.getNowDate());
        return classesMapper.insertClasses(classes);
    }

    /**
     * 修改classes
     * 
     * @param classes classes
     * @return 结果
     */
    @Override
    public int updateClasses(Classes classes)
    {
        classes.setUpdateTime(DateUtils.getNowDate());
        return classesMapper.updateClasses(classes);
    }

    /**
     * 批量删除classes
     * 
     * @param classIds 需要删除的classes主键
     * @return 结果
     */
    @Override
    public int deleteClassesByClassIds(Long[] classIds)
    {
        return classesMapper.deleteClassesByClassIds(classIds);
    }

    /**
     * 删除classes信息
     * 
     * @param classId classes主键
     * @return 结果
     */
    @Override
    public int deleteClassesByClassId(Long classId)
    {
        return classesMapper.deleteClassesByClassId(classId);
    }
}
