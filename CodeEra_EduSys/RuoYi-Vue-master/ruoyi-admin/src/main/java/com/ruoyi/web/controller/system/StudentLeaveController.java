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
import com.ruoyi.system.domain.StudentLeave;
import com.ruoyi.system.service.IStudentLeaveService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * student_leaveController
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
@RestController
@RequestMapping("/system/leave")
public class StudentLeaveController extends BaseController
{
    @Autowired
    private IStudentLeaveService studentLeaveService;

    /**
     * 查询student_leave列表
     */
    @PreAuthorize("@ss.hasPermi('system:leave:list')")
    @GetMapping("/list")
    public TableDataInfo list(StudentLeave studentLeave)
    {
        startPage();
        List<StudentLeave> list = studentLeaveService.selectStudentLeaveList(studentLeave);
        return getDataTable(list);
    }

    /**
     * 导出student_leave列表
     */
    @PreAuthorize("@ss.hasPermi('system:leave:export')")
    @Log(title = "student_leave", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StudentLeave studentLeave)
    {
        List<StudentLeave> list = studentLeaveService.selectStudentLeaveList(studentLeave);
        ExcelUtil<StudentLeave> util = new ExcelUtil<StudentLeave>(StudentLeave.class);
        util.exportExcel(response, list, "student_leave数据");
    }

    /**
     * 获取student_leave详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:leave:query')")
    @GetMapping(value = "/{leaveId}")
    public AjaxResult getInfo(@PathVariable("leaveId") Long leaveId)
    {
        return success(studentLeaveService.selectStudentLeaveByLeaveId(leaveId));
    }

//    /**
//     * 新增student_leave
//     */
//    @PreAuthorize("@ss.hasPermi('system:leave:add')")
//    @Log(title = "student_leave", businessType = BusinessType.INSERT)
//    @PostMapping
//    public AjaxResult add(@RequestBody StudentLeave studentLeave)
//    {
//        return toAjax(studentLeaveService.insertStudentLeave(studentLeave));
//    }
    @PreAuthorize("@ss.hasPermi('system:leave:add')")
    @Log(title = "student_leave", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StudentLeave studentLeave) {
        try {
            long newLeaveId = studentLeaveService.insertStudentLeave(studentLeave);
            return AjaxResult.success("申请成功",newLeaveId);
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 修改student_leave
     */
    @PreAuthorize("@ss.hasPermi('system:leave:edit')")
    @Log(title = "student_leave", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StudentLeave studentLeave)
    {
        return toAjax(studentLeaveService.updateStudentLeave(studentLeave));
    }

    /**
     * 删除student_leave
     */
    @PreAuthorize("@ss.hasPermi('system:leave:remove')")
    @Log(title = "student_leave", businessType = BusinessType.DELETE)
	@DeleteMapping("/{leaveIds}")
    public AjaxResult remove(@PathVariable Long[] leaveIds)
    {
        return toAjax(studentLeaveService.deleteStudentLeaveByLeaveIds(leaveIds));
    }
}
