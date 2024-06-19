package cn.itsource.controller;
 import cn.itsource.config.UserCache;
 import cn.itsource.domain.User;
 import cn.itsource.service.IUserService;
 import cn.itsource.util.AjaxResult;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.CrossOrigin;
 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.RequestBody;
 import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*") // 后端配置跨域访问 * 表示所有的域都可以访问
public class LoginController {

    @Autowired
    private IUserService userService;
    /**
     * 登录
     * @param user
     * @return
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody User user){
        String token = userService.login(user);
        return AjaxResult.success().setData(token).setMessage("登录成功!");
    }

    @PostMapping("/logout")
    public  AjaxResult logout(String token){
        UserCache.removeUser(token);
        return AjaxResult.success().setMessage("退出登录成功！");
    }
}
