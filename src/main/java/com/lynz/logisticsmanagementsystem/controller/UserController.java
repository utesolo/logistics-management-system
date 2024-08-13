package com.lynz.logisticsmanagementsystem.controller;

import com.lynz.logisticsmanagementsystem.pojo.User;
import com.lynz.logisticsmanagementsystem.service.serviceImpl.UserServiceImpl;
import com.lynz.logisticsmanagementsystem.util.Result;
import com.lynz.logisticsmanagementsystem.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings({"all"})
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;

    @RequestMapping("/login")
    public Result login(@RequestParam String username, @RequestParam String password) {
        String msg = userServiceImpl.loginService(username, password);
        if (("SUCCESS").equals(msg)) {
            return ResultUtil.success("登录成功");
        }else {
            return ResultUtil.error(msg);
        }
    }

    @RequestMapping("/register")
    public Result register(@RequestBody User user) {
        String msg = userServiceImpl.registerService(user);
        if (("SUCCESS").equals(msg)) {
            return ResultUtil.success("注册成功");
        }else {
            return ResultUtil.error(msg);
        }
    }
}
