package cn.itsource.mapper;
import cn.itsource.domain.Student;
import cn.itsource.domain.query.StudentQuery;
import cn.itsource.util.PageParams;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface StudentMapper {
    /**
     * 查询所有学生信息
     * @return
     */
    List<Student> selectAll();

    /**
     * 分页查询
     * @param pageParams
     * @return
     */
    List<Student> selectPage(PageParams pageParams);

    /**
     * 分页条件查询
     * @param query
     * @return
     */
    List<Student> queryPage(StudentQuery query);

    /**
     * 查询总条目数
     * @return
     */
    Long selectCount();

    Student selectById(Integer id);

    void insert(Student student);

    void delete(Integer id);

    /**
     * 条件查询总数
     * @param query
     * @return
     */
    Long queryCount();

}