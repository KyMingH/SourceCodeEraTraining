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
import com.ruoyi.system.domain.StudentRegularApproval;
import com.ruoyi.system.service.IStudentRegularApprovalService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * StudentRegularApprovalController
 * 
 * @author ttKymingH
 * @date 2024-06-25
 */
@RestController
@RequestMapping("/system/studentRegularApproval")
public class StudentRegularApprovalController extends BaseController
{
    @Autowired
    private IStudentRegularApprovalService studentRegularApprovalService;

    /**
     * 查询StudentRegularApproval列表
     */
    @PreAuthorize("@ss.hasPermi('system:studentRegularApproval:list')")
    @GetMapping("/list")
    public TableDataInfo list(StudentRegularApproval studentRegularApproval)
    {
        startPage();
        List<StudentRegularApproval> list = studentRegularApprovalService.selectStudentRegularApprovalList(studentRegularApproval);
        return getDataTable(list);
    }

    /**
     * 导出StudentRegularApproval列表
     */
    @PreAuthorize("@ss.hasPermi('system:studentRegularApproval:export')")
    @Log(title = "StudentRegularApproval", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StudentRegularApproval studentRegularApproval)
    {
        List<StudentRegularApproval> list = studentRegularApprovalService.selectStudentRegularApprovalList(studentRegularApproval);
        ExcelUtil<StudentRegularApproval> util = new ExcelUtil<StudentRegularApproval>(StudentRegularApproval.class);
        util.exportExcel(response, list, "StudentRegularApproval数据");
    }

    /**
     * 获取StudentRegularApproval详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:studentRegularApproval:query')")
    @GetMapping(value = "/{approvalId}")
    public AjaxResult getInfo(@PathVariable("approvalId") Long approvalId)
    {
        return success(studentRegularApprovalService.selectStudentRegularApprovalByApprovalId(approvalId));
    }

    /**
     * 新增StudentRegularApproval
     */
    @PreAuthorize("@ss.hasPermi('system:studentRegularApproval:add')")
    @Log(title = "StudentRegularApproval", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StudentRegularApproval studentRegularApproval)
    {
        return toAjax(studentRegularApprovalService.insertStudentRegularApproval(studentRegularApproval));
    }

    /**
     * 修改StudentRegularApproval
     */
    @PreAuthorize("@ss.hasPermi('system:studentRegularApproval:edit')")
    @Log(title = "StudentRegularApproval", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StudentRegularApproval studentRegularApproval)
    {
        return toAjax(studentRegularApprovalService.updateStudentRegularApproval(studentRegularApproval));
    }

    /**
     * 删除StudentRegularApproval
     */
    @PreAuthorize("@ss.hasPermi('system:studentRegularApproval:remove')")
    @Log(title = "StudentRegularApproval", businessType = BusinessType.DELETE)
	@DeleteMapping("/{approvalIds}")
    public AjaxResult remove(@PathVariable Long[] approvalIds)
    {
        return toAjax(studentRegularApprovalService.deleteStudentRegularApprovalByApprovalIds(approvalIds));
    }
}
