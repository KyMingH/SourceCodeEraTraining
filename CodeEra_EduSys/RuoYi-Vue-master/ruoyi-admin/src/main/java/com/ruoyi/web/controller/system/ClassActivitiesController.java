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
import com.ruoyi.system.domain.ClassActivities;
import com.ruoyi.system.service.IClassActivitiesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * class_activitiesController
 * 
 * @author ttKymingH
 * @date 2024-06-24
 */
@RestController
@RequestMapping("/system/activities")
public class ClassActivitiesController extends BaseController
{
    @Autowired
    private IClassActivitiesService classActivitiesService;

    /**
     * 查询class_activities列表
     */
    @PreAuthorize("@ss.hasPermi('system:activities:list')")
    @GetMapping("/list")
    public TableDataInfo list(ClassActivities classActivities)
    {
        startPage();
        List<ClassActivities> list = classActivitiesService.selectClassActivitiesList(classActivities);
        return getDataTable(list);
    }

    /**
     * 导出class_activities列表
     */
    @PreAuthorize("@ss.hasPermi('system:activities:export')")
    @Log(title = "class_activities", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ClassActivities classActivities)
    {
        List<ClassActivities> list = classActivitiesService.selectClassActivitiesList(classActivities);
        ExcelUtil<ClassActivities> util = new ExcelUtil<ClassActivities>(ClassActivities.class);
        util.exportExcel(response, list, "class_activities数据");
    }

    /**
     * 获取class_activities详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:activities:query')")
    @GetMapping(value = "/{activityId}")
    public AjaxResult getInfo(@PathVariable("activityId") Long activityId)
    {
        return success(classActivitiesService.selectClassActivitiesByActivityId(activityId));
    }

    /**
     * 新增class_activities
     */
    @PreAuthorize("@ss.hasPermi('system:activities:add')")
    @Log(title = "class_activities", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ClassActivities classActivities)
    {
        return toAjax(classActivitiesService.insertClassActivities(classActivities));
    }

    /**
     * 修改class_activities
     */
    @PreAuthorize("@ss.hasPermi('system:activities:edit')")
    @Log(title = "class_activities", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ClassActivities classActivities)
    {
        return toAjax(classActivitiesService.updateClassActivities(classActivities));
    }

    /**
     * 删除class_activities
     */
    @PreAuthorize("@ss.hasPermi('system:activities:remove')")
    @Log(title = "class_activities", businessType = BusinessType.DELETE)
	@DeleteMapping("/{activityIds}")
    public AjaxResult remove(@PathVariable Long[] activityIds)
    {
        return toAjax(classActivitiesService.deleteClassActivitiesByActivityIds(activityIds));
    }
}
