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
import com.ruoyi.system.domain.ClassDailyReport;
import com.ruoyi.system.service.IClassDailyReportService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * class_daily_reportController
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
@RestController
@RequestMapping("/system/report")
public class ClassDailyReportController extends BaseController
{
    @Autowired
    private IClassDailyReportService classDailyReportService;

    /**
     * 查询class_daily_report列表
     */
    @PreAuthorize("@ss.hasPermi('system:report:list')")
    @GetMapping("/list")
    public TableDataInfo list(ClassDailyReport classDailyReport)
    {
        startPage();
        List<ClassDailyReport> list = classDailyReportService.selectClassDailyReportList(classDailyReport);
        return getDataTable(list);
    }

    /**
     * 导出class_daily_report列表
     */
    @PreAuthorize("@ss.hasPermi('system:report:export')")
    @Log(title = "class_daily_report", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ClassDailyReport classDailyReport)
    {
        List<ClassDailyReport> list = classDailyReportService.selectClassDailyReportList(classDailyReport);
        ExcelUtil<ClassDailyReport> util = new ExcelUtil<ClassDailyReport>(ClassDailyReport.class);
        util.exportExcel(response, list, "class_daily_report数据");
    }

    /**
     * 获取class_daily_report详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:report:query')")
    @GetMapping(value = "/{reportId}")
    public AjaxResult getInfo(@PathVariable("reportId") Long reportId)
    {
        return success(classDailyReportService.selectClassDailyReportByReportId(reportId));
    }

    /**
     * 新增class_daily_report
     */
    @PreAuthorize("@ss.hasPermi('system:report:add')")
    @Log(title = "class_daily_report", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ClassDailyReport classDailyReport)
    {
        return toAjax(classDailyReportService.insertClassDailyReport(classDailyReport));
    }

    /**
     * 修改class_daily_report
     */
    @PreAuthorize("@ss.hasPermi('system:report:edit')")
    @Log(title = "class_daily_report", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ClassDailyReport classDailyReport)
    {
        return toAjax(classDailyReportService.updateClassDailyReport(classDailyReport));
    }

    /**
     * 删除class_daily_report
     */
    @PreAuthorize("@ss.hasPermi('system:report:remove')")
    @Log(title = "class_daily_report", businessType = BusinessType.DELETE)
	@DeleteMapping("/{reportIds}")
    public AjaxResult remove(@PathVariable Long[] reportIds)
    {
        return toAjax(classDailyReportService.deleteClassDailyReportByReportIds(reportIds));
    }
}
