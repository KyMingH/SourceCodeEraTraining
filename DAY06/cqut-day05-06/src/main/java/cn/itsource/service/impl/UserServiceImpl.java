package cn.itsource.service.impl;
import cn.itsource.config.UserCache;
import cn.itsource.domain.User;
import cn.itsource.mapper.UserMapper;
import cn.itsource.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 登录
     * @param user
     * @return
     */
    @Override
    public String login(User user) {
        // 1、根据用户名查询用户信息，看用户是否存在
        User resultUser = userMapper.selectByUsername(user.getUsername());
        if(resultUser == null){
            throw new RuntimeException("用户名或密码错误!");
        }
        // 2、用户存在，把前端传过来的密码和数据库中的密码进行比较
        if(!user.getPassword().equals(resultUser.getPassword())){
            throw new RuntimeException("用户名或密码错误!");
        }
        // 登录成功!! 生成token
        // token和登录的用户信息之间要一一对应
        // 项目中一般存到redis中
        // JWT
        String token = UUID.randomUUID().toString();
        redisTemplate.opsForValue().set(token,resultUser,10, TimeUnit.SECONDS);
        UserCache.putUser(token,resultUser);
        return token;
    }
}
