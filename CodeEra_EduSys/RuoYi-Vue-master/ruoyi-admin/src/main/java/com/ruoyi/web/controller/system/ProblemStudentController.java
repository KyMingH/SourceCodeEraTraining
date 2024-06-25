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
import com.ruoyi.system.domain.ProblemStudent;
import com.ruoyi.system.service.IProblemStudentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * problem_studentController
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
@RestController
@RequestMapping("/system/student")
public class ProblemStudentController extends BaseController
{
    @Autowired
    private IProblemStudentService problemStudentService;

    /**
     * 查询problem_student列表
     */
    @PreAuthorize("@ss.hasPermi('system:student:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProblemStudent problemStudent)
    {
        startPage();
        List<ProblemStudent> list = problemStudentService.selectProblemStudentList(problemStudent);
        return getDataTable(list);
    }

    /**
     * 导出problem_student列表
     */
    @PreAuthorize("@ss.hasPermi('system:student:export')")
    @Log(title = "problem_student", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProblemStudent problemStudent)
    {
        List<ProblemStudent> list = problemStudentService.selectProblemStudentList(problemStudent);
        ExcelUtil<ProblemStudent> util = new ExcelUtil<ProblemStudent>(ProblemStudent.class);
        util.exportExcel(response, list, "problem_student数据");
    }

    /**
     * 获取problem_student详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:student:query')")
    @GetMapping(value = "/{recordId}")
    public AjaxResult getInfo(@PathVariable("recordId") Long recordId)
    {
        return success(problemStudentService.selectProblemStudentByRecordId(recordId));
    }

    /**
     * 新增problem_student
     */
    @PreAuthorize("@ss.hasPermi('system:student:add')")
    @Log(title = "problem_student", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProblemStudent problemStudent)
    {
        return toAjax(problemStudentService.insertProblemStudent(problemStudent));
    }

    /**
     * 修改problem_student
     */
    @PreAuthorize("@ss.hasPermi('system:student:edit')")
    @Log(title = "problem_student", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProblemStudent problemStudent)
    {
        return toAjax(problemStudentService.updateProblemStudent(problemStudent));
    }

    /**
     * 删除problem_student
     */
    @PreAuthorize("@ss.hasPermi('system:student:remove')")
    @Log(title = "problem_student", businessType = BusinessType.DELETE)
	@DeleteMapping("/{recordIds}")
    public AjaxResult remove(@PathVariable Long[] recordIds)
    {
        return toAjax(problemStudentService.deleteProblemStudentByRecordIds(recordIds));
    }
}
