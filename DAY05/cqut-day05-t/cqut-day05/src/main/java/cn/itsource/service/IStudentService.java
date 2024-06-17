package cn.itsource.service;

import cn.itsource.domain.Student;

import java.util.List;

public interface IStudentService {
    /**
     * 查询所有学生信息
     * @return
     */
    List<Student> listAll();
}
