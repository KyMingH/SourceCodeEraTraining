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
import com.ruoyi.system.domain.Studentcommlog;
import com.ruoyi.system.service.IStudentcommlogService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 沟通记录Controller
 * 
 * @author ttmingKy
 * @date 2024-06-20
 */
@RestController
@RequestMapping("/system/studentcommlog")
public class StudentcommlogController extends BaseController
{
    @Autowired
    private IStudentcommlogService studentcommlogService;

    /**
     * 查询沟通记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:studentcommlog:list')")
    @GetMapping("/list")
    public TableDataInfo list(Studentcommlog studentcommlog)
    {
        startPage();
        List<Studentcommlog> list = studentcommlogService.selectStudentcommlogList(studentcommlog);
        return getDataTable(list);
    }

    /**
     * 导出沟通记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:studentcommlog:export')")
    @Log(title = "沟通记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Studentcommlog studentcommlog)
    {
        List<Studentcommlog> list = studentcommlogService.selectStudentcommlogList(studentcommlog);
        ExcelUtil<Studentcommlog> util = new ExcelUtil<Studentcommlog>(Studentcommlog.class);
        util.exportExcel(response, list, "沟通记录数据");
    }

    /**
     * 获取沟通记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:studentcommlog:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(studentcommlogService.selectStudentcommlogById(id));
    }

    /**
     * 新增沟通记录
     */
    @PreAuthorize("@ss.hasPermi('system:studentcommlog:add')")
    @Log(title = "沟通记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Studentcommlog studentcommlog)
    {
        return toAjax(studentcommlogService.insertStudentcommlog(studentcommlog));
    }

    /**
     * 修改沟通记录
     */
    @PreAuthorize("@ss.hasPermi('system:studentcommlog:edit')")
    @Log(title = "沟通记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Studentcommlog studentcommlog)
    {
        return toAjax(studentcommlogService.updateStudentcommlog(studentcommlog));
    }

    /**
     * 删除沟通记录
     */
    @PreAuthorize("@ss.hasPermi('system:studentcommlog:remove')")
    @Log(title = "沟通记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(studentcommlogService.deleteStudentcommlogByIds(ids));
    }
}
