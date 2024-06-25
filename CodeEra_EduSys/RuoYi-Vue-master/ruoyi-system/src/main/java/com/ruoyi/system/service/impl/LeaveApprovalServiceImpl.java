package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.LeaveApprovalMapper;
import com.ruoyi.system.domain.LeaveApproval;
import com.ruoyi.system.service.ILeaveApprovalService;

/**
 * LeaveApprovalService业务层处理
 * 
 * @author ttKymingH
 * @date 2024-06-25
 */
@Service
public class LeaveApprovalServiceImpl implements ILeaveApprovalService 
{
    @Autowired
    private LeaveApprovalMapper leaveApprovalMapper;

    /**
     * 查询LeaveApproval
     * 
     * @param approvalId LeaveApproval主键
     * @return LeaveApproval
     */
    @Override
    public LeaveApproval selectLeaveApprovalByApprovalId(Long approvalId)
    {
        return leaveApprovalMapper.selectLeaveApprovalByApprovalId(approvalId);
    }

    /**
     * 查询LeaveApproval列表
     * 
     * @param leaveApproval LeaveApproval
     * @return LeaveApproval
     */
    @Override
    public List<LeaveApproval> selectLeaveApprovalList(LeaveApproval leaveApproval)
    {
        return leaveApprovalMapper.selectLeaveApprovalList(leaveApproval);
    }

    /**
     * 新增LeaveApproval
     * 
     * @param leaveApproval LeaveApproval
     * @return 结果
     */
    @Override
    public int insertLeaveApproval(LeaveApproval leaveApproval)
    {
        leaveApproval.setCreateTime(DateUtils.getNowDate());
        return leaveApprovalMapper.insertLeaveApproval(leaveApproval);
    }

    /**
     * 修改LeaveApproval
     * 
     * @param leaveApproval LeaveApproval
     * @return 结果
     */
    @Override
    public int updateLeaveApproval(LeaveApproval leaveApproval)
    {
        leaveApproval.setUpdateTime(DateUtils.getNowDate());
        return leaveApprovalMapper.updateLeaveApproval(leaveApproval);
    }

    /**
     * 批量删除LeaveApproval
     * 
     * @param approvalIds 需要删除的LeaveApproval主键
     * @return 结果
     */
    @Override
    public int deleteLeaveApprovalByApprovalIds(Long[] approvalIds)
    {
        return leaveApprovalMapper.deleteLeaveApprovalByApprovalIds(approvalIds);
    }

    /**
     * 删除LeaveApproval信息
     * 
     * @param approvalId LeaveApproval主键
     * @return 结果
     */
    @Override
    public int deleteLeaveApprovalByApprovalId(Long approvalId)
    {
        return leaveApprovalMapper.deleteLeaveApprovalByApprovalId(approvalId);
    }
}
