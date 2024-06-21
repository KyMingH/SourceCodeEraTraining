package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StudentcommlogMapper;
import com.ruoyi.system.domain.Studentcommlog;
import com.ruoyi.system.service.IStudentcommlogService;

/**
 * 沟通记录Service业务层处理
 * 
 * @author ttmingKy
 * @date 2024-06-20
 */
@Service
public class StudentcommlogServiceImpl implements IStudentcommlogService 
{
    @Autowired
    private StudentcommlogMapper studentcommlogMapper;

    /**
     * 查询沟通记录
     * 
     * @param id 沟通记录主键
     * @return 沟通记录
     */
    @Override
    public Studentcommlog selectStudentcommlogById(Long id)
    {
        return studentcommlogMapper.selectStudentcommlogById(id);
    }

    /**
     * 查询沟通记录列表
     * 
     * @param studentcommlog 沟通记录
     * @return 沟通记录
     */
    @Override
    public List<Studentcommlog> selectStudentcommlogList(Studentcommlog studentcommlog)
    {
        return studentcommlogMapper.selectStudentcommlogList(studentcommlog);
    }

    /**
     * 新增沟通记录
     * 
     * @param studentcommlog 沟通记录
     * @return 结果
     */
    @Override
    public int insertStudentcommlog(Studentcommlog studentcommlog)
    {
        studentcommlog.setCreateTime(DateUtils.getNowDate());
        return studentcommlogMapper.insertStudentcommlog(studentcommlog);
    }

    /**
     * 修改沟通记录
     * 
     * @param studentcommlog 沟通记录
     * @return 结果
     */
    @Override
    public int updateStudentcommlog(Studentcommlog studentcommlog)
    {
        studentcommlog.setUpdateTime(DateUtils.getNowDate());
        return studentcommlogMapper.updateStudentcommlog(studentcommlog);
    }

    /**
     * 批量删除沟通记录
     * 
     * @param ids 需要删除的沟通记录主键
     * @return 结果
     */
    @Override
    public int deleteStudentcommlogByIds(Long[] ids)
    {
        return studentcommlogMapper.deleteStudentcommlogByIds(ids);
    }

    /**
     * 删除沟通记录信息
     * 
     * @param id 沟通记录主键
     * @return 结果
     */
    @Override
    public int deleteStudentcommlogById(Long id)
    {
        return studentcommlogMapper.deleteStudentcommlogById(id);
    }
}
