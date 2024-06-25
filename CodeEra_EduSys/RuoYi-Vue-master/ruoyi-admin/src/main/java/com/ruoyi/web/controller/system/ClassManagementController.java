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
import com.ruoyi.system.domain.ClassManagement;
import com.ruoyi.system.service.IClassManagementService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * class_managementController
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
@RestController
@RequestMapping("/system/management")
public class ClassManagementController extends BaseController
{
    @Autowired
    private IClassManagementService classManagementService;

    /**
     * 查询class_management列表
     */
    @PreAuthorize("@ss.hasPermi('system:management:list')")
    @GetMapping("/list")
    public TableDataInfo list(ClassManagement classManagement)
    {
        startPage();
        List<ClassManagement> list = classManagementService.selectClassManagementList(classManagement);
        return getDataTable(list);
    }

    /**
     * 导出class_management列表
     */
    @PreAuthorize("@ss.hasPermi('system:management:export')")
    @Log(title = "class_management", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ClassManagement classManagement)
    {
        List<ClassManagement> list = classManagementService.selectClassManagementList(classManagement);
        ExcelUtil<ClassManagement> util = new ExcelUtil<ClassManagement>(ClassManagement.class);
        util.exportExcel(response, list, "class_management数据");
    }

    /**
     * 获取class_management详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:management:query')")
    @GetMapping(value = "/{operationId}")
    public AjaxResult getInfo(@PathVariable("operationId") Long operationId)
    {
        return success(classManagementService.selectClassManagementByOperationId(operationId));
    }

    /**
     * 新增class_management
     */
    @PreAuthorize("@ss.hasPermi('system:management:add')")
    @Log(title = "class_management", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ClassManagement classManagement)
    {
        return toAjax(classManagementService.insertClassManagement(classManagement));
    }

    /**
     * 修改class_management
     */
    @PreAuthorize("@ss.hasPermi('system:management:edit')")
    @Log(title = "class_management", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ClassManagement classManagement)
    {
        return toAjax(classManagementService.updateClassManagement(classManagement));
    }

    /**
     * 删除class_management
     */
    @PreAuthorize("@ss.hasPermi('system:management:remove')")
    @Log(title = "class_management", businessType = BusinessType.DELETE)
	@DeleteMapping("/{operationIds}")
    public AjaxResult remove(@PathVariable Long[] operationIds)
    {
        return toAjax(classManagementService.deleteClassManagementByOperationIds(operationIds));
    }
}
