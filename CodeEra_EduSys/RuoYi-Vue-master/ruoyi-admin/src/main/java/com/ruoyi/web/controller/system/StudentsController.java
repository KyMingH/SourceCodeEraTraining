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
import com.ruoyi.system.domain.Students;
import com.ruoyi.system.service.IStudentsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学员基本信息Controller
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
@RestController
@RequestMapping("/system/students_")
public class StudentsController extends BaseController
{
    @Autowired
    private IStudentsService studentsService;

    /**
     * 查询学员基本信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:students:list')")
    @GetMapping("/list")
    public TableDataInfo list(Students students)
    {
        startPage();
        List<Students> list = studentsService.selectStudentsList(students);
        return getDataTable(list);
    }

    /**
     * 导出学员基本信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:students:export')")
    @Log(title = "学员基本信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Students students)
    {
        List<Students> list = studentsService.selectStudentsList(students);
        ExcelUtil<Students> util = new ExcelUtil<Students>(Students.class);
        util.exportExcel(response, list, "学员基本信息数据");
    }

    /**
     * 获取学员基本信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:students:query')")
    @GetMapping(value = "/{studentId}")
    public AjaxResult getInfo(@PathVariable("studentId") Long studentId)
    {
        return success(studentsService.selectStudentsByStudentId(studentId));
    }

    /**
     * 新增学员基本信息
     */
    @PreAuthorize("@ss.hasPermi('system:students:add')")
    @Log(title = "学员基本信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Students students)
    {
        return toAjax(studentsService.insertStudents(students));
    }

    /**
     * 修改学员基本信息
     */
    @PreAuthorize("@ss.hasPermi('system:students:edit')")
    @Log(title = "学员基本信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Students students)
    {
        return toAjax(studentsService.updateStudents(students));
    }

    /**
     * 删除学员基本信息
     */
    @PreAuthorize("@ss.hasPermi('system:students:remove')")
    @Log(title = "学员基本信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{studentIds}")
    public AjaxResult remove(@PathVariable Long[] studentIds)
    {
        return toAjax(studentsService.deleteStudentsByStudentIds(studentIds));
    }
}
