package cn.school.service;

import cn.school.pojo.User;
import cn.school.utils.E3Result;

public interface UserService {

    public User getUserById(String userId);
    //用户注册;
    public E3Result registerUser(User user);
    //判断用户名是否已经被注册;
    public E3Result checkUsername(String username);
    //判断用户邮箱是否已经被注册
    public E3Result checkUserEmail(String email);
    //判断用户手机是否已经被注册
    public E3Result checkUserTelephone(String telephone);
    //用户登录
    public E3Result login(User user, String UserType);
    //激活帐号
    public E3Result activateUser(String userId);
    //单点登录根据cookie中的token获取用户信息
    public E3Result getUserByToken(String token);

}
