package cn.itsource.service.impl;
import cn.itsource.domain.Student;
import cn.itsource.domain.query.StudentQuery;
import cn.itsource.mapper.StudentMapper;
import cn.itsource.service.IStudentService;
import cn.itsource.util.AjaxResult;
import cn.itsource.util.PageParams;
import cn.itsource.util.PageResult;
import
        org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class StudentServiceImpl implements
        IStudentService {
    @Autowired
    private StudentMapper studentMapper;
    /**
     * 查询所有学生信息
     * @return
     */
    @Override
    public List<Student> listAll() {
        List<Student> students =
                studentMapper.selectAll();
        // 对所有的学生按照需求进行一些额外的运算
        return students;
    }
    /**
     * 分页查询
     * @param pageParams
     * @return
     */
    @Override
    public PageResult<Student> page(PageParams
                                            pageParams) {
        // 查询当前页的数据
        List<Student> students =
                studentMapper.selectPage(pageParams);
        // 查询总条目数
        Long total = studentMapper.selectCount();
        PageResult<Student> pageResult = new
                PageResult<>(students, total);
        return pageResult;
    }

    @Override
    public PageResult<Student> queryPage(StudentQuery query) {
        // 查询当前页的数据
        List<Student> students =
                studentMapper.queryPage(query);
        // 查询总条目数
        Long total = studentMapper.queryCount();
        PageResult<Student> pageResult = new
                PageResult<>(students, total);
        return pageResult;
    }

    @Override
    public Student selectById(Integer id) {
        // 对所有的学生按照需求进行一些额外的运算
        return studentMapper.selectById(id);
    }
    @Override
    public void insert(Student student) {
        studentMapper.insert(student);
    }

    @Override
    public void delete(Integer id) {
        studentMapper.delete(id);
    }
}
