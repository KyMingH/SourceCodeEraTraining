package cn.itsource.mapper;

import cn.itsource.domain.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface StudentMapper {

    /**
     * 查询所有学生信息
     * @return
     */
    List<Student> selectAll();
}
