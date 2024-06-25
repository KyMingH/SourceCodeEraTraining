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
import com.ruoyi.system.domain.Teachers;
import com.ruoyi.system.service.ITeachersService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * teachersController
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
@RestController
@RequestMapping("/system/teachers")
public class TeachersController extends BaseController
{
    @Autowired
    private ITeachersService teachersService;

    /**
     * 查询teachers列表
     */
    @PreAuthorize("@ss.hasPermi('system:teachers:list')")
    @GetMapping("/list")
    public TableDataInfo list(Teachers teachers)
    {
        startPage();
        List<Teachers> list = teachersService.selectTeachersList(teachers);
        return getDataTable(list);
    }

    /**
     * 导出teachers列表
     */
    @PreAuthorize("@ss.hasPermi('system:teachers:export')")
    @Log(title = "teachers", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Teachers teachers)
    {
        List<Teachers> list = teachersService.selectTeachersList(teachers);
        ExcelUtil<Teachers> util = new ExcelUtil<Teachers>(Teachers.class);
        util.exportExcel(response, list, "teachers数据");
    }

    /**
     * 获取teachers详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:teachers:query')")
    @GetMapping(value = "/{teacherId}")
    public AjaxResult getInfo(@PathVariable("teacherId") Long teacherId)
    {
        return success(teachersService.selectTeachersByTeacherId(teacherId));
    }

    /**
     * 新增teachers
     */
    @PreAuthorize("@ss.hasPermi('system:teachers:add')")
    @Log(title = "teachers", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Teachers teachers)
    {
        return toAjax(teachersService.insertTeachers(teachers));
    }

    /**
     * 修改teachers
     */
    @PreAuthorize("@ss.hasPermi('system:teachers:edit')")
    @Log(title = "teachers", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Teachers teachers)
    {
        return toAjax(teachersService.updateTeachers(teachers));
    }

    /**
     * 删除teachers
     */
    @PreAuthorize("@ss.hasPermi('system:teachers:remove')")
    @Log(title = "teachers", businessType = BusinessType.DELETE)
	@DeleteMapping("/{teacherIds}")
    public AjaxResult remove(@PathVariable Long[] teacherIds)
    {
        return toAjax(teachersService.deleteTeachersByTeacherIds(teacherIds));
    }
}
