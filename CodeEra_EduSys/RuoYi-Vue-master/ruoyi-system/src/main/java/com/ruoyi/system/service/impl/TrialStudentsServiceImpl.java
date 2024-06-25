package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TrialStudentsMapper;
import com.ruoyi.system.domain.TrialStudents;
import com.ruoyi.system.service.ITrialStudentsService;

/**
 * trial_studentsService业务层处理
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
@Service
public class TrialStudentsServiceImpl implements ITrialStudentsService 
{
    @Autowired
    private TrialStudentsMapper trialStudentsMapper;

    /**
     * 查询trial_students
     * 
     * @param trialStudentId trial_students主键
     * @return trial_students
     */
    @Override
    public TrialStudents selectTrialStudentsByTrialStudentId(Long trialStudentId)
    {
        return trialStudentsMapper.selectTrialStudentsByTrialStudentId(trialStudentId);
    }

    /**
     * 查询trial_students列表
     * 
     * @param trialStudents trial_students
     * @return trial_students
     */
    @Override
    public List<TrialStudents> selectTrialStudentsList(TrialStudents trialStudents)
    {
        return trialStudentsMapper.selectTrialStudentsList(trialStudents);
    }

    /**
     * 新增trial_students
     * 
     * @param trialStudents trial_students
     * @return 结果
     */
    @Override
    public int insertTrialStudents(TrialStudents trialStudents)
    {
        trialStudents.setCreateTime(DateUtils.getNowDate());
        return trialStudentsMapper.insertTrialStudents(trialStudents);
    }

    /**
     * 修改trial_students
     * 
     * @param trialStudents trial_students
     * @return 结果
     */
    @Override
    public int updateTrialStudents(TrialStudents trialStudents)
    {
        trialStudents.setUpdateTime(DateUtils.getNowDate());
        return trialStudentsMapper.updateTrialStudents(trialStudents);
    }

    /**
     * 批量删除trial_students
     * 
     * @param trialStudentIds 需要删除的trial_students主键
     * @return 结果
     */
    @Override
    public int deleteTrialStudentsByTrialStudentIds(Long[] trialStudentIds)
    {
        return trialStudentsMapper.deleteTrialStudentsByTrialStudentIds(trialStudentIds);
    }

    /**
     * 删除trial_students信息
     * 
     * @param trialStudentId trial_students主键
     * @return 结果
     */
    @Override
    public int deleteTrialStudentsByTrialStudentId(Long trialStudentId)
    {
        return trialStudentsMapper.deleteTrialStudentsByTrialStudentId(trialStudentId);
    }
}
