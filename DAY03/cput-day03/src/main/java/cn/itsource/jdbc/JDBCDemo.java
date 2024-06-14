package cn.itsource.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCDemo {

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
        PreparedStatement preparedStatement = connection.prepareStatement("insert into student(name,gender,birthday,telephone,degree,`desc`,state) " +
                "values (?,?,?,?,?,?,?)");
        preparedStatement.setString(1, "梁铭辉");
        preparedStatement.setString(2,"1");
        preparedStatement.setDate(3,new Date(2003 - 1900,3 - 1,22));
        preparedStatement.setString(4,"17323768413");
        preparedStatement.setString(5,"1");
        preparedStatement.setString(6,"这是chatgpt");
        preparedStatement.setString(7,"1");
        // 4、执：执行sql
        preparedStatement.execute();
        // 5、事：释放资源 先开的资源后释放
        preparedStatement.close();
        connection.close();

    }

}
