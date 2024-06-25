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
import com.ruoyi.system.domain.StudentStatus;
import com.ruoyi.system.service.IStudentStatusService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * student_statusController
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
@RestController
@RequestMapping("/system/status")
public class StudentStatusController extends BaseController
{
    @Autowired
    private IStudentStatusService studentStatusService;

    /**
     * 查询student_status列表
     */
    @PreAuthorize("@ss.hasPermi('system:status:list')")
    @GetMapping("/list")
    public TableDataInfo list(StudentStatus studentStatus)
    {
        startPage();
        List<StudentStatus> list = studentStatusService.selectStudentStatusList(studentStatus);
        return getDataTable(list);
    }

    /**
     * 导出student_status列表
     */
    @PreAuthorize("@ss.hasPermi('system:status:export')")
    @Log(title = "student_status", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StudentStatus studentStatus)
    {
        List<StudentStatus> list = studentStatusService.selectStudentStatusList(studentStatus);
        ExcelUtil<StudentStatus> util = new ExcelUtil<StudentStatus>(StudentStatus.class);
        util.exportExcel(response, list, "student_status数据");
    }

    /**
     * 获取student_status详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:status:query')")
    @GetMapping(value = "/{statusId}")
    public AjaxResult getInfo(@PathVariable("statusId") Long statusId)
    {
        return success(studentStatusService.selectStudentStatusByStatusId(statusId));
    }

    /**
     * 新增student_status
     */
    @PreAuthorize("@ss.hasPermi('system:status:add')")
    @Log(title = "student_status", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StudentStatus studentStatus)
    {
        return toAjax(studentStatusService.insertStudentStatus(studentStatus));
    }

    /**
     * 修改student_status
     */
    @PreAuthorize("@ss.hasPermi('system:status:edit')")
    @Log(title = "student_status", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StudentStatus studentStatus)
    {
        return toAjax(studentStatusService.updateStudentStatus(studentStatus));
    }

    /**
     * 删除student_status
     */
    @PreAuthorize("@ss.hasPermi('system:status:remove')")
    @Log(title = "student_status", businessType = BusinessType.DELETE)
	@DeleteMapping("/{statusIds}")
    public AjaxResult remove(@PathVariable Long[] statusIds)
    {
        return toAjax(studentStatusService.deleteStudentStatusByStatusIds(statusIds));
    }
}
