package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ProblemStudentMapper;
import com.ruoyi.system.domain.ProblemStudent;
import com.ruoyi.system.service.IProblemStudentService;

/**
 * problem_studentService业务层处理
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
@Service
public class ProblemStudentServiceImpl implements IProblemStudentService 
{
    @Autowired
    private ProblemStudentMapper problemStudentMapper;

    /**
     * 查询problem_student
     * 
     * @param recordId problem_student主键
     * @return problem_student
     */
    @Override
    public ProblemStudent selectProblemStudentByRecordId(Long recordId)
    {
        return problemStudentMapper.selectProblemStudentByRecordId(recordId);
    }

    /**
     * 查询problem_student列表
     * 
     * @param problemStudent problem_student
     * @return problem_student
     */
    @Override
    public List<ProblemStudent> selectProblemStudentList(ProblemStudent problemStudent)
    {
        return problemStudentMapper.selectProblemStudentList(problemStudent);
    }

    /**
     * 新增problem_student
     * 
     * @param problemStudent problem_student
     * @return 结果
     */
    @Override
    public int insertProblemStudent(ProblemStudent problemStudent)
    {
        problemStudent.setCreateTime(DateUtils.getNowDate());
        return problemStudentMapper.insertProblemStudent(problemStudent);
    }

    /**
     * 修改problem_student
     * 
     * @param problemStudent problem_student
     * @return 结果
     */
    @Override
    public int updateProblemStudent(ProblemStudent problemStudent)
    {
        problemStudent.setUpdateTime(DateUtils.getNowDate());
        return problemStudentMapper.updateProblemStudent(problemStudent);
    }

    /**
     * 批量删除problem_student
     * 
     * @param recordIds 需要删除的problem_student主键
     * @return 结果
     */
    @Override
    public int deleteProblemStudentByRecordIds(Long[] recordIds)
    {
        return problemStudentMapper.deleteProblemStudentByRecordIds(recordIds);
    }

    /**
     * 删除problem_student信息
     * 
     * @param recordId problem_student主键
     * @return 结果
     */
    @Override
    public int deleteProblemStudentByRecordId(Long recordId)
    {
        return problemStudentMapper.deleteProblemStudentByRecordId(recordId);
    }
}
