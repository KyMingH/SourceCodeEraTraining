package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StudentIntentionMapper;
import com.ruoyi.system.domain.StudentIntention;
import com.ruoyi.system.service.IStudentIntentionService;

/**
 * student_intentionService业务层处理
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
@Service
public class StudentIntentionServiceImpl implements IStudentIntentionService 
{
    @Autowired
    private StudentIntentionMapper studentIntentionMapper;

    /**
     * 查询student_intention
     * 
     * @param recordId student_intention主键
     * @return student_intention
     */
    @Override
    public StudentIntention selectStudentIntentionByRecordId(Long recordId)
    {
        return studentIntentionMapper.selectStudentIntentionByRecordId(recordId);
    }

    /**
     * 查询student_intention列表
     * 
     * @param studentIntention student_intention
     * @return student_intention
     */
    @Override
    public List<StudentIntention> selectStudentIntentionList(StudentIntention studentIntention)
    {
        return studentIntentionMapper.selectStudentIntentionList(studentIntention);
    }

    /**
     * 新增student_intention
     * 
     * @param studentIntention student_intention
     * @return 结果
     */
    @Override
    public int insertStudentIntention(StudentIntention studentIntention)
    {
        studentIntention.setCreateTime(DateUtils.getNowDate());
        return studentIntentionMapper.insertStudentIntention(studentIntention);
    }

    /**
     * 修改student_intention
     * 
     * @param studentIntention student_intention
     * @return 结果
     */
    @Override
    public int updateStudentIntention(StudentIntention studentIntention)
    {
        studentIntention.setUpdateTime(DateUtils.getNowDate());
        return studentIntentionMapper.updateStudentIntention(studentIntention);
    }

    /**
     * 批量删除student_intention
     * 
     * @param recordIds 需要删除的student_intention主键
     * @return 结果
     */
    @Override
    public int deleteStudentIntentionByRecordIds(Long[] recordIds)
    {
        return studentIntentionMapper.deleteStudentIntentionByRecordIds(recordIds);
    }

    /**
     * 删除student_intention信息
     * 
     * @param recordId student_intention主键
     * @return 结果
     */
    @Override
    public int deleteStudentIntentionByRecordId(Long recordId)
    {
        return studentIntentionMapper.deleteStudentIntentionByRecordId(recordId);
    }
}
