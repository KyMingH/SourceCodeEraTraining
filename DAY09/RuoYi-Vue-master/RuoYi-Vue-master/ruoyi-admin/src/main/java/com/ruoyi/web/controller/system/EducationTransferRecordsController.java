package com.ruoyi.web.controller.system;

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
import com.ruoyi.system.domain.EducationTransferRecords;
import com.ruoyi.system.service.IEducationTransferRecordsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 记录转班记录Controller
 * 
 * @author ttMingKy
 * @date 2024-06-21
 */
@RestController
@RequestMapping("/system/records")
public class EducationTransferRecordsController extends BaseController
{
    @Autowired
    private IEducationTransferRecordsService educationTransferRecordsService;

    /**
     * 查询记录转班记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:records:list')")
    @GetMapping("/list")
    public TableDataInfo list(EducationTransferRecords educationTransferRecords)
    {
        startPage();
        List<EducationTransferRecords> list = educationTransferRecordsService.selectEducationTransferRecordsList(educationTransferRecords);
        return getDataTable(list);
    }

    /**
     * 导出记录转班记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:records:export')")
    @Log(title = "记录转班记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EducationTransferRecords educationTransferRecords)
    {
        List<EducationTransferRecords> list = educationTransferRecordsService.selectEducationTransferRecordsList(educationTransferRecords);
        ExcelUtil<EducationTransferRecords> util = new ExcelUtil<EducationTransferRecords>(EducationTransferRecords.class);
        util.exportExcel(response, list, "记录转班记录数据");
    }

    /**
     * 获取记录转班记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:records:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(educationTransferRecordsService.selectEducationTransferRecordsById(id));
    }

    /**
     * 新增记录转班记录
     */
    @PreAuthorize("@ss.hasPermi('system:records:add')")
    @Log(title = "记录转班记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EducationTransferRecords educationTransferRecords)
    {
        return toAjax(educationTransferRecordsService.insertEducationTransferRecords(educationTransferRecords));
    }

    /**
     * 修改记录转班记录
     */
    @PreAuthorize("@ss.hasPermi('system:records:edit')")
    @Log(title = "记录转班记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EducationTransferRecords educationTransferRecords)
    {
        return toAjax(educationTransferRecordsService.updateEducationTransferRecords(educationTransferRecords));
    }

    /**
     * 删除记录转班记录
     */
    @PreAuthorize("@ss.hasPermi('system:records:remove')")
    @Log(title = "记录转班记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(educationTransferRecordsService.deleteEducationTransferRecordsByIds(ids));
    }
}
