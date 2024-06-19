package cn.itsource.config;
import cn.itsource.domain.User;
import java.util.HashMap;
import java.util.Map;
public class UserCache {
    private static Map<String, User> userMap = new
            HashMap<>();
    public static void putUser(String token,User user){
        userMap.put(token,user);
    }
    public static User getUser(String token){
        return userMap.get(token);
    }
    public static void removeUser(String token){
        userMap.remove(token);
    }
}
