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
import com.ruoyi.system.domain.TrialStudentsM;
import com.ruoyi.system.service.ITrialStudentsMService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * trial_studentsMController
 * 
 * @author ttKymingH
 * @date 2024-06-25
 */
@RestController
@RequestMapping("/system/trial_studentsM")
public class TrialStudentsMController extends BaseController
{
    @Autowired
    private ITrialStudentsMService trialStudentsMService;

    /**
     * 查询trial_studentsM列表
     */
    @PreAuthorize("@ss.hasPermi('system:trial_studentsM:list')")
    @GetMapping("/list")
    public TableDataInfo list(TrialStudentsM trialStudentsM)
    {
        startPage();
        List<TrialStudentsM> list = trialStudentsMService.selectTrialStudentsMList(trialStudentsM);
        return getDataTable(list);
    }

    /**
     * 导出trial_studentsM列表
     */
    @PreAuthorize("@ss.hasPermi('system:trial_studentsM:export')")
    @Log(title = "trial_studentsM", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TrialStudentsM trialStudentsM)
    {
        List<TrialStudentsM> list = trialStudentsMService.selectTrialStudentsMList(trialStudentsM);
        ExcelUtil<TrialStudentsM> util = new ExcelUtil<TrialStudentsM>(TrialStudentsM.class);
        util.exportExcel(response, list, "trial_studentsM数据");
    }

    /**
     * 获取trial_studentsM详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:trial_studentsM:query')")
    @GetMapping(value = "/{trialStudentId}")
    public AjaxResult getInfo(@PathVariable("trialStudentId") Long trialStudentId)
    {
        return success(trialStudentsMService.selectTrialStudentsMByTrialStudentId(trialStudentId));
    }

    /**
     * 新增trial_studentsM
     */
    @PreAuthorize("@ss.hasPermi('system:trial_studentsM:add')")
    @Log(title = "trial_studentsM", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TrialStudentsM trialStudentsM)
    {
        return toAjax(trialStudentsMService.insertTrialStudentsM(trialStudentsM));
    }

    /**
     * 修改trial_studentsM
     */
    @PreAuthorize("@ss.hasPermi('system:trial_studentsM:edit')")
    @Log(title = "trial_studentsM", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TrialStudentsM trialStudentsM)
    {
        return toAjax(trialStudentsMService.updateTrialStudentsM(trialStudentsM));
    }

    /**
     * 删除trial_studentsM
     */
    @PreAuthorize("@ss.hasPermi('system:trial_studentsM:remove')")
    @Log(title = "trial_studentsM", businessType = BusinessType.DELETE)
	@DeleteMapping("/{trialStudentIds}")
    public AjaxResult remove(@PathVariable Long[] trialStudentIds)
    {
        return toAjax(trialStudentsMService.deleteTrialStudentsMByTrialStudentIds(trialStudentIds));
    }
}
