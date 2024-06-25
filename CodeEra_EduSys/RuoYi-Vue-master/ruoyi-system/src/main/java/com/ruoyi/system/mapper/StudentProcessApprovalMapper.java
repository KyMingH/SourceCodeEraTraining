package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.StudentProcessApproval;

/**
 * StudentProcessApprovalMapper接口
 * 
 * @author ttKymingH
 * @date 2024-06-25
 */
public interface StudentProcessApprovalMapper 
{
    /**
     * 查询StudentProcessApproval
     * 
     * @param approvalId StudentProcessApproval主键
     * @return StudentProcessApproval
     */
    public StudentProcessApproval selectStudentProcessApprovalByApprovalId(Long approvalId);

    /**
     * 查询StudentProcessApproval列表
     * 
     * @param studentProcessApproval StudentProcessApproval
     * @return StudentProcessApproval集合
     */
    public List<StudentProcessApproval> selectStudentProcessApprovalList(StudentProcessApproval studentProcessApproval);

    /**
     * 新增StudentProcessApproval
     * 
     * @param studentProcessApproval StudentProcessApproval
     * @return 结果
     */
    public int insertStudentProcessApproval(StudentProcessApproval studentProcessApproval);

    /**
     * 修改StudentProcessApproval
     * 
     * @param studentProcessApproval StudentProcessApproval
     * @return 结果
     */
    public int updateStudentProcessApproval(StudentProcessApproval studentProcessApproval);

    /**
     * 删除StudentProcessApproval
     * 
     * @param approvalId StudentProcessApproval主键
     * @return 结果
     */
    public int deleteStudentProcessApprovalByApprovalId(Long approvalId);

    /**
     * 批量删除StudentProcessApproval
     * 
     * @param approvalIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStudentProcessApprovalByApprovalIds(Long[] approvalIds);
}
