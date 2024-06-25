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
import com.ruoyi.system.domain.TrialStudentCommunication;
import com.ruoyi.system.service.ITrialStudentCommunicationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * TrialStudentCommunicationController
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
@RestController
@RequestMapping("/system/communication")
public class TrialStudentCommunicationController extends BaseController
{
    @Autowired
    private ITrialStudentCommunicationService trialStudentCommunicationService;

    /**
     * 查询TrialStudentCommunication列表
     */
    @PreAuthorize("@ss.hasPermi('system:communication:list')")
    @GetMapping("/list")
    public TableDataInfo list(TrialStudentCommunication trialStudentCommunication)
    {
        startPage();
        List<TrialStudentCommunication> list = trialStudentCommunicationService.selectTrialStudentCommunicationList(trialStudentCommunication);
        return getDataTable(list);
    }

    /**
     * 导出TrialStudentCommunication列表
     */
    @PreAuthorize("@ss.hasPermi('system:communication:export')")
    @Log(title = "TrialStudentCommunication", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TrialStudentCommunication trialStudentCommunication)
    {
        List<TrialStudentCommunication> list = trialStudentCommunicationService.selectTrialStudentCommunicationList(trialStudentCommunication);
        ExcelUtil<TrialStudentCommunication> util = new ExcelUtil<TrialStudentCommunication>(TrialStudentCommunication.class);
        util.exportExcel(response, list, "TrialStudentCommunication数据");
    }

    /**
     * 获取TrialStudentCommunication详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:communication:query')")
    @GetMapping(value = "/{communicationId}")
    public AjaxResult getInfo(@PathVariable("communicationId") Long communicationId)
    {
        return success(trialStudentCommunicationService.selectTrialStudentCommunicationByCommunicationId(communicationId));
    }

    /**
     * 新增TrialStudentCommunication
     */
    @PreAuthorize("@ss.hasPermi('system:communication:add')")
    @Log(title = "TrialStudentCommunication", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TrialStudentCommunication trialStudentCommunication)
    {
        return toAjax(trialStudentCommunicationService.insertTrialStudentCommunication(trialStudentCommunication));
    }

    /**
     * 修改TrialStudentCommunication
     */
    @PreAuthorize("@ss.hasPermi('system:communication:edit')")
    @Log(title = "TrialStudentCommunication", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TrialStudentCommunication trialStudentCommunication)
    {
        return toAjax(trialStudentCommunicationService.updateTrialStudentCommunication(trialStudentCommunication));
    }

    /**
     * 删除TrialStudentCommunication
     */
    @PreAuthorize("@ss.hasPermi('system:communication:remove')")
    @Log(title = "TrialStudentCommunication", businessType = BusinessType.DELETE)
	@DeleteMapping("/{communicationIds}")
    public AjaxResult remove(@PathVariable Long[] communicationIds)
    {
        return toAjax(trialStudentCommunicationService.deleteTrialStudentCommunicationByCommunicationIds(communicationIds));
    }
}
