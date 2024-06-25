package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Classes;

/**
 * classesMapper接口
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
public interface ClassesMapper 
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
     * 删除classes
     * 
     * @param classId classes主键
     * @return 结果
     */
    public int deleteClassesByClassId(Long classId);

    /**
     * 批量删除classes
     * 
     * @param classIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteClassesByClassIds(Long[] classIds);
}
