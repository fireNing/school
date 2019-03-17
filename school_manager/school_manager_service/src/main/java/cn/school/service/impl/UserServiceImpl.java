package cn.school.service.impl;

import cn.school.mapper.UserMapper;
import cn.school.pojo.User;
import cn.school.pojo.UserExample;
import cn.school.service.UserService;
import cn.school.utils.E3Result;
import cn.school.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.mail.MessagingException;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(String userId) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(userId);
        List<User> userList = userMapper.selectByExample(example);
        return userList.get(0);
    }

    /**
     * 用户注册
     * @param user
     */
    @Override
    public E3Result registerUser(User user) {
        //补全信息;
        user.setUid(UUID.randomUUID().toString().replaceAll("-", ""));
        //加密密码
        String MD5password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(MD5password);
        //code：0->未激活。1->激活状态
        user.setCode(0);
        user.setBirthday(null);
        user.setPost(null);
        user.setAge(null);
        user.setSex(null);
        user.setImage(null);
        //保存数据库
        userMapper.insert(user);
        //发送邮件激活。
        try {
            String eamilMsg = "<a href='http://localhost:8080/?#/active?activeCode="+user.getUid()+"'><font style='color:red'>恭喜你注册成功，点击下面连接激活帐号http://localhost:8080/?#/active?activeCode="+user.getUid()+"</font></a>";
            MailUtils.sendMail(user.getEmail(), eamilMsg);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return E3Result.ok();

    }

    /**
     * 判断用户信息是否已经被注册
     * @param username
     * @return
     */
    @Override
    public E3Result checkUsername(String username) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<User> userList = userMapper.selectByExample(example);
        if(userList.size()>0){
            return E3Result.build(500, "该昵称已经被使用");
        }
        return E3Result.ok();
    }

    /**
     * 判断用户邮箱是否已经被注册
     * @param email
     * @return
     */
    @Override
    public E3Result checkUserEmail(String email) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(email);
        List<User> userList = userMapper.selectByExample(example);
        if(userList.size()>0){
            return E3Result.build(500, "邮箱已经被注册");
        }
        return E3Result.ok();
    }

    /**
     * 判断用户手机号码是否已经被注册
     * @param telephone
     * @return
     */
    @Override
    public E3Result checkUserTelephone(String telephone) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andTelephoneEqualTo(telephone);
        List<User> userList = userMapper.selectByExample(example);
        if(userList.size()>0){
            return E3Result.build(500, "手机已经被注册");
        }
        return E3Result.ok();
    }

    /**
     * 用户登录
     * @param user
     * @return
     */
    @Override
    public E3Result login(User user,String UserType) {
        //密码加密判断
        String MD5password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(MD5password);
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if(UserType.equals("username")){
            //用户昵称登录
            criteria.andUsernameEqualTo(user.getUsername());
        }
        if(UserType.equals("email")){
            //邮箱登录
            criteria.andEmailEqualTo(user.getUsername());
        }
        if(UserType.equals("telephone")){
            //手机登录
            criteria.andTelephoneEqualTo(user.getUsername());
        }
        List<User> userList = userMapper.selectByExample(example);
        if(userList.size()>0 && userList.get(0).getCode() == 1){
            //用户名称存在，比对密码
            User existUser = userList.get(0);
            if(existUser.getPassword().equals(MD5password)){
                //密码比对成功
                existUser.setPassword(null);
                existUser.setEmail(null);
                existUser.setCode(null);
                existUser.setTelephone(null);
                existUser.setImage(null);
                //登录成功将用户信息存储到redis
//                jedisClient.set(existUser.getUid(),existUser.getUsername());
                return E3Result.ok(existUser);
            }
            return E3Result.build(500, "帐号或密码不正确");
        }
        return E3Result.build(500, "帐号或密码不正确");
    }

    /**
     * 帐号激活
     * @param userId
     * @return
     */
    @Override
    public E3Result activateUser(String userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        user.setCode(1);
        userMapper.updateByPrimaryKey(user);
        return E3Result.ok();
    }

    /**
     * 更具cookie中的token获取用户信息
     * @param token
     * @return
     */
    @Override
    public E3Result getUserByToken(String token) {
      /*  String userJson = jedisClient.get(token);
        User user = JsonUtils.jsonToPojo(userJson, User.class);*/
        return E3Result.ok(null);
    }
}
