package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ClassMeetings;

/**
 * ClassMeetingsMapper接口
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
public interface ClassMeetingsMapper 
{
    /**
     * 查询ClassMeetings
     * 
     * @param meetingId ClassMeetings主键
     * @return ClassMeetings
     */
    public ClassMeetings selectClassMeetingsByMeetingId(Long meetingId);

    /**
     * 查询ClassMeetings列表
     * 
     * @param classMeetings ClassMeetings
     * @return ClassMeetings集合
     */
    public List<ClassMeetings> selectClassMeetingsList(ClassMeetings classMeetings);

    /**
     * 新增ClassMeetings
     * 
     * @param classMeetings ClassMeetings
     * @return 结果
     */
    public int insertClassMeetings(ClassMeetings classMeetings);

    /**
     * 修改ClassMeetings
     * 
     * @param classMeetings ClassMeetings
     * @return 结果
     */
    public int updateClassMeetings(ClassMeetings classMeetings);

    /**
     * 删除ClassMeetings
     * 
     * @param meetingId ClassMeetings主键
     * @return 结果
     */
    public int deleteClassMeetingsByMeetingId(Long meetingId);

    /**
     * 批量删除ClassMeetings
     * 
     * @param meetingIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteClassMeetingsByMeetingIds(Long[] meetingIds);
}
