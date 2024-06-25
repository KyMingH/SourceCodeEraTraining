package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.LeaveApproval;

/**
 * LeaveApprovalService接口
 * 
 * @author ttKymingH
 * @date 2024-06-25
 */
public interface ILeaveApprovalService 
{
    /**
     * 查询LeaveApproval
     * 
     * @param approvalId LeaveApproval主键
     * @return LeaveApproval
     */
    public LeaveApproval selectLeaveApprovalByApprovalId(Long approvalId);

    /**
     * 查询LeaveApproval列表
     * 
     * @param leaveApproval LeaveApproval
     * @return LeaveApproval集合
     */
    public List<LeaveApproval> selectLeaveApprovalList(LeaveApproval leaveApproval);

    /**
     * 新增LeaveApproval
     * 
     * @param leaveApproval LeaveApproval
     * @return 结果
     */
    public int insertLeaveApproval(LeaveApproval leaveApproval);

    /**
     * 修改LeaveApproval
     * 
     * @param leaveApproval LeaveApproval
     * @return 结果
     */
    public int updateLeaveApproval(LeaveApproval leaveApproval);

    /**
     * 批量删除LeaveApproval
     * 
     * @param approvalIds 需要删除的LeaveApproval主键集合
     * @return 结果
     */
    public int deleteLeaveApprovalByApprovalIds(Long[] approvalIds);

    /**
     * 删除LeaveApproval信息
     * 
     * @param approvalId LeaveApproval主键
     * @return 结果
     */
    public int deleteLeaveApprovalByApprovalId(Long approvalId);
}
