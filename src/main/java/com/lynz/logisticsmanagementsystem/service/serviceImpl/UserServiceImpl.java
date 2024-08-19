package com.lynz.logisticsmanagementsystem.service.serviceImpl;

import com.lynz.logisticsmanagementsystem.mapper.UserMapper;
import com.lynz.logisticsmanagementsystem.pojo.user;
import com.lynz.logisticsmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public String loginService(String username, int password) {
        user user = userMapper.selectUserByUsername(username);
        if (user != null) {
            int pwd = user.getPassword();
            if (pwd == password) {
                return "success";
            }else {
                return "fail";
            }
        }
        return "账号错误";
    }

    @Override
    public String registerService(user user) {
        com.lynz.logisticsmanagementsystem.pojo.user userE = userMapper.selectUserByUsername(user.getUsername());
        if (userE == null) {
            if (user.getPassword() == 0) {
                return "not password";
            } else if ("".equals(user.getUsername())) {
                return "not username";
            } else if ("".equals(user.getEmail())) {
                return "not email";
            } else if ("".equals(user.getPhone())) {
                return "not phone";
            } else{
                userMapper.insertUser(user);
                return "success";
            }
        }else {
            return "用户已经被注册";
        }
    }

    @Override
    public boolean checkRoot(String username) {
        int root = userMapper.checkRoot(username);
        if (root == 0) {
            return false;
        }else {
            return true;
        }
    }

    @Override
    public String getProfile(String username) {
        String profile = userMapper.getProfile(username);

        if (profile == null) {
            return "kua5";
        }else {
            return profile;
        }
    }
}
