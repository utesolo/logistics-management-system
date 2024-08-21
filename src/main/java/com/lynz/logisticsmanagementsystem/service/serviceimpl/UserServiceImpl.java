package com.lynz.logisticsmanagementsystem.service.serviceimpl;

import com.lynz.logisticsmanagementsystem.mapper.UserMapper;
import com.lynz.logisticsmanagementsystem.pojo.User;
import com.lynz.logisticsmanagementsystem.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public String loginService(String username, int password) {
        User user = userMapper.selectUserByUsername(username);
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
    public String registerService(User user) {
        User userE = userMapper.selectUserByUsername(user.getUsername());
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

    @Override
    public String updateUser(String username,User user) {
        userMapper.updateUser(username,user);
        return "success";
    }

    @Override
    public User getUser(String username) {
        return userMapper.selectUserByUsername(username);
    }
}
