package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StudentConductMapper;
import com.ruoyi.system.domain.StudentConduct;
import com.ruoyi.system.service.IStudentConductService;

/**
 * student_conductService业务层处理
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
@Service
public class StudentConductServiceImpl implements IStudentConductService 
{
    @Autowired
    private StudentConductMapper studentConductMapper;

    /**
     * 查询student_conduct
     * 
     * @param conductId student_conduct主键
     * @return student_conduct
     */
    @Override
    public StudentConduct selectStudentConductByConductId(Long conductId)
    {
        return studentConductMapper.selectStudentConductByConductId(conductId);
    }

    /**
     * 查询student_conduct列表
     * 
     * @param studentConduct student_conduct
     * @return student_conduct
     */
    @Override
    public List<StudentConduct> selectStudentConductList(StudentConduct studentConduct)
    {
        return studentConductMapper.selectStudentConductList(studentConduct);
    }

    /**
     * 新增student_conduct
     * 
     * @param studentConduct student_conduct
     * @return 结果
     */
    @Override
    public int insertStudentConduct(StudentConduct studentConduct)
    {
        studentConduct.setCreateTime(DateUtils.getNowDate());
        return studentConductMapper.insertStudentConduct(studentConduct);
    }

    /**
     * 修改student_conduct
     * 
     * @param studentConduct student_conduct
     * @return 结果
     */
    @Override
    public int updateStudentConduct(StudentConduct studentConduct)
    {
        studentConduct.setUpdateTime(DateUtils.getNowDate());
        return studentConductMapper.updateStudentConduct(studentConduct);
    }

    /**
     * 批量删除student_conduct
     * 
     * @param conductIds 需要删除的student_conduct主键
     * @return 结果
     */
    @Override
    public int deleteStudentConductByConductIds(Long[] conductIds)
    {
        return studentConductMapper.deleteStudentConductByConductIds(conductIds);
    }

    /**
     * 删除student_conduct信息
     * 
     * @param conductId student_conduct主键
     * @return 结果
     */
    @Override
    public int deleteStudentConductByConductId(Long conductId)
    {
        return studentConductMapper.deleteStudentConductByConductId(conductId);
    }
}
