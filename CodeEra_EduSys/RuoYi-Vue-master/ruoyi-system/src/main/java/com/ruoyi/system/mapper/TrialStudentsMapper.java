package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TrialStudents;

/**
 * trial_studentsMapper接口
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
public interface TrialStudentsMapper 
{
    /**
     * 查询trial_students
     * 
     * @param trialStudentId trial_students主键
     * @return trial_students
     */
    public TrialStudents selectTrialStudentsByTrialStudentId(Long trialStudentId);

    /**
     * 查询trial_students列表
     * 
     * @param trialStudents trial_students
     * @return trial_students集合
     */
    public List<TrialStudents> selectTrialStudentsList(TrialStudents trialStudents);

    /**
     * 新增trial_students
     * 
     * @param trialStudents trial_students
     * @return 结果
     */
    public int insertTrialStudents(TrialStudents trialStudents);

    /**
     * 修改trial_students
     * 
     * @param trialStudents trial_students
     * @return 结果
     */
    public int updateTrialStudents(TrialStudents trialStudents);

    /**
     * 删除trial_students
     * 
     * @param trialStudentId trial_students主键
     * @return 结果
     */
    public int deleteTrialStudentsByTrialStudentId(Long trialStudentId);

    /**
     * 批量删除trial_students
     * 
     * @param trialStudentIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTrialStudentsByTrialStudentIds(Long[] trialStudentIds);
}
