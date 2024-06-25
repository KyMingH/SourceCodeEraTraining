package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TrialStudentCommunication;

/**
 * TrialStudentCommunicationService接口
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
public interface ITrialStudentCommunicationService 
{
    /**
     * 查询TrialStudentCommunication
     * 
     * @param communicationId TrialStudentCommunication主键
     * @return TrialStudentCommunication
     */
    public TrialStudentCommunication selectTrialStudentCommunicationByCommunicationId(Long communicationId);

    /**
     * 查询TrialStudentCommunication列表
     * 
     * @param trialStudentCommunication TrialStudentCommunication
     * @return TrialStudentCommunication集合
     */
    public List<TrialStudentCommunication> selectTrialStudentCommunicationList(TrialStudentCommunication trialStudentCommunication);

    /**
     * 新增TrialStudentCommunication
     * 
     * @param trialStudentCommunication TrialStudentCommunication
     * @return 结果
     */
    public int insertTrialStudentCommunication(TrialStudentCommunication trialStudentCommunication);

    /**
     * 修改TrialStudentCommunication
     * 
     * @param trialStudentCommunication TrialStudentCommunication
     * @return 结果
     */
    public int updateTrialStudentCommunication(TrialStudentCommunication trialStudentCommunication);

    /**
     * 批量删除TrialStudentCommunication
     * 
     * @param communicationIds 需要删除的TrialStudentCommunication主键集合
     * @return 结果
     */
    public int deleteTrialStudentCommunicationByCommunicationIds(Long[] communicationIds);

    /**
     * 删除TrialStudentCommunication信息
     * 
     * @param communicationId TrialStudentCommunication主键
     * @return 结果
     */
    public int deleteTrialStudentCommunicationByCommunicationId(Long communicationId);
}
