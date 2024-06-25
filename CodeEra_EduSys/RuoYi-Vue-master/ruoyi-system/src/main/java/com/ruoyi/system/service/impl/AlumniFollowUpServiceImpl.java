package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AlumniFollowUpMapper;
import com.ruoyi.system.domain.AlumniFollowUp;
import com.ruoyi.system.service.IAlumniFollowUpService;

/**
 * alumni_follow_upService业务层处理
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
@Service
public class AlumniFollowUpServiceImpl implements IAlumniFollowUpService 
{
    @Autowired
    private AlumniFollowUpMapper alumniFollowUpMapper;

    /**
     * 查询alumni_follow_up
     * 
     * @param followUpId alumni_follow_up主键
     * @return alumni_follow_up
     */
    @Override
    public AlumniFollowUp selectAlumniFollowUpByFollowUpId(Long followUpId)
    {
        return alumniFollowUpMapper.selectAlumniFollowUpByFollowUpId(followUpId);
    }

    /**
     * 查询alumni_follow_up列表
     * 
     * @param alumniFollowUp alumni_follow_up
     * @return alumni_follow_up
     */
    @Override
    public List<AlumniFollowUp> selectAlumniFollowUpList(AlumniFollowUp alumniFollowUp)
    {
        return alumniFollowUpMapper.selectAlumniFollowUpList(alumniFollowUp);
    }

    /**
     * 新增alumni_follow_up
     * 
     * @param alumniFollowUp alumni_follow_up
     * @return 结果
     */
    @Override
    public int insertAlumniFollowUp(AlumniFollowUp alumniFollowUp)
    {
        alumniFollowUp.setCreateTime(DateUtils.getNowDate());
        return alumniFollowUpMapper.insertAlumniFollowUp(alumniFollowUp);
    }

    /**
     * 修改alumni_follow_up
     * 
     * @param alumniFollowUp alumni_follow_up
     * @return 结果
     */
    @Override
    public int updateAlumniFollowUp(AlumniFollowUp alumniFollowUp)
    {
        alumniFollowUp.setUpdateTime(DateUtils.getNowDate());
        return alumniFollowUpMapper.updateAlumniFollowUp(alumniFollowUp);
    }

    /**
     * 批量删除alumni_follow_up
     * 
     * @param followUpIds 需要删除的alumni_follow_up主键
     * @return 结果
     */
    @Override
    public int deleteAlumniFollowUpByFollowUpIds(Long[] followUpIds)
    {
        return alumniFollowUpMapper.deleteAlumniFollowUpByFollowUpIds(followUpIds);
    }

    /**
     * 删除alumni_follow_up信息
     * 
     * @param followUpId alumni_follow_up主键
     * @return 结果
     */
    @Override
    public int deleteAlumniFollowUpByFollowUpId(Long followUpId)
    {
        return alumniFollowUpMapper.deleteAlumniFollowUpByFollowUpId(followUpId);
    }
}
