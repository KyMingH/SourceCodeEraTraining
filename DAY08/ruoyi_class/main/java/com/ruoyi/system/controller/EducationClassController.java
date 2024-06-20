package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.EducationClass;
import com.ruoyi.system.service.IEducationClassService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 班级管理Controller
 * 
 * @author kkmingKy
 * @date 2024-06-20
 */
@RestController
@RequestMapping("/system/class")
public class EducationClassController extends BaseController
{
    @Autowired
    private IEducationClassService educationClassService;

    /**
     * 查询班级管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:class:list')")
    @GetMapping("/list")
    public TableDataInfo list(EducationClass educationClass)
    {
        startPage();
        List<EducationClass> list = educationClassService.selectEducationClassList(educationClass);
        return getDataTable(list);
    }

    /**
     * 导出班级管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:class:export')")
    @Log(title = "班级管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EducationClass educationClass)
    {
        List<EducationClass> list = educationClassService.selectEducationClassList(educationClass);
        ExcelUtil<EducationClass> util = new ExcelUtil<EducationClass>(EducationClass.class);
        util.exportExcel(response, list, "班级管理数据");
    }

    /**
     * 获取班级管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:class:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(educationClassService.selectEducationClassById(id));
    }

    /**
     * 新增班级管理
     */
    @PreAuthorize("@ss.hasPermi('system:class:add')")
    @Log(title = "班级管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EducationClass educationClass)
    {
        return toAjax(educationClassService.insertEducationClass(educationClass));
    }

    /**
     * 修改班级管理
     */
    @PreAuthorize("@ss.hasPermi('system:class:edit')")
    @Log(title = "班级管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EducationClass educationClass)
    {
        return toAjax(educationClassService.updateEducationClass(educationClass));
    }

    /**
     * 删除班级管理
     */
    @PreAuthorize("@ss.hasPermi('system:class:remove')")
    @Log(title = "班级管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(educationClassService.deleteEducationClassByIds(ids));
    }
}
