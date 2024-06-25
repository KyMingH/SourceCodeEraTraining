package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.ClassManagement;

/**
 * class_managementService接口
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
public interface IClassManagementService 
{
    /**
     * 查询class_management
     * 
     * @param operationId class_management主键
     * @return class_management
     */
    public ClassManagement selectClassManagementByOperationId(Long operationId);

    /**
     * 查询class_management列表
     * 
     * @param classManagement class_management
     * @return class_management集合
     */
    public List<ClassManagement> selectClassManagementList(ClassManagement classManagement);

    /**
     * 新增class_management
     * 
     * @param classManagement class_management
     * @return 结果
     */
    public int insertClassManagement(ClassManagement classManagement);

    /**
     * 修改class_management
     * 
     * @param classManagement class_management
     * @return 结果
     */
    public int updateClassManagement(ClassManagement classManagement);

    /**
     * 批量删除class_management
     * 
     * @param operationIds 需要删除的class_management主键集合
     * @return 结果
     */
    public int deleteClassManagementByOperationIds(Long[] operationIds);

    /**
     * 删除class_management信息
     * 
     * @param operationId class_management主键
     * @return 结果
     */
    public int deleteClassManagementByOperationId(Long operationId);
}
