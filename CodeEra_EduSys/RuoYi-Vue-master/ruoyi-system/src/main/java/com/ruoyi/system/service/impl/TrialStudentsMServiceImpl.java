package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TrialStudentsMMapper;
import com.ruoyi.system.domain.TrialStudentsM;
import com.ruoyi.system.service.ITrialStudentsMService;

/**
 * trial_studentsMService业务层处理
 * 
 * @author ttKymingH
 * @date 2024-06-25
 */
@Service
public class TrialStudentsMServiceImpl implements ITrialStudentsMService 
{
    @Autowired
    private TrialStudentsMMapper trialStudentsMMapper;

    /**
     * 查询trial_studentsM
     * 
     * @param trialStudentId trial_studentsM主键
     * @return trial_studentsM
     */
    @Override
    public TrialStudentsM selectTrialStudentsMByTrialStudentId(Long trialStudentId)
    {
        return trialStudentsMMapper.selectTrialStudentsMByTrialStudentId(trialStudentId);
    }

    /**
     * 查询trial_studentsM列表
     * 
     * @param trialStudentsM trial_studentsM
     * @return trial_studentsM
     */
    @Override
    public List<TrialStudentsM> selectTrialStudentsMList(TrialStudentsM trialStudentsM)
    {
        return trialStudentsMMapper.selectTrialStudentsMList(trialStudentsM);
    }

    /**
     * 新增trial_studentsM
     * 
     * @param trialStudentsM trial_studentsM
     * @return 结果
     */
    @Override
    public int insertTrialStudentsM(TrialStudentsM trialStudentsM)
    {
        trialStudentsM.setCreateTime(DateUtils.getNowDate());
        return trialStudentsMMapper.insertTrialStudentsM(trialStudentsM);
    }

    /**
     * 修改trial_studentsM
     * 
     * @param trialStudentsM trial_studentsM
     * @return 结果
     */
    @Override
    public int updateTrialStudentsM(TrialStudentsM trialStudentsM)
    {
        trialStudentsM.setUpdateTime(DateUtils.getNowDate());
        return trialStudentsMMapper.updateTrialStudentsM(trialStudentsM);
    }

    /**
     * 批量删除trial_studentsM
     * 
     * @param trialStudentIds 需要删除的trial_studentsM主键
     * @return 结果
     */
    @Override
    public int deleteTrialStudentsMByTrialStudentIds(Long[] trialStudentIds)
    {
        return trialStudentsMMapper.deleteTrialStudentsMByTrialStudentIds(trialStudentIds);
    }

    /**
     * 删除trial_studentsM信息
     * 
     * @param trialStudentId trial_studentsM主键
     * @return 结果
     */
    @Override
    public int deleteTrialStudentsMByTrialStudentId(Long trialStudentId)
    {
        return trialStudentsMMapper.deleteTrialStudentsMByTrialStudentId(trialStudentId);
    }
}
