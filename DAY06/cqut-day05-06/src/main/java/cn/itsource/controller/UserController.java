package cn.itsource.controller;

import cn.itsource.config.UserCache;
import cn.itsource.domain.User;
import cn.itsource.util.AjaxResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @GetMapping("info")
    public AjaxResult<User> getInfo(String token){
        User user = UserCache.getUser(token);
        return AjaxResult.success().setData(user);
    }

}
