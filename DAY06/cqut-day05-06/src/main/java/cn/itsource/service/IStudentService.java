package cn.itsource.service;
import cn.itsource.domain.Student;
import cn.itsource.domain.query.StudentQuery;
import cn.itsource.util.AjaxResult;
import cn.itsource.util.PageParams;
import cn.itsource.util.PageResult;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
public interface IStudentService {
    /**
     * 查询所有学生信息
     * @return
     */
    List<Student> listAll();

    /**
     * 分页查询
     * @param pageParams
     * @return
     */
    PageResult<Student> page(PageParams pageParams);

    Student selectById(Integer id);

    void insert(Student student);

    void delete(Integer id);

    PageResult<Student> queryPage(StudentQuery query);
}