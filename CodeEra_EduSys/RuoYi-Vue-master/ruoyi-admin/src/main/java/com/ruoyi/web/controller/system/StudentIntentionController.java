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
import com.ruoyi.system.domain.StudentIntention;
import com.ruoyi.system.service.IStudentIntentionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * student_intentionController
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
@RestController
@RequestMapping("/system/intention")
public class StudentIntentionController extends BaseController
{
    @Autowired
    private IStudentIntentionService studentIntentionService;

    /**
     * 查询student_intention列表
     */
    @PreAuthorize("@ss.hasPermi('system:intention:list')")
    @GetMapping("/list")
    public TableDataInfo list(StudentIntention studentIntention)
    {
        startPage();
        List<StudentIntention> list = studentIntentionService.selectStudentIntentionList(studentIntention);
        return getDataTable(list);
    }

    /**
     * 导出student_intention列表
     */
    @PreAuthorize("@ss.hasPermi('system:intention:export')")
    @Log(title = "student_intention", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StudentIntention studentIntention)
    {
        List<StudentIntention> list = studentIntentionService.selectStudentIntentionList(studentIntention);
        ExcelUtil<StudentIntention> util = new ExcelUtil<StudentIntention>(StudentIntention.class);
        util.exportExcel(response, list, "student_intention数据");
    }

    /**
     * 获取student_intention详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:intention:query')")
    @GetMapping(value = "/{recordId}")
    public AjaxResult getInfo(@PathVariable("recordId") Long recordId)
    {
        return success(studentIntentionService.selectStudentIntentionByRecordId(recordId));
    }

    /**
     * 新增student_intention
     */
    @PreAuthorize("@ss.hasPermi('system:intention:add')")
    @Log(title = "student_intention", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StudentIntention studentIntention)
    {
        return toAjax(studentIntentionService.insertStudentIntention(studentIntention));
    }

    /**
     * 修改student_intention
     */
    @PreAuthorize("@ss.hasPermi('system:intention:edit')")
    @Log(title = "student_intention", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StudentIntention studentIntention)
    {
        return toAjax(studentIntentionService.updateStudentIntention(studentIntention));
    }

    /**
     * 删除student_intention
     */
    @PreAuthorize("@ss.hasPermi('system:intention:remove')")
    @Log(title = "student_intention", businessType = BusinessType.DELETE)
	@DeleteMapping("/{recordIds}")
    public AjaxResult remove(@PathVariable Long[] recordIds)
    {
        return toAjax(studentIntentionService.deleteStudentIntentionByRecordIds(recordIds));
    }
}
