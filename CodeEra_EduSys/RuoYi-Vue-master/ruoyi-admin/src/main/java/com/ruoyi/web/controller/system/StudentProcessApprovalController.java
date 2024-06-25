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
import com.ruoyi.system.domain.StudentProcessApproval;
import com.ruoyi.system.service.IStudentProcessApprovalService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * StudentProcessApprovalController
 * 
 * @author ttKymingH
 * @date 2024-06-25
 */
@RestController
@RequestMapping("/system/studentProcessApproval")
public class StudentProcessApprovalController extends BaseController
{
    @Autowired
    private IStudentProcessApprovalService studentProcessApprovalService;

    /**
     * 查询StudentProcessApproval列表
     */
    @PreAuthorize("@ss.hasPermi('system:studentProcessApproval:list')")
    @GetMapping("/list")
    public TableDataInfo list(StudentProcessApproval studentProcessApproval)
    {
        startPage();
        List<StudentProcessApproval> list = studentProcessApprovalService.selectStudentProcessApprovalList(studentProcessApproval);
        return getDataTable(list);
    }

    /**
     * 导出StudentProcessApproval列表
     */
    @PreAuthorize("@ss.hasPermi('system:studentProcessApproval:export')")
    @Log(title = "StudentProcessApproval", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StudentProcessApproval studentProcessApproval)
    {
        List<StudentProcessApproval> list = studentProcessApprovalService.selectStudentProcessApprovalList(studentProcessApproval);
        ExcelUtil<StudentProcessApproval> util = new ExcelUtil<StudentProcessApproval>(StudentProcessApproval.class);
        util.exportExcel(response, list, "StudentProcessApproval数据");
    }

    /**
     * 获取StudentProcessApproval详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:studentProcessApproval:query')")
    @GetMapping(value = "/{approvalId}")
    public AjaxResult getInfo(@PathVariable("approvalId") Long approvalId)
    {
        return success(studentProcessApprovalService.selectStudentProcessApprovalByApprovalId(approvalId));
    }

    /**
     * 新增StudentProcessApproval
     */
    @PreAuthorize("@ss.hasPermi('system:studentProcessApproval:add')")
    @Log(title = "StudentProcessApproval", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StudentProcessApproval studentProcessApproval)
    {
        return toAjax(studentProcessApprovalService.insertStudentProcessApproval(studentProcessApproval));
    }

    /**
     * 修改StudentProcessApproval
     */
    @PreAuthorize("@ss.hasPermi('system:studentProcessApproval:edit')")
    @Log(title = "StudentProcessApproval", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StudentProcessApproval studentProcessApproval)
    {
        return toAjax(studentProcessApprovalService.updateStudentProcessApproval(studentProcessApproval));
    }

    /**
     * 删除StudentProcessApproval
     */
    @PreAuthorize("@ss.hasPermi('system:studentProcessApproval:remove')")
    @Log(title = "StudentProcessApproval", businessType = BusinessType.DELETE)
	@DeleteMapping("/{approvalIds}")
    public AjaxResult remove(@PathVariable Long[] approvalIds)
    {
        return toAjax(studentProcessApprovalService.deleteStudentProcessApprovalByApprovalIds(approvalIds));
    }
}
