package cn.itsource.service.impl;

import cn.itsource.domain.Student;
import cn.itsource.mapper.StudentMapper;
import cn.itsource.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 查询所有学生信息
     * @return
     */
    @Override
    public List<Student> listAll() {
        List<Student> students = studentMapper.selectAll();
        // 对所有的学生按照需求进行一些额外的运算
        return students;
    }
}
