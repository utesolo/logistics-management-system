package com.lynz.logisticsmanagementsystem.service.serviceimpl;

import com.lynz.logisticsmanagementsystem.mapper.UserMapper;
import com.lynz.logisticsmanagementsystem.pojo.Users;
import com.lynz.logisticsmanagementsystem.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author lynz
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String loginService(String username, String password) {
        Users user = userMapper.selectUserByUsername(username);
        if (user != null) {
            String pwd = user.getPassword();
            if (Objects.equals(pwd, password)) {
                return "success";
            }else {
                return "fail";
            }
        }
        return "账号错误";
    }

    @Override
    public String registerService(Users user) {
        Users userE = userMapper.selectUserByUsername(user.getUsername());
        if (userE == null) {
            if (Objects.isNull(user.getPassword())) {
                return "not password";
            } else if ("".equals(user.getUsername())) {
                return "not username";
            } else if ("".equals(user.getEmail())) {
                return "not email";
            } else if ("".equals(user.getPhone())) {
                return "not phone";
            } else{
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                log.info("\n+{}",user.toString());
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
    public String updateUser(String username,Users user) {
        userMapper.updateUser(username,user);
        return "success";
    }

    @Override
    public Users getUser(String username) {
        return userMapper.selectUserByUsername(username);
    }
}
