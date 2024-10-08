package com.lynz.logisticsmanagementsystem.controller;

import com.lynz.logisticsmanagementsystem.pojo.Users;
import com.lynz.logisticsmanagementsystem.service.serviceimpl.UserServiceImpl;
import com.lynz.logisticsmanagementsystem.util.Result;
import com.lynz.logisticsmanagementsystem.util.ResultUtil;
import jakarta.servlet.http.HttpSession;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author lynz
 */


@SuppressWarnings({"all"})
@Controller
public class UserController {
    /**
     * 日志控制器
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);


    @Autowired
    UserServiceImpl userServiceImpl;


    @PostMapping("/users/api/register")
    @ResponseBody
    public Result register(@RequestBody Users users) {
        Date date = new Date();
        UUID uuid = UUID.randomUUID();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String create_time = sdf.format(date);
        String update_time = sdf.format(date);
        users.setCreateTime(create_time);
        users.setUpdateTime(update_time);
        users.setRoot(false);
        LOGGER.info(users.toString());
        String msg = userServiceImpl.registerService(users);
        LOGGER.info(msg);
        if (("success").equals(msg)) {
            return ResultUtil.success("注册成功");
        }else {
            return ResultUtil.error(msg);
        }
    }

    @RequestMapping(value = "/users/api/is_login",method = RequestMethod.GET)
    @ResponseBody
    public Result is_login(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && !(authentication instanceof AnonymousAuthenticationToken)) {
            // 用户已登录
            String currentPrincipalName = authentication.getName();
            return ResultUtil.online("在线");
        } else {
            // 用户未登录
            return ResultUtil.offline("不在线");
        }
    }


    @RequestMapping(value = "/users/api/getProfile")
    @ResponseBody
    @Before("logBeforeMethod")
    public String getProfile(@RequestParam String username){
        String profile = userServiceImpl.getProfile(username);
        LOGGER.info(profile);
        return profile;
    }

    @RequestMapping(value = "/users/api/update")
    @ResponseBody
    public Result update(@RequestBody Users users, HttpSession session){

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //String username = session.getAttribute("username").toString();
        String username = users.getUsername();
        Users usersE = userServiceImpl.getUser(username);
        users.setUserId(usersE.getUserId());
        users.setUsername(username);
        users.setUpdateTime(sdf.format(date));
        users.setCreateTime(usersE.getCreateTime());
        users.setRoot(usersE.isRoot());
        LOGGER.info(users.toString());

        userServiceImpl.updateUser(username, users);
        return ResultUtil.success("更改成功");
    }

    @RequestMapping(value = "/users/api/getname",method = RequestMethod.GET)
    @ResponseBody
    public Result getName(){
        Users usersE = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResultUtil.success(usersE.getUsername());
    }

    @RequestMapping(value = "/users/api/getId",method = RequestMethod.GET)
    @ResponseBody
    public Result getId(){
        Users usersE = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResultUtil.success(usersE.getUserId());
    }

    @GetMapping("/users/login")
    public String login(){
        return "login";
    }

    @GetMapping("/users/register")
    public String register(){
        return "register";
    }

    @GetMapping("/users/update")
    public String update(Model model){
        return "update";
    }
}
