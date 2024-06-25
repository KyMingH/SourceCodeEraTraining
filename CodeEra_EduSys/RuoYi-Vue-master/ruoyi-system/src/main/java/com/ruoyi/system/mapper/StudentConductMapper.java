package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.StudentConduct;

/**
 * student_conductMapper接口
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
public interface StudentConductMapper 
{
    /**
     * 查询student_conduct
     * 
     * @param conductId student_conduct主键
     * @return student_conduct
     */
    public StudentConduct selectStudentConductByConductId(Long conductId);

    /**
     * 查询student_conduct列表
     * 
     * @param studentConduct student_conduct
     * @return student_conduct集合
     */
    public List<StudentConduct> selectStudentConductList(StudentConduct studentConduct);

    /**
     * 新增student_conduct
     * 
     * @param studentConduct student_conduct
     * @return 结果
     */
    public int insertStudentConduct(StudentConduct studentConduct);

    /**
     * 修改student_conduct
     * 
     * @param studentConduct student_conduct
     * @return 结果
     */
    public int updateStudentConduct(StudentConduct studentConduct);

    /**
     * 删除student_conduct
     * 
     * @param conductId student_conduct主键
     * @return 结果
     */
    public int deleteStudentConductByConductId(Long conductId);

    /**
     * 批量删除student_conduct
     * 
     * @param conductIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStudentConductByConductIds(Long[] conductIds);
}
