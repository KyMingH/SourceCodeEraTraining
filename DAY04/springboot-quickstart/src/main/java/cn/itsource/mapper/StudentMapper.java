package cn.itsource.mapper;

import cn.itsource.domain.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> selectAll();

    Student selectById(Integer id);

    Student selectOne(Integer id, String sex);

    void insert(Student student);
}
