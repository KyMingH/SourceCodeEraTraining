package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.EducationTransferRecordsMapper;
import com.ruoyi.system.domain.EducationTransferRecords;
import com.ruoyi.system.service.IEducationTransferRecordsService;

/**
 * 记录转班记录Service业务层处理
 * 
 * @author ttMingKy
 * @date 2024-06-21
 */
@Service
public class EducationTransferRecordsServiceImpl implements IEducationTransferRecordsService 
{
    @Autowired
    private EducationTransferRecordsMapper educationTransferRecordsMapper;

    /**
     * 查询记录转班记录
     * 
     * @param id 记录转班记录主键
     * @return 记录转班记录
     */
    @Override
    public EducationTransferRecords selectEducationTransferRecordsById(Long id)
    {
        return educationTransferRecordsMapper.selectEducationTransferRecordsById(id);
    }

    /**
     * 查询记录转班记录列表
     * 
     * @param educationTransferRecords 记录转班记录
     * @return 记录转班记录
     */
    @Override
    public List<EducationTransferRecords> selectEducationTransferRecordsList(EducationTransferRecords educationTransferRecords)
    {
        return educationTransferRecordsMapper.selectEducationTransferRecordsList(educationTransferRecords);
    }

    /**
     * 新增记录转班记录
     * 
     * @param educationTransferRecords 记录转班记录
     * @return 结果
     */
    @Override
    public int insertEducationTransferRecords(EducationTransferRecords educationTransferRecords)
    {
        educationTransferRecords.setCreateTime(DateUtils.getNowDate());
        return educationTransferRecordsMapper.insertEducationTransferRecords(educationTransferRecords);
    }

    /**
     * 修改记录转班记录
     * 
     * @param educationTransferRecords 记录转班记录
     * @return 结果
     */
    @Override
    public int updateEducationTransferRecords(EducationTransferRecords educationTransferRecords)
    {
        educationTransferRecords.setUpdateTime(DateUtils.getNowDate());
        return educationTransferRecordsMapper.updateEducationTransferRecords(educationTransferRecords);
    }

    /**
     * 批量删除记录转班记录
     * 
     * @param ids 需要删除的记录转班记录主键
     * @return 结果
     */
    @Override
    public int deleteEducationTransferRecordsByIds(Long[] ids)
    {
        return educationTransferRecordsMapper.deleteEducationTransferRecordsByIds(ids);
    }

    /**
     * 删除记录转班记录信息
     * 
     * @param id 记录转班记录主键
     * @return 结果
     */
    @Override
    public int deleteEducationTransferRecordsById(Long id)
    {
        return educationTransferRecordsMapper.deleteEducationTransferRecordsById(id);
    }
}
