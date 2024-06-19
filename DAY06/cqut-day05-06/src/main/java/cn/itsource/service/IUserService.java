package cn.itsource.service;
import cn.itsource.domain.User;
public interface IUserService {
    /**
     * 登录
     * @param user
     * @return
     */
    String login(User user);
}
