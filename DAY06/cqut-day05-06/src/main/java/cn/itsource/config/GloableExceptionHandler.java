package cn.itsource.config;
import cn.itsource.util.AjaxResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 全局异常处理器
 * controller层如果有异常，会自动被当前处理器捕获，
 * 根据异常封装Ajax里面错误提示信息
 *  spring 的  aop（感兴趣自己去了解）
 *
 spring中的两大核心：IOC
 AOP
 */
@ControllerAdvice
public class GloableExceptionHandler {
    /**
     * 如果controller中有某个方法执行抛异常了，
     * 这个异常会在这个全局异常处理器中处理
     * 处理完毕后响应给前端具体内容
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public AjaxResult handleException(Exception e){
        return AjaxResult.error().setMessage(e.getMessage());
    }
}
