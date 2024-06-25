package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ProblemStudent;

/**
 * problem_studentMapper接口
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
public interface ProblemStudentMapper 
{
    /**
     * 查询problem_student
     * 
     * @param recordId problem_student主键
     * @return problem_student
     */
    public ProblemStudent selectProblemStudentByRecordId(Long recordId);

    /**
     * 查询problem_student列表
     * 
     * @param problemStudent problem_student
     * @return problem_student集合
     */
    public List<ProblemStudent> selectProblemStudentList(ProblemStudent problemStudent);

    /**
     * 新增problem_student
     * 
     * @param problemStudent problem_student
     * @return 结果
     */
    public int insertProblemStudent(ProblemStudent problemStudent);

    /**
     * 修改problem_student
     * 
     * @param problemStudent problem_student
     * @return 结果
     */
    public int updateProblemStudent(ProblemStudent problemStudent);

    /**
     * 删除problem_student
     * 
     * @param recordId problem_student主键
     * @return 结果
     */
    public int deleteProblemStudentByRecordId(Long recordId);

    /**
     * 批量删除problem_student
     * 
     * @param recordIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProblemStudentByRecordIds(Long[] recordIds);
}
