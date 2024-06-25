package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StudentRegularApprovalMapper;
import com.ruoyi.system.domain.StudentRegularApproval;
import com.ruoyi.system.service.IStudentRegularApprovalService;

/**
 * StudentRegularApprovalService业务层处理
 * 
 * @author ttKymingH
 * @date 2024-06-25
 */
@Service
public class StudentRegularApprovalServiceImpl implements IStudentRegularApprovalService 
{
    @Autowired
    private StudentRegularApprovalMapper studentRegularApprovalMapper;

    /**
     * 查询StudentRegularApproval
     * 
     * @param approvalId StudentRegularApproval主键
     * @return StudentRegularApproval
     */
    @Override
    public StudentRegularApproval selectStudentRegularApprovalByApprovalId(Long approvalId)
    {
        return studentRegularApprovalMapper.selectStudentRegularApprovalByApprovalId(approvalId);
    }

    /**
     * 查询StudentRegularApproval列表
     * 
     * @param studentRegularApproval StudentRegularApproval
     * @return StudentRegularApproval
     */
    @Override
    public List<StudentRegularApproval> selectStudentRegularApprovalList(StudentRegularApproval studentRegularApproval)
    {
        return studentRegularApprovalMapper.selectStudentRegularApprovalList(studentRegularApproval);
    }

    /**
     * 新增StudentRegularApproval
     * 
     * @param studentRegularApproval StudentRegularApproval
     * @return 结果
     */
    @Override
    public int insertStudentRegularApproval(StudentRegularApproval studentRegularApproval)
    {
        studentRegularApproval.setCreateTime(DateUtils.getNowDate());
        return studentRegularApprovalMapper.insertStudentRegularApproval(studentRegularApproval);
    }

    /**
     * 修改StudentRegularApproval
     * 
     * @param studentRegularApproval StudentRegularApproval
     * @return 结果
     */
    @Override
    public int updateStudentRegularApproval(StudentRegularApproval studentRegularApproval)
    {
        studentRegularApproval.setUpdateTime(DateUtils.getNowDate());
        return studentRegularApprovalMapper.updateStudentRegularApproval(studentRegularApproval);
    }

    /**
     * 批量删除StudentRegularApproval
     * 
     * @param approvalIds 需要删除的StudentRegularApproval主键
     * @return 结果
     */
    @Override
    public int deleteStudentRegularApprovalByApprovalIds(Long[] approvalIds)
    {
        return studentRegularApprovalMapper.deleteStudentRegularApprovalByApprovalIds(approvalIds);
    }

    /**
     * 删除StudentRegularApproval信息
     * 
     * @param approvalId StudentRegularApproval主键
     * @return 结果
     */
    @Override
    public int deleteStudentRegularApprovalByApprovalId(Long approvalId)
    {
        return studentRegularApprovalMapper.deleteStudentRegularApprovalByApprovalId(approvalId);
    }
}
