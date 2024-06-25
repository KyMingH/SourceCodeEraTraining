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
import com.ruoyi.system.domain.ClassSchedule;
import com.ruoyi.system.service.IClassScheduleService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * class_scheduleController
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
@RestController
@RequestMapping("/system/schedule")
public class ClassScheduleController extends BaseController
{
    @Autowired
    private IClassScheduleService classScheduleService;

    /**
     * 查询class_schedule列表
     */
    @PreAuthorize("@ss.hasPermi('system:schedule:list')")
    @GetMapping("/list")
    public TableDataInfo list(ClassSchedule classSchedule)
    {
        startPage();
        List<ClassSchedule> list = classScheduleService.selectClassScheduleList(classSchedule);
        return getDataTable(list);
    }

    /**
     * 导出class_schedule列表
     */
    @PreAuthorize("@ss.hasPermi('system:schedule:export')")
    @Log(title = "class_schedule", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ClassSchedule classSchedule)
    {
        List<ClassSchedule> list = classScheduleService.selectClassScheduleList(classSchedule);
        ExcelUtil<ClassSchedule> util = new ExcelUtil<ClassSchedule>(ClassSchedule.class);
        util.exportExcel(response, list, "class_schedule数据");
    }

    /**
     * 获取class_schedule详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:schedule:query')")
    @GetMapping(value = "/{scheduleId}")
    public AjaxResult getInfo(@PathVariable("scheduleId") Long scheduleId)
    {
        return success(classScheduleService.selectClassScheduleByScheduleId(scheduleId));
    }

    /**
     * 新增class_schedule
     */
    @PreAuthorize("@ss.hasPermi('system:schedule:add')")
    @Log(title = "class_schedule", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ClassSchedule classSchedule)
    {
        return toAjax(classScheduleService.insertClassSchedule(classSchedule));
    }

    /**
     * 修改class_schedule
     */
    @PreAuthorize("@ss.hasPermi('system:schedule:edit')")
    @Log(title = "class_schedule", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ClassSchedule classSchedule)
    {
        return toAjax(classScheduleService.updateClassSchedule(classSchedule));
    }

    /**
     * 删除class_schedule
     */
    @PreAuthorize("@ss.hasPermi('system:schedule:remove')")
    @Log(title = "class_schedule", businessType = BusinessType.DELETE)
	@DeleteMapping("/{scheduleIds}")
    public AjaxResult remove(@PathVariable Long[] scheduleIds)
    {
        return toAjax(classScheduleService.deleteClassScheduleByScheduleIds(scheduleIds));
    }
}
