package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.AlumniFollowUp;

/**
 * alumni_follow_upMapper接口
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
public interface AlumniFollowUpMapper 
{
    /**
     * 查询alumni_follow_up
     * 
     * @param followUpId alumni_follow_up主键
     * @return alumni_follow_up
     */
    public AlumniFollowUp selectAlumniFollowUpByFollowUpId(Long followUpId);

    /**
     * 查询alumni_follow_up列表
     * 
     * @param alumniFollowUp alumni_follow_up
     * @return alumni_follow_up集合
     */
    public List<AlumniFollowUp> selectAlumniFollowUpList(AlumniFollowUp alumniFollowUp);

    /**
     * 新增alumni_follow_up
     * 
     * @param alumniFollowUp alumni_follow_up
     * @return 结果
     */
    public int insertAlumniFollowUp(AlumniFollowUp alumniFollowUp);

    /**
     * 修改alumni_follow_up
     * 
     * @param alumniFollowUp alumni_follow_up
     * @return 结果
     */
    public int updateAlumniFollowUp(AlumniFollowUp alumniFollowUp);

    /**
     * 删除alumni_follow_up
     * 
     * @param followUpId alumni_follow_up主键
     * @return 结果
     */
    public int deleteAlumniFollowUpByFollowUpId(Long followUpId);

    /**
     * 批量删除alumni_follow_up
     * 
     * @param followUpIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAlumniFollowUpByFollowUpIds(Long[] followUpIds);
}
