package cn.itsource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@MapperScan("cn.itsource.mapper") // cn.itsource.mapper就是你XxxMapper.java接口所在的包
public class Application {
public static void main(String[] args) {
    SpringApplication.run(Application.class,args);
}
}
