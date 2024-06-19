package cn.itsource;
import cn.itsource.domain.User;
import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import java.io.*;
public class JedisDemo {
    public static void main(String[] args) throws Exception{
        Jedis jedis = new Jedis("127.0.0.1",6379);
//        jedis.auth("123456");
        // JAVA对象存储到redis中
//        User user = new User(1L, "amdin", "admin");
//        ByteArrayOutputStream outputStream = new
//                ByteArrayOutputStream();
//        ObjectOutputStream objectOutputStream = new
//                ObjectOutputStream(outputStream);
//        objectOutputStream.writeObject(user);
//        byte[] bytes = outputStream.toByteArray();
//        jedis.set("student:1".getBytes(),bytes);
//        objectOutputStream.close();
        // 把之前存储到redis中的java对象反序列化出来
        byte[] bytes =
                jedis.get("student:1".getBytes());
        ByteArrayInputStream byteArrayInputStream = new
                ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream = new
                ObjectInputStream(byteArrayInputStream);
        User user = (User)
                objectInputStream.readObject();
        System.out.println(user);
        byteArrayInputStream.close();
        jedis.close();
    }
    private static void quickStart(){
        Jedis jedis = new Jedis("127.0.0.1",6379);
//        jedis.auth("123456");
//        发送redis命令
//        jedis.set("name","张三");
        String name = jedis.get("name");
        System.out.println(name);
        jedis.close();
    }
    /**
     * java对象存储到redis中
     */
    private static void toJSON(){
        Jedis jedis = new Jedis("127.0.0.1",6379);
//        jedis.auth("123456");
        // JAVA对象存储到redis中
//        User user = new User(1L, "amdin", "admin");
        // 1、将Java对象转为JSON字符串
//        String userJSON =
//                JSONObject.toJSONString(user);
        // 扩展一点：key的命名方式，key可以分组，第一级和第二级可以使用：隔开
//        jedis.set("user:1",userJSON);
        // 从redis中读取JSON数据转为java对象
        String userJSON = jedis.get("user:1");
        User user =
                JSONObject.parseObject(userJSON,User.class);
        System.out.println(user);
        jedis.close();
    }
}