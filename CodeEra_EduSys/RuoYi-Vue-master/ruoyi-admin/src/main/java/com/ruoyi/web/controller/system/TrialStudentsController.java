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
import com.ruoyi.system.domain.TrialStudents;
import com.ruoyi.system.service.ITrialStudentsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * trial_studentsController
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
@RestController
@RequestMapping("/system/students")
public class TrialStudentsController extends BaseController
{
    @Autowired
    private ITrialStudentsService trialStudentsService;

    /**
     * 查询trial_students列表
     */
    @PreAuthorize("@ss.hasPermi('system:students:list')")
    @GetMapping("/list")
    public TableDataInfo list(TrialStudents trialStudents)
    {
        startPage();
        List<TrialStudents> list = trialStudentsService.selectTrialStudentsList(trialStudents);
        return getDataTable(list);
    }

    /**
     * 导出trial_students列表
     */
    @PreAuthorize("@ss.hasPermi('system:students:export')")
    @Log(title = "trial_students", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TrialStudents trialStudents)
    {
        List<TrialStudents> list = trialStudentsService.selectTrialStudentsList(trialStudents);
        ExcelUtil<TrialStudents> util = new ExcelUtil<TrialStudents>(TrialStudents.class);
        util.exportExcel(response, list, "trial_students数据");
    }

    /**
     * 获取trial_students详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:students:query')")
    @GetMapping(value = "/{trialStudentId}")
    public AjaxResult getInfo(@PathVariable("trialStudentId") Long trialStudentId)
    {
        return success(trialStudentsService.selectTrialStudentsByTrialStudentId(trialStudentId));
    }

    /**
     * 新增trial_students
     */
    @PreAuthorize("@ss.hasPermi('system:students:add')")
    @Log(title = "trial_students", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TrialStudents trialStudents)
    {
        return toAjax(trialStudentsService.insertTrialStudents(trialStudents));
    }

    /**
     * 修改trial_students
     */
    @PreAuthorize("@ss.hasPermi('system:students:edit')")
    @Log(title = "trial_students", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TrialStudents trialStudents)
    {
        return toAjax(trialStudentsService.updateTrialStudents(trialStudents));
    }

    /**
     * 删除trial_students
     */
    @PreAuthorize("@ss.hasPermi('system:students:remove')")
    @Log(title = "trial_students", businessType = BusinessType.DELETE)
	@DeleteMapping("/{trialStudentIds}")
    public AjaxResult remove(@PathVariable Long[] trialStudentIds)
    {
        return toAjax(trialStudentsService.deleteTrialStudentsByTrialStudentIds(trialStudentIds));
    }
}
