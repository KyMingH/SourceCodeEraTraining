package cn.itsource.mybatis;

import cn.itsource.jdbc.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisDemo {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        InputStream inputStream;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession()) {
            // 使用 selectAll 查询所有学生
            List<Student> studentList = session.selectList("cn.itsource.jdbc.domain.Student.selectAll");
            System.out.println("查询所有学生: " + studentList);

            // 插入新学生
            Student newStudent = new Student(null, "唐花痴", "女", new Date(), "19522007917", "本科", "优秀学生", "在校");
            session.insert("cn.itsource.jdbc.domain.Student.insert", newStudent);
            session.commit(); // 提交事务

            studentList = session.selectList("cn.itsource.jdbc.domain.Student.selectAll");
            System.out.println("查询所有学生: " + studentList);

            // 根据 ID 查询学生
            Student student = session.selectOne("cn.itsource.jdbc.domain.Student.selectById", newStudent.getId());
            System.out.println("根据 ID 查询学生: " + student);

            // 更新学生信息
            student.setName("唐呆呆");
            session.update("cn.itsource.jdbc.domain.Student.updateById", student);
            session.commit(); // 提交事务

            studentList = session.selectList("cn.itsource.jdbc.domain.Student.selectAll");
            System.out.println("查询所有学生: " + studentList);

            // 根据 ID 删除学生
            session.delete("cn.itsource.jdbc.domain.Student.deleteById", newStudent.getId());
            session.commit(); // 提交事务

            studentList = session.selectList("cn.itsource.jdbc.domain.Student.selectAll");
            System.out.println("查询所有学生: " + studentList);
        }
    }
}