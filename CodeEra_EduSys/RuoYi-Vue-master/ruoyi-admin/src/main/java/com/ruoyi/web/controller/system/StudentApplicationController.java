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
import com.ruoyi.system.domain.StudentApplication;
import com.ruoyi.system.service.IStudentApplicationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * student_applicationController
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
@RestController
@RequestMapping("/system/application")
public class StudentApplicationController extends BaseController
{
    @Autowired
    private IStudentApplicationService studentApplicationService;

    /**
     * 查询student_application列表
     */
    @PreAuthorize("@ss.hasPermi('system:application:list')")
    @GetMapping("/list")
    public TableDataInfo list(StudentApplication studentApplication)
    {
        startPage();
        List<StudentApplication> list = studentApplicationService.selectStudentApplicationList(studentApplication);
        return getDataTable(list);
    }

    /**
     * 导出student_application列表
     */
    @PreAuthorize("@ss.hasPermi('system:application:export')")
    @Log(title = "student_application", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StudentApplication studentApplication)
    {
        List<StudentApplication> list = studentApplicationService.selectStudentApplicationList(studentApplication);
        ExcelUtil<StudentApplication> util = new ExcelUtil<StudentApplication>(StudentApplication.class);
        util.exportExcel(response, list, "student_application数据");
    }

    /**
     * 获取student_application详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:application:query')")
    @GetMapping(value = "/{applicationId}")
    public AjaxResult getInfo(@PathVariable("applicationId") Long applicationId)
    {
        return success(studentApplicationService.selectStudentApplicationByApplicationId(applicationId));
    }

    /**
     * 新增student_application
     */
    @PreAuthorize("@ss.hasPermi('system:application:add')")
    @Log(title = "student_application", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StudentApplication studentApplication)
    {
        return toAjax(studentApplicationService.insertStudentApplication(studentApplication));
    }

    /**
     * 修改student_application
     */
    @PreAuthorize("@ss.hasPermi('system:application:edit')")
    @Log(title = "student_application", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StudentApplication studentApplication)
    {
        return toAjax(studentApplicationService.updateStudentApplication(studentApplication));
    }

    /**
     * 删除student_application
     */
    @PreAuthorize("@ss.hasPermi('system:application:remove')")
    @Log(title = "student_application", businessType = BusinessType.DELETE)
	@DeleteMapping("/{applicationIds}")
    public AjaxResult remove(@PathVariable Long[] applicationIds)
    {
        return toAjax(studentApplicationService.deleteStudentApplicationByApplicationIds(applicationIds));
    }
}
