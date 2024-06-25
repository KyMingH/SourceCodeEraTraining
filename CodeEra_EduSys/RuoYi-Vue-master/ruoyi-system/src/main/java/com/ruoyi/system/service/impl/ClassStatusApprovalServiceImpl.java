package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ClassStatusApprovalMapper;
import com.ruoyi.system.domain.ClassStatusApproval;
import com.ruoyi.system.service.IClassStatusApprovalService;

/**
 * ClassStatusApprovalService业务层处理
 * 
 * @author ttKymingH
 * @date 2024-06-25
 */
@Service
public class ClassStatusApprovalServiceImpl implements IClassStatusApprovalService 
{
    @Autowired
    private ClassStatusApprovalMapper classStatusApprovalMapper;

    /**
     * 查询ClassStatusApproval
     * 
     * @param approvalId ClassStatusApproval主键
     * @return ClassStatusApproval
     */
    @Override
    public ClassStatusApproval selectClassStatusApprovalByApprovalId(Long approvalId)
    {
        return classStatusApprovalMapper.selectClassStatusApprovalByApprovalId(approvalId);
    }

    /**
     * 查询ClassStatusApproval列表
     * 
     * @param classStatusApproval ClassStatusApproval
     * @return ClassStatusApproval
     */
    @Override
    public List<ClassStatusApproval> selectClassStatusApprovalList(ClassStatusApproval classStatusApproval)
    {
        return classStatusApprovalMapper.selectClassStatusApprovalList(classStatusApproval);
    }

    /**
     * 新增ClassStatusApproval
     * 
     * @param classStatusApproval ClassStatusApproval
     * @return 结果
     */
    @Override
    public int insertClassStatusApproval(ClassStatusApproval classStatusApproval)
    {
        classStatusApproval.setCreateTime(DateUtils.getNowDate());
        return classStatusApprovalMapper.insertClassStatusApproval(classStatusApproval);
    }

    /**
     * 修改ClassStatusApproval
     * 
     * @param classStatusApproval ClassStatusApproval
     * @return 结果
     */
    @Override
    public int updateClassStatusApproval(ClassStatusApproval classStatusApproval)
    {
        classStatusApproval.setUpdateTime(DateUtils.getNowDate());
        return classStatusApprovalMapper.updateClassStatusApproval(classStatusApproval);
    }

    /**
     * 批量删除ClassStatusApproval
     * 
     * @param approvalIds 需要删除的ClassStatusApproval主键
     * @return 结果
     */
    @Override
    public int deleteClassStatusApprovalByApprovalIds(Long[] approvalIds)
    {
        return classStatusApprovalMapper.deleteClassStatusApprovalByApprovalIds(approvalIds);
    }

    /**
     * 删除ClassStatusApproval信息
     * 
     * @param approvalId ClassStatusApproval主键
     * @return 结果
     */
    @Override
    public int deleteClassStatusApprovalByApprovalId(Long approvalId)
    {
        return classStatusApprovalMapper.deleteClassStatusApprovalByApprovalId(approvalId);
    }
}
