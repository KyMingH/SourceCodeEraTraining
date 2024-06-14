package cn.itsource.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class TestController {
    @GetMapping("/test")
    @ResponseBody
    public String test() {
        System.out.println("请求进来了.....");
        return "这是响应的数据";
    }
}