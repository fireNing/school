package cn.school.interceptor;

import cn.school.pojo.User;
import cn.school.service.UserService;
import cn.school.utils.CookieUtils;
import cn.school.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AutoLoginIntercepter implements HandlerInterceptor {

    @Value(value = "${TOKEN}")
    private String TOKEN;

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断Cookid中是否有aotuLogin
        String value = CookieUtils.getCookieValue(request, TOKEN);
        if(StringUtils.isBlank(value)){
            //用户信息过期或没有登录放行
            response.sendRedirect("http://localhost:8080/?#/home");
            return false;
        }
        User user = JsonUtils.jsonToPojo(value, User.class);
        if(user ==null){
            //用户中不存在数据；
            response.sendRedirect("http://localhost:8080/?#/home");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
