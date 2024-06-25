package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.StudentStatus;

/**
 * student_statusMapper接口
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
public interface StudentStatusMapper 
{
    /**
     * 查询student_status
     * 
     * @param statusId student_status主键
     * @return student_status
     */
    public StudentStatus selectStudentStatusByStatusId(Long statusId);

    /**
     * 查询student_status列表
     * 
     * @param studentStatus student_status
     * @return student_status集合
     */
    public List<StudentStatus> selectStudentStatusList(StudentStatus studentStatus);

    /**
     * 新增student_status
     * 
     * @param studentStatus student_status
     * @return 结果
     */
    public int insertStudentStatus(StudentStatus studentStatus);

    /**
     * 修改student_status
     * 
     * @param studentStatus student_status
     * @return 结果
     */
    public int updateStudentStatus(StudentStatus studentStatus);

    /**
     * 删除student_status
     * 
     * @param statusId student_status主键
     * @return 结果
     */
    public int deleteStudentStatusByStatusId(Long statusId);

    /**
     * 批量删除student_status
     * 
     * @param statusIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStudentStatusByStatusIds(Long[] statusIds);
}
