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
import com.ruoyi.system.domain.AlumniFollowUp;
import com.ruoyi.system.service.IAlumniFollowUpService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * alumni_follow_upController
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
@RestController
@RequestMapping("/system/up")
public class AlumniFollowUpController extends BaseController
{
    @Autowired
    private IAlumniFollowUpService alumniFollowUpService;

    /**
     * 查询alumni_follow_up列表
     */
    @PreAuthorize("@ss.hasPermi('system:up:list')")
    @GetMapping("/list")
    public TableDataInfo list(AlumniFollowUp alumniFollowUp)
    {
        startPage();
        List<AlumniFollowUp> list = alumniFollowUpService.selectAlumniFollowUpList(alumniFollowUp);
        return getDataTable(list);
    }

    /**
     * 导出alumni_follow_up列表
     */
    @PreAuthorize("@ss.hasPermi('system:up:export')")
    @Log(title = "alumni_follow_up", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AlumniFollowUp alumniFollowUp)
    {
        List<AlumniFollowUp> list = alumniFollowUpService.selectAlumniFollowUpList(alumniFollowUp);
        ExcelUtil<AlumniFollowUp> util = new ExcelUtil<AlumniFollowUp>(AlumniFollowUp.class);
        util.exportExcel(response, list, "alumni_follow_up数据");
    }

    /**
     * 获取alumni_follow_up详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:up:query')")
    @GetMapping(value = "/{followUpId}")
    public AjaxResult getInfo(@PathVariable("followUpId") Long followUpId)
    {
        return success(alumniFollowUpService.selectAlumniFollowUpByFollowUpId(followUpId));
    }

    /**
     * 新增alumni_follow_up
     */
    @PreAuthorize("@ss.hasPermi('system:up:add')")
    @Log(title = "alumni_follow_up", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AlumniFollowUp alumniFollowUp)
    {
        return toAjax(alumniFollowUpService.insertAlumniFollowUp(alumniFollowUp));
    }

    /**
     * 修改alumni_follow_up
     */
    @PreAuthorize("@ss.hasPermi('system:up:edit')")
    @Log(title = "alumni_follow_up", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AlumniFollowUp alumniFollowUp)
    {
        return toAjax(alumniFollowUpService.updateAlumniFollowUp(alumniFollowUp));
    }

    /**
     * 删除alumni_follow_up
     */
    @PreAuthorize("@ss.hasPermi('system:up:remove')")
    @Log(title = "alumni_follow_up", businessType = BusinessType.DELETE)
	@DeleteMapping("/{followUpIds}")
    public AjaxResult remove(@PathVariable Long[] followUpIds)
    {
        return toAjax(alumniFollowUpService.deleteAlumniFollowUpByFollowUpIds(followUpIds));
    }
}
