package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Classes;

/**
 * classesService接口
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
public interface IClassesService 
{
    /**
     * 查询classes
     * 
     * @param classId classes主键
     * @return classes
     */
    public Classes selectClassesByClassId(Long classId);

    /**
     * 查询classes列表
     * 
     * @param classes classes
     * @return classes集合
     */
    public List<Classes> selectClassesList(Classes classes);

    /**
     * 新增classes
     * 
     * @param classes classes
     * @return 结果
     */
    public int insertClasses(Classes classes);

    /**
     * 修改classes
     * 
     * @param classes classes
     * @return 结果
     */
    public int updateClasses(Classes classes);

    /**
     * 批量删除classes
     * 
     * @param classIds 需要删除的classes主键集合
     * @return 结果
     */
    public int deleteClassesByClassIds(Long[] classIds);

    /**
     * 删除classes信息
     * 
     * @param classId classes主键
     * @return 结果
     */
    public int deleteClassesByClassId(Long classId);
}
