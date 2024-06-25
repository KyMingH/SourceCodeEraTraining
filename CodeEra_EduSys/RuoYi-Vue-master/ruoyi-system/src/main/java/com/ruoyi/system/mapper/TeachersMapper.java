package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Teachers;

/**
 * teachersMapper接口
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
public interface TeachersMapper 
{
    /**
     * 查询teachers
     * 
     * @param teacherId teachers主键
     * @return teachers
     */
    public Teachers selectTeachersByTeacherId(Long teacherId);

    /**
     * 查询teachers列表
     * 
     * @param teachers teachers
     * @return teachers集合
     */
    public List<Teachers> selectTeachersList(Teachers teachers);

    /**
     * 新增teachers
     * 
     * @param teachers teachers
     * @return 结果
     */
    public int insertTeachers(Teachers teachers);

    /**
     * 修改teachers
     * 
     * @param teachers teachers
     * @return 结果
     */
    public int updateTeachers(Teachers teachers);

    /**
     * 删除teachers
     * 
     * @param teacherId teachers主键
     * @return 结果
     */
    public int deleteTeachersByTeacherId(Long teacherId);

    /**
     * 批量删除teachers
     * 
     * @param teacherIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTeachersByTeacherIds(Long[] teacherIds);
}
