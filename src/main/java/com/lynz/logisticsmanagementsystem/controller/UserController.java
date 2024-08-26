package com.lynz.logisticsmanagementsystem.controller;

import com.lynz.logisticsmanagementsystem.pojo.Users;
import com.lynz.logisticsmanagementsystem.service.serviceimpl.UserServiceImpl;
import com.lynz.logisticsmanagementsystem.util.Result;
import com.lynz.logisticsmanagementsystem.util.ResultUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }
    @Autowired
    UserServiceImpl userServiceImpl;

    @RequestMapping("/user/api/login")
    public Result login(@RequestParam("username") String username, @RequestParam("password") String  password, HttpSession session) {
        String msg = userServiceImpl.loginService(username, password);
        boolean checkRoot = userServiceImpl.checkRoot(username);
        if (("success").equals(msg)) {
            session.setAttribute("username", username);
            if (checkRoot) {
                return ResultUtil.success("root");
            }
            else {
                return ResultUtil.success("登录成功");
            }
        }else {
            return ResultUtil.error(msg);
        }
    }

    @GetMapping(value = "/user/api/unlogin")
    public String unlogin(HttpSession session) {
        session.removeAttribute("username");
        return "redirect:/index";
    }

    @PostMapping("/user/api/register")
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

    @RequestMapping(value = "/user/api/is_login",method = RequestMethod.GET)
    public Result is_login(HttpServletRequest request){
        HttpSession session = request.getSession();
        if (session.getAttribute("username") != null) {
            String username = session.getAttribute("username").toString();
            if ((username != null) && (!username.equals(""))) {
                return ResultUtil.online("在线");
            }else return ResultUtil.offline("不在线");
        }else {
            return ResultUtil.offline("不在线");
        }
    }


    @RequestMapping(value = "/user/api/getProfile")
    @Before("logBeforeMethod")
    public String getProfile(@RequestParam String username){
        String profile = userServiceImpl.getProfile(username);
        LOGGER.info(profile);
        return profile;
    }

    @RequestMapping(value = "/user/api/update")
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

    @RequestMapping("/user/api/getname")
    public Result getName(HttpSession session){
        String username = session.getAttribute("username").toString();
        return ResultUtil.success(username);
    }

    @GetMapping("/user/login")
    public ModelAndView login(Model model){
        return new ModelAndView("login");
    }

    @GetMapping("/user/register")
    public ModelAndView register(Model model){
        return new ModelAndView("register");
    }

    @GetMapping("/user/update")
    public ModelAndView update(Model model){
        return new ModelAndView("update");
    }
}
