package cn.itsource.jdbc;

import cn.itsource.jdbc.domain.Student;

import java.sql.*;

/**
 * JDBC的劣势：
 *  1、 贾琏欲执事重复的代码重复写
 *  2、sql硬编码到了代码中，不好维护
 *  3、查询结果不好解析
 *
 *  使用框架 - mybatis
 */
public class JDBCSelectDemo {

    public static void main(String[] args) throws Exception {

        // 贾琏欲执事
        // 1、贾：加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2、琏：创建数据库链接
        String url = "jdbc:mysql://localhost:3306/cqut?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8";
        String username = "root";
        String password = "112520ki";
        Connection connection = DriverManager.getConnection(url, username, password);
        // 3、预：创建预编译sql语句对象
        PreparedStatement preparedStatement = connection.prepareStatement("select * from student");
        // 4、执：执行sql
        ResultSet resultSet = preparedStatement.executeQuery();
        // 如果是查询，需要解析结果集
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String gender = resultSet.getString("gender");
            Date birthday = resultSet.getDate("birthday");
            String telephone = resultSet.getString("telephone");
            String degree = resultSet.getString("degree");
            String desc = resultSet.getString("desc");
            String state = resultSet.getString("state");
            Student student = new Student(id, name, gender, birthday, telephone, degree, desc, state);
            System.out.println(student);
        }

        // 5、事：释放资源 先开的资源后释放
        resultSet.close();
        preparedStatement.close();
        connection.close();

    }

}
