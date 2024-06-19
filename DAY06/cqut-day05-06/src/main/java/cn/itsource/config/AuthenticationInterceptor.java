package cn.itsource.config;

import cn.itsource.util.AjaxResult;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自动创建交给spring管理
 */
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
    /**
     * 访问接口之前做拦截
     * 每次请求的时候把登录的token带过来我来判断你是否登录过
     * 放在请求的那里可以带过来
     *
     请求参数、请求头   X-TOKEN
     * @param request current HTTP request
     * @param response current HTTP response
     * @param handler chosen handler to execute, for type
    and/or instance evaluation
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String method = request.getMethod();
        if("OPTIONS".equalsIgnoreCase(method)){
            return true;
        }
        String token = request.getHeader("X-TOKEN");
        if(UserCache.exists(token)){
            return true;
        }
        // 失败，响应
        AjaxResult ajaxResult = AjaxResult.error().setCode(402).setMessage("请先登录！");
        response.getWriter().println(JSONObject.toJSONString(ajaxResult));
        return false;
    }
}
