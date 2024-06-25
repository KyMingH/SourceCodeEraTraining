package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StudentApplicationMapper;
import com.ruoyi.system.domain.StudentApplication;
import com.ruoyi.system.service.IStudentApplicationService;

/**
 * student_applicationService业务层处理
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
@Service
public class StudentApplicationServiceImpl implements IStudentApplicationService 
{
    @Autowired
    private StudentApplicationMapper studentApplicationMapper;

    /**
     * 查询student_application
     * 
     * @param applicationId student_application主键
     * @return student_application
     */
    @Override
    public StudentApplication selectStudentApplicationByApplicationId(Long applicationId)
    {
        return studentApplicationMapper.selectStudentApplicationByApplicationId(applicationId);
    }

    /**
     * 查询student_application列表
     * 
     * @param studentApplication student_application
     * @return student_application
     */
    @Override
    public List<StudentApplication> selectStudentApplicationList(StudentApplication studentApplication)
    {
        return studentApplicationMapper.selectStudentApplicationList(studentApplication);
    }

    /**
     * 新增student_application
     * 
     * @param studentApplication student_application
     * @return 结果
     */
    @Override
    public int insertStudentApplication(StudentApplication studentApplication)
    {
        studentApplication.setCreateTime(DateUtils.getNowDate());
        return studentApplicationMapper.insertStudentApplication(studentApplication);
    }

    /**
     * 修改student_application
     * 
     * @param studentApplication student_application
     * @return 结果
     */
    @Override
    public int updateStudentApplication(StudentApplication studentApplication)
    {
        studentApplication.setUpdateTime(DateUtils.getNowDate());
        return studentApplicationMapper.updateStudentApplication(studentApplication);
    }

    /**
     * 批量删除student_application
     * 
     * @param applicationIds 需要删除的student_application主键
     * @return 结果
     */
    @Override
    public int deleteStudentApplicationByApplicationIds(Long[] applicationIds)
    {
        return studentApplicationMapper.deleteStudentApplicationByApplicationIds(applicationIds);
    }

    /**
     * 删除student_application信息
     * 
     * @param applicationId student_application主键
     * @return 结果
     */
    @Override
    public int deleteStudentApplicationByApplicationId(Long applicationId)
    {
        return studentApplicationMapper.deleteStudentApplicationByApplicationId(applicationId);
    }
}
