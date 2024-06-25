package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ClassManagementMapper;
import com.ruoyi.system.domain.ClassManagement;
import com.ruoyi.system.service.IClassManagementService;

/**
 * class_managementService业务层处理
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
@Service
public class ClassManagementServiceImpl implements IClassManagementService 
{
    @Autowired
    private ClassManagementMapper classManagementMapper;

    /**
     * 查询class_management
     * 
     * @param operationId class_management主键
     * @return class_management
     */
    @Override
    public ClassManagement selectClassManagementByOperationId(Long operationId)
    {
        return classManagementMapper.selectClassManagementByOperationId(operationId);
    }

    /**
     * 查询class_management列表
     * 
     * @param classManagement class_management
     * @return class_management
     */
    @Override
    public List<ClassManagement> selectClassManagementList(ClassManagement classManagement)
    {
        return classManagementMapper.selectClassManagementList(classManagement);
    }

    /**
     * 新增class_management
     * 
     * @param classManagement class_management
     * @return 结果
     */
    @Override
    public int insertClassManagement(ClassManagement classManagement)
    {
        classManagement.setCreateTime(DateUtils.getNowDate());
        return classManagementMapper.insertClassManagement(classManagement);
    }

    /**
     * 修改class_management
     * 
     * @param classManagement class_management
     * @return 结果
     */
    @Override
    public int updateClassManagement(ClassManagement classManagement)
    {
        classManagement.setUpdateTime(DateUtils.getNowDate());
        return classManagementMapper.updateClassManagement(classManagement);
    }

    /**
     * 批量删除class_management
     * 
     * @param operationIds 需要删除的class_management主键
     * @return 结果
     */
    @Override
    public int deleteClassManagementByOperationIds(Long[] operationIds)
    {
        return classManagementMapper.deleteClassManagementByOperationIds(operationIds);
    }

    /**
     * 删除class_management信息
     * 
     * @param operationId class_management主键
     * @return 结果
     */
    @Override
    public int deleteClassManagementByOperationId(Long operationId)
    {
        return classManagementMapper.deleteClassManagementByOperationId(operationId);
    }
}
