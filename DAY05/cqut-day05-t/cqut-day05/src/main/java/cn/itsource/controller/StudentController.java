package cn.itsource.controller;

import cn.itsource.domain.Student;
import cn.itsource.service.IStudentService;
import cn.itsource.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private IStudentService studentService;

    /**
     * 查询所有学生
     * @return
     */
    @GetMapping("/student/listAll")
    @ResponseBody
    public List<Student> listAll(){
        return studentService.listAll();
    }

}
