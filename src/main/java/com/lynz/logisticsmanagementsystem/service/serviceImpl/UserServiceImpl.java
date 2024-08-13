package com.lynz.logisticsmanagementsystem.service.serviceImpl;

import com.lynz.logisticsmanagementsystem.mapper.UserMapper;
import com.lynz.logisticsmanagementsystem.pojo.User;
import com.lynz.logisticsmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public String loginService(String username, String password) {
        User user = userMapper.selectUserByUact(username);
        if (user != null) {
            String pwd = user.getPassword();
            if (pwd.equals(password)) {
                return "success";
            }else {
                return "fail";
            }
        }
        return "账号错误";
    }

    @Override
    public String registerService(User user) {
        User userE = userMapper.selectUserByUact(user.getUsername());
        if (userE == null) {
            if ("".equals(user.getPassword())) {
                return "not password";
            } else if ("".equals(user.getUsername())) {
                return "not username";
            }else{
                userMapper.insertUser(user);
                return "success";
            }
        }else {
            return "用户已经被注册";
        }

    }
}
