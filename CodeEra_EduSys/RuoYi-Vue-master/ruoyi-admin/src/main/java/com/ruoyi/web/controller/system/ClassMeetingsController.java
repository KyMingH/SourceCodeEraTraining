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
import com.ruoyi.system.domain.ClassMeetings;
import com.ruoyi.system.service.IClassMeetingsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * ClassMeetingsController
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
@RestController
@RequestMapping("/system/meetings")
public class ClassMeetingsController extends BaseController
{
    @Autowired
    private IClassMeetingsService classMeetingsService;

    /**
     * 查询ClassMeetings列表
     */
    @PreAuthorize("@ss.hasPermi('system:meetings:list')")
    @GetMapping("/list")
    public TableDataInfo list(ClassMeetings classMeetings)
    {
        startPage();
        List<ClassMeetings> list = classMeetingsService.selectClassMeetingsList(classMeetings);
        return getDataTable(list);
    }

    /**
     * 导出ClassMeetings列表
     */
    @PreAuthorize("@ss.hasPermi('system:meetings:export')")
    @Log(title = "ClassMeetings", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ClassMeetings classMeetings)
    {
        List<ClassMeetings> list = classMeetingsService.selectClassMeetingsList(classMeetings);
        ExcelUtil<ClassMeetings> util = new ExcelUtil<ClassMeetings>(ClassMeetings.class);
        util.exportExcel(response, list, "ClassMeetings数据");
    }

    /**
     * 获取ClassMeetings详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:meetings:query')")
    @GetMapping(value = "/{meetingId}")
    public AjaxResult getInfo(@PathVariable("meetingId") Long meetingId)
    {
        return success(classMeetingsService.selectClassMeetingsByMeetingId(meetingId));
    }

    /**
     * 新增ClassMeetings
     */
    @PreAuthorize("@ss.hasPermi('system:meetings:add')")
    @Log(title = "ClassMeetings", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ClassMeetings classMeetings)
    {
        return toAjax(classMeetingsService.insertClassMeetings(classMeetings));
    }

    /**
     * 修改ClassMeetings
     */
    @PreAuthorize("@ss.hasPermi('system:meetings:edit')")
    @Log(title = "ClassMeetings", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ClassMeetings classMeetings)
    {
        return toAjax(classMeetingsService.updateClassMeetings(classMeetings));
    }

    /**
     * 删除ClassMeetings
     */
    @PreAuthorize("@ss.hasPermi('system:meetings:remove')")
    @Log(title = "ClassMeetings", businessType = BusinessType.DELETE)
	@DeleteMapping("/{meetingIds}")
    public AjaxResult remove(@PathVariable Long[] meetingIds)
    {
        return toAjax(classMeetingsService.deleteClassMeetingsByMeetingIds(meetingIds));
    }
}
