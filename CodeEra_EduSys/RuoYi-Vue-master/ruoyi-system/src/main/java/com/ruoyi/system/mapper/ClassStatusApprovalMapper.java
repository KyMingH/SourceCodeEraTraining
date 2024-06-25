package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ClassStatusApproval;

/**
 * ClassStatusApprovalMapper接口
 * 
 * @author ttKymingH
 * @date 2024-06-25
 */
public interface ClassStatusApprovalMapper 
{
    /**
     * 查询ClassStatusApproval
     * 
     * @param approvalId ClassStatusApproval主键
     * @return ClassStatusApproval
     */
    public ClassStatusApproval selectClassStatusApprovalByApprovalId(Long approvalId);

    /**
     * 查询ClassStatusApproval列表
     * 
     * @param classStatusApproval ClassStatusApproval
     * @return ClassStatusApproval集合
     */
    public List<ClassStatusApproval> selectClassStatusApprovalList(ClassStatusApproval classStatusApproval);

    /**
     * 新增ClassStatusApproval
     * 
     * @param classStatusApproval ClassStatusApproval
     * @return 结果
     */
    public int insertClassStatusApproval(ClassStatusApproval classStatusApproval);

    /**
     * 修改ClassStatusApproval
     * 
     * @param classStatusApproval ClassStatusApproval
     * @return 结果
     */
    public int updateClassStatusApproval(ClassStatusApproval classStatusApproval);

    /**
     * 删除ClassStatusApproval
     * 
     * @param approvalId ClassStatusApproval主键
     * @return 结果
     */
    public int deleteClassStatusApprovalByApprovalId(Long approvalId);

    /**
     * 批量删除ClassStatusApproval
     * 
     * @param approvalIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteClassStatusApprovalByApprovalIds(Long[] approvalIds);
}
