package cn.itsource.mapper;
import cn.itsource.domain.User;
public interface UserMapper {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    User selectByUsername(String username);
}
