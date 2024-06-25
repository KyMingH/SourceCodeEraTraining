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
import com.ruoyi.system.domain.LeaveApproval;
import com.ruoyi.system.service.ILeaveApprovalService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * LeaveApprovalController
 * 
 * @author ttKymingH
 * @date 2024-06-25
 */
@RestController
@RequestMapping("/system/leaveApproval")
public class LeaveApprovalController extends BaseController
{
    @Autowired
    private ILeaveApprovalService leaveApprovalService;

    /**
     * 查询LeaveApproval列表
     */
    @PreAuthorize("@ss.hasPermi('system:leaveApproval:list')")
    @GetMapping("/list")
    public TableDataInfo list(LeaveApproval leaveApproval)
    {
        startPage();
        List<LeaveApproval> list = leaveApprovalService.selectLeaveApprovalList(leaveApproval);
        return getDataTable(list);
    }

    /**
     * 导出LeaveApproval列表
     */
    @PreAuthorize("@ss.hasPermi('system:leaveApproval:export')")
    @Log(title = "LeaveApproval", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LeaveApproval leaveApproval)
    {
        List<LeaveApproval> list = leaveApprovalService.selectLeaveApprovalList(leaveApproval);
        ExcelUtil<LeaveApproval> util = new ExcelUtil<LeaveApproval>(LeaveApproval.class);
        util.exportExcel(response, list, "LeaveApproval数据");
    }

    /**
     * 获取LeaveApproval详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:leaveApproval:query')")
    @GetMapping(value = "/{approvalId}")
    public AjaxResult getInfo(@PathVariable("approvalId") Long approvalId)
    {
        return success(leaveApprovalService.selectLeaveApprovalByApprovalId(approvalId));
    }

    /**
     * 新增LeaveApproval
     */
    @PreAuthorize("@ss.hasPermi('system:leaveApproval:add')")
    @Log(title = "LeaveApproval", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LeaveApproval leaveApproval)
    {
        return toAjax(leaveApprovalService.insertLeaveApproval(leaveApproval));
    }

    /**
     * 修改LeaveApproval
     */
    @PreAuthorize("@ss.hasPermi('system:leaveApproval:edit')")
    @Log(title = "LeaveApproval", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LeaveApproval leaveApproval)
    {
        return toAjax(leaveApprovalService.updateLeaveApproval(leaveApproval));
    }

    /**
     * 删除LeaveApproval
     */
    @PreAuthorize("@ss.hasPermi('system:leaveApproval:remove')")
    @Log(title = "LeaveApproval", businessType = BusinessType.DELETE)
	@DeleteMapping("/{approvalIds}")
    public AjaxResult remove(@PathVariable Long[] approvalIds)
    {
        return toAjax(leaveApprovalService.deleteLeaveApprovalByApprovalIds(approvalIds));
    }
}
