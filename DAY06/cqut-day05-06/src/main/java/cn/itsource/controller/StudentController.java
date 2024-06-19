package cn.itsource.controller;
import cn.itsource.domain.Student;
import cn.itsource.domain.query.StudentQuery;
import cn.itsource.service.IStudentService;
import cn.itsource.service.impl.StudentServiceImpl;
import cn.itsource.util.AjaxResult;
import cn.itsource.util.PageParams;
import cn.itsource.util.PageResult;
import
        org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
//@Controller
@RestController   // @Controller + @ResponseBody
@RequestMapping("/student")
@CrossOrigin("*") // 后端配置跨域访问 * 表示所有的域都可以访问
public class StudentController {
    @Autowired
    private IStudentService studentService;
    /**
     * 查询所有学生
     * @return
     */
    @GetMapping("/listAll")
    public AjaxResult<List<Student>> listAll(){
        List<Student> students =
                studentService.listAll();
        return AjaxResult.success().setData(students);
    }
    /**
     * 完整的分页
     * @param pageParams
     * @return
     */
    @PostMapping("/page")
    public AjaxResult<PageResult<Student>>
    page(@RequestBody PageParams pageParams){
        PageResult<Student> pageResult =
                studentService.page(pageParams);
        return
                AjaxResult.success().setData(pageResult);
    }
    @PostMapping("/querypage")
    public AjaxResult<PageResult<Student>>
    queryPage(@RequestBody StudentQuery query){
        PageResult<Student> pageResult =
                studentService.queryPage(query);
        return
                AjaxResult.success().setData(pageResult);
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable("id") Integer id) {
        return studentService.selectById(id);
    }

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student) {
        studentService.insert(student);
        return "插入成功!";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Integer id) {
        studentService.delete(id);
        return "删除成功";
    }
}
