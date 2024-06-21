package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Studentcommlog;

/**
 * 沟通记录Service接口
 * 
 * @author ttmingKy
 * @date 2024-06-20
 */
public interface IStudentcommlogService 
{
    /**
     * 查询沟通记录
     * 
     * @param id 沟通记录主键
     * @return 沟通记录
     */
    public Studentcommlog selectStudentcommlogById(Long id);

    /**
     * 查询沟通记录列表
     * 
     * @param studentcommlog 沟通记录
     * @return 沟通记录集合
     */
    public List<Studentcommlog> selectStudentcommlogList(Studentcommlog studentcommlog);

    /**
     * 新增沟通记录
     * 
     * @param studentcommlog 沟通记录
     * @return 结果
     */
    public int insertStudentcommlog(Studentcommlog studentcommlog);

    /**
     * 修改沟通记录
     * 
     * @param studentcommlog 沟通记录
     * @return 结果
     */
    public int updateStudentcommlog(Studentcommlog studentcommlog);

    /**
     * 批量删除沟通记录
     * 
     * @param ids 需要删除的沟通记录主键集合
     * @return 结果
     */
    public int deleteStudentcommlogByIds(Long[] ids);

    /**
     * 删除沟通记录信息
     * 
     * @param id 沟通记录主键
     * @return 结果
     */
    public int deleteStudentcommlogById(Long id);
}
