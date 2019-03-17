package cn.school.controller;

import cn.school.pojo.User;
import cn.school.service.UserService;
import cn.school.utils.CookieUtils;
import cn.school.utils.E3Result;
import cn.school.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Value(value = "${TOKEN}")
    private String TOKEN;
    @Value(value = "${COOKIE_TIME}")
    private Integer COOKIE_TIME;

    @RequestMapping("/user/{userId}")
    @ResponseBody
    public User getUserById(@PathVariable String userId){
        return userService.getUserById(userId);
    }

    /**
     * 判断用户名是否已经被注册
     * @return
     */
    @RequestMapping("/checkUsername")
    @ResponseBody
    public E3Result checkUserName(String username){
        if(StringUtils.isNotBlank(username)){
            return userService.checkUsername(username);
        }
        return E3Result.build(500, "用户名不能为空");
    }
    /**
     * 判断邮箱是否已经被注册
     * @return
     */
    @RequestMapping("/checkEmail")
    @ResponseBody
    public E3Result checkUserEmail(String email){
        if(StringUtils.isNotBlank(email)){
            return userService.checkUserEmail(email);
        }
        return E3Result.build(500, "邮箱不能为空");
    }
    /**
     * 判断用户手机是否已经被注册
     * @return
     */
    @RequestMapping("/checkTelephone")
    @ResponseBody
    public E3Result checkUserTelephone(String telephone){
        if(StringUtils.isNotBlank(telephone)){
            return userService.checkUserTelephone(telephone);
        }
        return E3Result.build(500, "手机号码不能为空");
    }



    /**
     * 用户注册
     * @param user
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public E3Result registerUser(User user){
        E3Result e3Result = userService.registerUser(user);
        if(e3Result.getStatus()==200){
            //用户册成功跳转到登录页面
            return E3Result.ok();
        }
        //用户注册失败，跳回注册页面。
        return E3Result.build(500, "注册失败");
    }

    @RequestMapping("/active")
    @ResponseBody
    public E3Result activateAccount(String activeCode){
        return userService.activateUser(activeCode);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public E3Result loginUser(User user,String UserType ,String autoLogin, HttpServletRequest request, HttpServletResponse response){
        String username = (String) request.getAttribute("user");
        if(StringUtils.isNotBlank(username)){
            //已经自动登录情况下
            return E3Result.ok(username);
        }
        E3Result result = userService.login(user,UserType);
        if(autoLogin.equals("1")){
            //选择自动登录
            String toJson = JsonUtils.objectToJson(result.getData());
            CookieUtils.setCookie(request, response, TOKEN, toJson,COOKIE_TIME);
        }
        return result;
    }

    @RequestMapping(value = "/user/token/{token}")
    @ResponseBody
    public E3Result getUserByToken(@PathVariable String token,HttpServletRequest request,HttpServletResponse response ){
        if(StringUtils.isBlank(token)){
            return E3Result.ok();
        }
        E3Result e3Result = userService.getUserByToken(token);
        return e3Result;
    }

    @RequestMapping("/loginOut")
    @ResponseBody
    public E3Result outLoginUser(User user){
        user.setUid(null);
        user.setUsername(null);
        return E3Result.ok(user);
    }


}
