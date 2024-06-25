package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TrialStudentsM;

/**
 * trial_studentsMService接口
 * 
 * @author ttKymingH
 * @date 2024-06-25
 */
public interface ITrialStudentsMService 
{
    /**
     * 查询trial_studentsM
     * 
     * @param trialStudentId trial_studentsM主键
     * @return trial_studentsM
     */
    public TrialStudentsM selectTrialStudentsMByTrialStudentId(Long trialStudentId);

    /**
     * 查询trial_studentsM列表
     * 
     * @param trialStudentsM trial_studentsM
     * @return trial_studentsM集合
     */
    public List<TrialStudentsM> selectTrialStudentsMList(TrialStudentsM trialStudentsM);

    /**
     * 新增trial_studentsM
     * 
     * @param trialStudentsM trial_studentsM
     * @return 结果
     */
    public int insertTrialStudentsM(TrialStudentsM trialStudentsM);

    /**
     * 修改trial_studentsM
     * 
     * @param trialStudentsM trial_studentsM
     * @return 结果
     */
    public int updateTrialStudentsM(TrialStudentsM trialStudentsM);

    /**
     * 批量删除trial_studentsM
     * 
     * @param trialStudentIds 需要删除的trial_studentsM主键集合
     * @return 结果
     */
    public int deleteTrialStudentsMByTrialStudentIds(Long[] trialStudentIds);

    /**
     * 删除trial_studentsM信息
     * 
     * @param trialStudentId trial_studentsM主键
     * @return 结果
     */
    public int deleteTrialStudentsMByTrialStudentId(Long trialStudentId);
}
