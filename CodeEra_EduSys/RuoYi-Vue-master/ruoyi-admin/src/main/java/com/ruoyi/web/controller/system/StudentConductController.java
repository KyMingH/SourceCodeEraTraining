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
import com.ruoyi.system.domain.StudentConduct;
import com.ruoyi.system.service.IStudentConductService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * student_conductController
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
@RestController
@RequestMapping("/system/conduct")
public class StudentConductController extends BaseController
{
    @Autowired
    private IStudentConductService studentConductService;

    /**
     * 查询student_conduct列表
     */
    @PreAuthorize("@ss.hasPermi('system:conduct:list')")
    @GetMapping("/list")
    public TableDataInfo list(StudentConduct studentConduct)
    {
        startPage();
        List<StudentConduct> list = studentConductService.selectStudentConductList(studentConduct);
        return getDataTable(list);
    }

    /**
     * 导出student_conduct列表
     */
    @PreAuthorize("@ss.hasPermi('system:conduct:export')")
    @Log(title = "student_conduct", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StudentConduct studentConduct)
    {
        List<StudentConduct> list = studentConductService.selectStudentConductList(studentConduct);
        ExcelUtil<StudentConduct> util = new ExcelUtil<StudentConduct>(StudentConduct.class);
        util.exportExcel(response, list, "student_conduct数据");
    }

    /**
     * 获取student_conduct详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:conduct:query')")
    @GetMapping(value = "/{conductId}")
    public AjaxResult getInfo(@PathVariable("conductId") Long conductId)
    {
        return success(studentConductService.selectStudentConductByConductId(conductId));
    }

    /**
     * 新增student_conduct
     */
    @PreAuthorize("@ss.hasPermi('system:conduct:add')")
    @Log(title = "student_conduct", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StudentConduct studentConduct)
    {
        return toAjax(studentConductService.insertStudentConduct(studentConduct));
    }

    /**
     * 修改student_conduct
     */
    @PreAuthorize("@ss.hasPermi('system:conduct:edit')")
    @Log(title = "student_conduct", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StudentConduct studentConduct)
    {
        return toAjax(studentConductService.updateStudentConduct(studentConduct));
    }

    /**
     * 删除student_conduct
     */
    @PreAuthorize("@ss.hasPermi('system:conduct:remove')")
    @Log(title = "student_conduct", businessType = BusinessType.DELETE)
	@DeleteMapping("/{conductIds}")
    public AjaxResult remove(@PathVariable Long[] conductIds)
    {
        return toAjax(studentConductService.deleteStudentConductByConductIds(conductIds));
    }
}
