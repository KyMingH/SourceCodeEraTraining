package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ClassMeetingsMapper;
import com.ruoyi.system.domain.ClassMeetings;
import com.ruoyi.system.service.IClassMeetingsService;

/**
 * ClassMeetingsService业务层处理
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
@Service
public class ClassMeetingsServiceImpl implements IClassMeetingsService 
{
    @Autowired
    private ClassMeetingsMapper classMeetingsMapper;

    /**
     * 查询ClassMeetings
     * 
     * @param meetingId ClassMeetings主键
     * @return ClassMeetings
     */
    @Override
    public ClassMeetings selectClassMeetingsByMeetingId(Long meetingId)
    {
        return classMeetingsMapper.selectClassMeetingsByMeetingId(meetingId);
    }

    /**
     * 查询ClassMeetings列表
     * 
     * @param classMeetings ClassMeetings
     * @return ClassMeetings
     */
    @Override
    public List<ClassMeetings> selectClassMeetingsList(ClassMeetings classMeetings)
    {
        return classMeetingsMapper.selectClassMeetingsList(classMeetings);
    }

    /**
     * 新增ClassMeetings
     * 
     * @param classMeetings ClassMeetings
     * @return 结果
     */
    @Override
    public int insertClassMeetings(ClassMeetings classMeetings)
    {
        classMeetings.setCreateTime(DateUtils.getNowDate());
        return classMeetingsMapper.insertClassMeetings(classMeetings);
    }

    /**
     * 修改ClassMeetings
     * 
     * @param classMeetings ClassMeetings
     * @return 结果
     */
    @Override
    public int updateClassMeetings(ClassMeetings classMeetings)
    {
        classMeetings.setUpdateTime(DateUtils.getNowDate());
        return classMeetingsMapper.updateClassMeetings(classMeetings);
    }

    /**
     * 批量删除ClassMeetings
     * 
     * @param meetingIds 需要删除的ClassMeetings主键
     * @return 结果
     */
    @Override
    public int deleteClassMeetingsByMeetingIds(Long[] meetingIds)
    {
        return classMeetingsMapper.deleteClassMeetingsByMeetingIds(meetingIds);
    }

    /**
     * 删除ClassMeetings信息
     * 
     * @param meetingId ClassMeetings主键
     * @return 结果
     */
    @Override
    public int deleteClassMeetingsByMeetingId(Long meetingId)
    {
        return classMeetingsMapper.deleteClassMeetingsByMeetingId(meetingId);
    }
}
