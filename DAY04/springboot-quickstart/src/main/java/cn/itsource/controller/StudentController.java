package cn.itsource.controller;
import cn.itsource.domain.Student;
import cn.itsource.mapper.StudentMapper;
import
        org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 * 参数的接收和处理
 */
@Controller
public class StudentController {
    @Autowired
    private StudentMapper studentMapper;

    /**
     * path中的参数的接收  {id} 路径变量
     *
     * @param id
     * @return
     * @PathVariable("id") 表示获取path中的这个变量 给方法
     * 的参数赋值
     * <p>
     * <p>
     * /student/100
     */
    @GetMapping("/student/{id}")
    @ResponseBody
    public Student getById(@PathVariable("id") Integer id) {
        Student student = studentMapper.selectById(id);
        return student;
    }

    /**
     * url?参数名=参数值&参数名=参数值
     * 直接让方法的参数名和url中的参数名保持一致就会接收到
     * 如果不能保持一致，但是又要接收某个请求参数
     * *
     *
     * @param id
     * @return
     */
    @GetMapping("/getStudent")
    @ResponseBody
    public Student getStudent(Integer
                                      id, @RequestParam(value = "gender", required = false) String
                                      sex) {
        Student student = studentMapper.selectOne(id, sex);
        return student;
    }

    /**
     * 重要指数：5颗星！！！！请求参数是一个json对象，这个json对象
     * 是在请求体中发送过来的
     * 接收：1|需要使用对象接收 2|使用@RequestBody
     *
     * @param student
     * @return
     */
    @PostMapping("/addStudent")
    @ResponseBody
    public String addStudent(@RequestBody Student student) {
        studentMapper.insert(student);
        return "操作成功!";
    }

    /**
     * 查询所有的学生信息
     *
     * @return
     */
    @GetMapping("/queryAll")
    @ResponseBody
    public List<Student> queryAll() {
        return studentMapper.selectAll();
    }
}