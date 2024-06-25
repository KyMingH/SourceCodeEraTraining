package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.StudentApplication;

/**
 * student_applicationMapper接口
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
public interface StudentApplicationMapper 
{
    /**
     * 查询student_application
     * 
     * @param applicationId student_application主键
     * @return student_application
     */
    public StudentApplication selectStudentApplicationByApplicationId(Long applicationId);

    /**
     * 查询student_application列表
     * 
     * @param studentApplication student_application
     * @return student_application集合
     */
    public List<StudentApplication> selectStudentApplicationList(StudentApplication studentApplication);

    /**
     * 新增student_application
     * 
     * @param studentApplication student_application
     * @return 结果
     */
    public int insertStudentApplication(StudentApplication studentApplication);

    /**
     * 修改student_application
     * 
     * @param studentApplication student_application
     * @return 结果
     */
    public int updateStudentApplication(StudentApplication studentApplication);

    /**
     * 删除student_application
     * 
     * @param applicationId student_application主键
     * @return 结果
     */
    public int deleteStudentApplicationByApplicationId(Long applicationId);

    /**
     * 批量删除student_application
     * 
     * @param applicationIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStudentApplicationByApplicationIds(Long[] applicationIds);
}
