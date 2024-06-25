package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.StudentRegularApproval;

/**
 * StudentRegularApprovalService接口
 * 
 * @author ttKymingH
 * @date 2024-06-25
 */
public interface IStudentRegularApprovalService 
{
    /**
     * 查询StudentRegularApproval
     * 
     * @param approvalId StudentRegularApproval主键
     * @return StudentRegularApproval
     */
    public StudentRegularApproval selectStudentRegularApprovalByApprovalId(Long approvalId);

    /**
     * 查询StudentRegularApproval列表
     * 
     * @param studentRegularApproval StudentRegularApproval
     * @return StudentRegularApproval集合
     */
    public List<StudentRegularApproval> selectStudentRegularApprovalList(StudentRegularApproval studentRegularApproval);

    /**
     * 新增StudentRegularApproval
     * 
     * @param studentRegularApproval StudentRegularApproval
     * @return 结果
     */
    public int insertStudentRegularApproval(StudentRegularApproval studentRegularApproval);

    /**
     * 修改StudentRegularApproval
     * 
     * @param studentRegularApproval StudentRegularApproval
     * @return 结果
     */
    public int updateStudentRegularApproval(StudentRegularApproval studentRegularApproval);

    /**
     * 批量删除StudentRegularApproval
     * 
     * @param approvalIds 需要删除的StudentRegularApproval主键集合
     * @return 结果
     */
    public int deleteStudentRegularApprovalByApprovalIds(Long[] approvalIds);

    /**
     * 删除StudentRegularApproval信息
     * 
     * @param approvalId StudentRegularApproval主键
     * @return 结果
     */
    public int deleteStudentRegularApprovalByApprovalId(Long approvalId);
}
