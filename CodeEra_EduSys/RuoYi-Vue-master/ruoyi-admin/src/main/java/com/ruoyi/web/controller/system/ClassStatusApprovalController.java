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
import com.ruoyi.system.domain.ClassStatusApproval;
import com.ruoyi.system.service.IClassStatusApprovalService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * ClassStatusApprovalController
 * 
 * @author ttKymingH
 * @date 2024-06-25
 */
@RestController
@RequestMapping("/system/classStatusApproval")
public class ClassStatusApprovalController extends BaseController
{
    @Autowired
    private IClassStatusApprovalService classStatusApprovalService;

    /**
     * 查询ClassStatusApproval列表
     */
    @PreAuthorize("@ss.hasPermi('system:classStatusApproval:list')")
    @GetMapping("/list")
    public TableDataInfo list(ClassStatusApproval classStatusApproval)
    {
        startPage();
        List<ClassStatusApproval> list = classStatusApprovalService.selectClassStatusApprovalList(classStatusApproval);
        return getDataTable(list);
    }

    /**
     * 导出ClassStatusApproval列表
     */
    @PreAuthorize("@ss.hasPermi('system:classStatusApproval:export')")
    @Log(title = "ClassStatusApproval", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ClassStatusApproval classStatusApproval)
    {
        List<ClassStatusApproval> list = classStatusApprovalService.selectClassStatusApprovalList(classStatusApproval);
        ExcelUtil<ClassStatusApproval> util = new ExcelUtil<ClassStatusApproval>(ClassStatusApproval.class);
        util.exportExcel(response, list, "ClassStatusApproval数据");
    }

    /**
     * 获取ClassStatusApproval详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:classStatusApproval:query')")
    @GetMapping(value = "/{approvalId}")
    public AjaxResult getInfo(@PathVariable("approvalId") Long approvalId)
    {
        return success(classStatusApprovalService.selectClassStatusApprovalByApprovalId(approvalId));
    }

    /**
     * 新增ClassStatusApproval
     */
    @PreAuthorize("@ss.hasPermi('system:classStatusApproval:add')")
    @Log(title = "ClassStatusApproval", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ClassStatusApproval classStatusApproval)
    {
        return toAjax(classStatusApprovalService.insertClassStatusApproval(classStatusApproval));
    }

    /**
     * 修改ClassStatusApproval
     */
    @PreAuthorize("@ss.hasPermi('system:classStatusApproval:edit')")
    @Log(title = "ClassStatusApproval", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ClassStatusApproval classStatusApproval)
    {
        return toAjax(classStatusApprovalService.updateClassStatusApproval(classStatusApproval));
    }

    /**
     * 删除ClassStatusApproval
     */
    @PreAuthorize("@ss.hasPermi('system:classStatusApproval:remove')")
    @Log(title = "ClassStatusApproval", businessType = BusinessType.DELETE)
	@DeleteMapping("/{approvalIds}")
    public AjaxResult remove(@PathVariable Long[] approvalIds)
    {
        return toAjax(classStatusApprovalService.deleteClassStatusApprovalByApprovalIds(approvalIds));
    }
}
