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
import com.ruoyi.system.domain.ClassAttendance;
import com.ruoyi.system.service.IClassAttendanceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * class_attendanceController
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
@RestController
@RequestMapping("/system/attendance")
public class ClassAttendanceController extends BaseController
{
    @Autowired
    private IClassAttendanceService classAttendanceService;

    /**
     * 查询class_attendance列表
     */
    @PreAuthorize("@ss.hasPermi('system:attendance:list')")
    @GetMapping("/list")
    public TableDataInfo list(ClassAttendance classAttendance)
    {
        startPage();
        List<ClassAttendance> list = classAttendanceService.selectClassAttendanceList(classAttendance);
        return getDataTable(list);
    }

    /**
     * 导出class_attendance列表
     */
    @PreAuthorize("@ss.hasPermi('system:attendance:export')")
    @Log(title = "class_attendance", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ClassAttendance classAttendance)
    {
        List<ClassAttendance> list = classAttendanceService.selectClassAttendanceList(classAttendance);
        ExcelUtil<ClassAttendance> util = new ExcelUtil<ClassAttendance>(ClassAttendance.class);
        util.exportExcel(response, list, "class_attendance数据");
    }

    /**
     * 获取class_attendance详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:attendance:query')")
    @GetMapping(value = "/{attendanceId}")
    public AjaxResult getInfo(@PathVariable("attendanceId") Long attendanceId)
    {
        return success(classAttendanceService.selectClassAttendanceByAttendanceId(attendanceId));
    }

    /**
     * 新增class_attendance
     */
    @PreAuthorize("@ss.hasPermi('system:attendance:add')")
    @Log(title = "class_attendance", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ClassAttendance classAttendance)
    {
        return toAjax(classAttendanceService.insertClassAttendance(classAttendance));
    }

    /**
     * 修改class_attendance
     */
    @PreAuthorize("@ss.hasPermi('system:attendance:edit')")
    @Log(title = "class_attendance", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ClassAttendance classAttendance)
    {
        return toAjax(classAttendanceService.updateClassAttendance(classAttendance));
    }

    /**
     * 删除class_attendance
     */
    @PreAuthorize("@ss.hasPermi('system:attendance:remove')")
    @Log(title = "class_attendance", businessType = BusinessType.DELETE)
	@DeleteMapping("/{attendanceIds}")
    public AjaxResult remove(@PathVariable Long[] attendanceIds)
    {
        return toAjax(classAttendanceService.deleteClassAttendanceByAttendanceIds(attendanceIds));
    }
}
