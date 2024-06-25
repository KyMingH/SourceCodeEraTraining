package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StudentProcessApprovalMapper;
import com.ruoyi.system.domain.StudentProcessApproval;
import com.ruoyi.system.service.IStudentProcessApprovalService;

/**
 * StudentProcessApprovalService业务层处理
 * 
 * @author ttKymingH
 * @date 2024-06-25
 */
@Service
public class StudentProcessApprovalServiceImpl implements IStudentProcessApprovalService 
{
    @Autowired
    private StudentProcessApprovalMapper studentProcessApprovalMapper;

    /**
     * 查询StudentProcessApproval
     * 
     * @param approvalId StudentProcessApproval主键
     * @return StudentProcessApproval
     */
    @Override
    public StudentProcessApproval selectStudentProcessApprovalByApprovalId(Long approvalId)
    {
        return studentProcessApprovalMapper.selectStudentProcessApprovalByApprovalId(approvalId);
    }

    /**
     * 查询StudentProcessApproval列表
     * 
     * @param studentProcessApproval StudentProcessApproval
     * @return StudentProcessApproval
     */
    @Override
    public List<StudentProcessApproval> selectStudentProcessApprovalList(StudentProcessApproval studentProcessApproval)
    {
        return studentProcessApprovalMapper.selectStudentProcessApprovalList(studentProcessApproval);
    }

    /**
     * 新增StudentProcessApproval
     * 
     * @param studentProcessApproval StudentProcessApproval
     * @return 结果
     */
    @Override
    public int insertStudentProcessApproval(StudentProcessApproval studentProcessApproval)
    {
        studentProcessApproval.setCreateTime(DateUtils.getNowDate());
        return studentProcessApprovalMapper.insertStudentProcessApproval(studentProcessApproval);
    }

    /**
     * 修改StudentProcessApproval
     * 
     * @param studentProcessApproval StudentProcessApproval
     * @return 结果
     */
    @Override
    public int updateStudentProcessApproval(StudentProcessApproval studentProcessApproval)
    {
        studentProcessApproval.setUpdateTime(DateUtils.getNowDate());
        return studentProcessApprovalMapper.updateStudentProcessApproval(studentProcessApproval);
    }

    /**
     * 批量删除StudentProcessApproval
     * 
     * @param approvalIds 需要删除的StudentProcessApproval主键
     * @return 结果
     */
    @Override
    public int deleteStudentProcessApprovalByApprovalIds(Long[] approvalIds)
    {
        return studentProcessApprovalMapper.deleteStudentProcessApprovalByApprovalIds(approvalIds);
    }

    /**
     * 删除StudentProcessApproval信息
     * 
     * @param approvalId StudentProcessApproval主键
     * @return 结果
     */
    @Override
    public int deleteStudentProcessApprovalByApprovalId(Long approvalId)
    {
        return studentProcessApprovalMapper.deleteStudentProcessApprovalByApprovalId(approvalId);
    }
}
