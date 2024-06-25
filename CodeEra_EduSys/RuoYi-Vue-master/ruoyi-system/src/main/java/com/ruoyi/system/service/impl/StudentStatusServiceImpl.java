package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StudentStatusMapper;
import com.ruoyi.system.domain.StudentStatus;
import com.ruoyi.system.service.IStudentStatusService;

/**
 * student_statusService业务层处理
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
@Service
public class StudentStatusServiceImpl implements IStudentStatusService 
{
    @Autowired
    private StudentStatusMapper studentStatusMapper;

    /**
     * 查询student_status
     * 
     * @param statusId student_status主键
     * @return student_status
     */
    @Override
    public StudentStatus selectStudentStatusByStatusId(Long statusId)
    {
        return studentStatusMapper.selectStudentStatusByStatusId(statusId);
    }

    /**
     * 查询student_status列表
     * 
     * @param studentStatus student_status
     * @return student_status
     */
    @Override
    public List<StudentStatus> selectStudentStatusList(StudentStatus studentStatus)
    {
        return studentStatusMapper.selectStudentStatusList(studentStatus);
    }

    /**
     * 新增student_status
     * 
     * @param studentStatus student_status
     * @return 结果
     */
    @Override
    public int insertStudentStatus(StudentStatus studentStatus)
    {
        studentStatus.setCreateTime(DateUtils.getNowDate());
        return studentStatusMapper.insertStudentStatus(studentStatus);
    }

    /**
     * 修改student_status
     * 
     * @param studentStatus student_status
     * @return 结果
     */
    @Override
    public int updateStudentStatus(StudentStatus studentStatus)
    {
        studentStatus.setUpdateTime(DateUtils.getNowDate());
        return studentStatusMapper.updateStudentStatus(studentStatus);
    }

    /**
     * 批量删除student_status
     * 
     * @param statusIds 需要删除的student_status主键
     * @return 结果
     */
    @Override
    public int deleteStudentStatusByStatusIds(Long[] statusIds)
    {
        return studentStatusMapper.deleteStudentStatusByStatusIds(statusIds);
    }

    /**
     * 删除student_status信息
     * 
     * @param statusId student_status主键
     * @return 结果
     */
    @Override
    public int deleteStudentStatusByStatusId(Long statusId)
    {
        return studentStatusMapper.deleteStudentStatusByStatusId(statusId);
    }
}
