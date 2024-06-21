package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.EducationTransferRecords;

/**
 * 记录转班记录Mapper接口
 * 
 * @author ttMingKy
 * @date 2024-06-21
 */
public interface EducationTransferRecordsMapper 
{
    /**
     * 查询记录转班记录
     * 
     * @param id 记录转班记录主键
     * @return 记录转班记录
     */
    public EducationTransferRecords selectEducationTransferRecordsById(Long id);

    /**
     * 查询记录转班记录列表
     * 
     * @param educationTransferRecords 记录转班记录
     * @return 记录转班记录集合
     */
    public List<EducationTransferRecords> selectEducationTransferRecordsList(EducationTransferRecords educationTransferRecords);

    /**
     * 新增记录转班记录
     * 
     * @param educationTransferRecords 记录转班记录
     * @return 结果
     */
    public int insertEducationTransferRecords(EducationTransferRecords educationTransferRecords);

    /**
     * 修改记录转班记录
     * 
     * @param educationTransferRecords 记录转班记录
     * @return 结果
     */
    public int updateEducationTransferRecords(EducationTransferRecords educationTransferRecords);

    /**
     * 删除记录转班记录
     * 
     * @param id 记录转班记录主键
     * @return 结果
     */
    public int deleteEducationTransferRecordsById(Long id);

    /**
     * 批量删除记录转班记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEducationTransferRecordsByIds(Long[] ids);
}
