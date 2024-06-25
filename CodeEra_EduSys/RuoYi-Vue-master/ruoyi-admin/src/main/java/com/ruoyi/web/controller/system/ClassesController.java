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
import com.ruoyi.system.domain.Classes;
import com.ruoyi.system.service.IClassesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * classesController
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
@RestController
@RequestMapping("/system/classes")
public class ClassesController extends BaseController
{
    @Autowired
    private IClassesService classesService;

    /**
     * 查询classes列表
     */
    @PreAuthorize("@ss.hasPermi('system:classes:list')")
    @GetMapping("/list")
    public TableDataInfo list(Classes classes)
    {
        startPage();
        List<Classes> list = classesService.selectClassesList(classes);
        return getDataTable(list);
    }

    /**
     * 导出classes列表
     */
    @PreAuthorize("@ss.hasPermi('system:classes:export')")
    @Log(title = "classes", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Classes classes)
    {
        List<Classes> list = classesService.selectClassesList(classes);
        ExcelUtil<Classes> util = new ExcelUtil<Classes>(Classes.class);
        util.exportExcel(response, list, "classes数据");
    }

    /**
     * 获取classes详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:classes:query')")
    @GetMapping(value = "/{classId}")
    public AjaxResult getInfo(@PathVariable("classId") Long classId)
    {
        return success(classesService.selectClassesByClassId(classId));
    }

    /**
     * 新增classes
     */
    @PreAuthorize("@ss.hasPermi('system:classes:add')")
    @Log(title = "classes", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Classes classes)
    {
        return toAjax(classesService.insertClasses(classes));
    }

    /**
     * 修改classes
     */
    @PreAuthorize("@ss.hasPermi('system:classes:edit')")
    @Log(title = "classes", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Classes classes)
    {
        return toAjax(classesService.updateClasses(classes));
    }

    /**
     * 删除classes
     */
    @PreAuthorize("@ss.hasPermi('system:classes:remove')")
    @Log(title = "classes", businessType = BusinessType.DELETE)
	@DeleteMapping("/{classIds}")
    public AjaxResult remove(@PathVariable Long[] classIds)
    {
        return toAjax(classesService.deleteClassesByClassIds(classIds));
    }
}
