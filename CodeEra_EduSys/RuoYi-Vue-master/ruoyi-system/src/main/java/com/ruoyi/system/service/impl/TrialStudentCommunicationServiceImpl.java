package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TrialStudentCommunicationMapper;
import com.ruoyi.system.domain.TrialStudentCommunication;
import com.ruoyi.system.service.ITrialStudentCommunicationService;

/**
 * TrialStudentCommunicationService业务层处理
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
@Service
public class TrialStudentCommunicationServiceImpl implements ITrialStudentCommunicationService 
{
    @Autowired
    private TrialStudentCommunicationMapper trialStudentCommunicationMapper;

    /**
     * 查询TrialStudentCommunication
     * 
     * @param communicationId TrialStudentCommunication主键
     * @return TrialStudentCommunication
     */
    @Override
    public TrialStudentCommunication selectTrialStudentCommunicationByCommunicationId(Long communicationId)
    {
        return trialStudentCommunicationMapper.selectTrialStudentCommunicationByCommunicationId(communicationId);
    }

    /**
     * 查询TrialStudentCommunication列表
     * 
     * @param trialStudentCommunication TrialStudentCommunication
     * @return TrialStudentCommunication
     */
    @Override
    public List<TrialStudentCommunication> selectTrialStudentCommunicationList(TrialStudentCommunication trialStudentCommunication)
    {
        return trialStudentCommunicationMapper.selectTrialStudentCommunicationList(trialStudentCommunication);
    }

    /**
     * 新增TrialStudentCommunication
     * 
     * @param trialStudentCommunication TrialStudentCommunication
     * @return 结果
     */
    @Override
    public int insertTrialStudentCommunication(TrialStudentCommunication trialStudentCommunication)
    {
        trialStudentCommunication.setCreateTime(DateUtils.getNowDate());
        return trialStudentCommunicationMapper.insertTrialStudentCommunication(trialStudentCommunication);
    }

    /**
     * 修改TrialStudentCommunication
     * 
     * @param trialStudentCommunication TrialStudentCommunication
     * @return 结果
     */
    @Override
    public int updateTrialStudentCommunication(TrialStudentCommunication trialStudentCommunication)
    {
        trialStudentCommunication.setUpdateTime(DateUtils.getNowDate());
        return trialStudentCommunicationMapper.updateTrialStudentCommunication(trialStudentCommunication);
    }

    /**
     * 批量删除TrialStudentCommunication
     * 
     * @param communicationIds 需要删除的TrialStudentCommunication主键
     * @return 结果
     */
    @Override
    public int deleteTrialStudentCommunicationByCommunicationIds(Long[] communicationIds)
    {
        return trialStudentCommunicationMapper.deleteTrialStudentCommunicationByCommunicationIds(communicationIds);
    }

    /**
     * 删除TrialStudentCommunication信息
     * 
     * @param communicationId TrialStudentCommunication主键
     * @return 结果
     */
    @Override
    public int deleteTrialStudentCommunicationByCommunicationId(Long communicationId)
    {
        return trialStudentCommunicationMapper.deleteTrialStudentCommunicationByCommunicationId(communicationId);
    }
}
