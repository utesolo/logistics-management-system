package com.lynz.logisticsmanagementsystem.controller;

import com.lynz.logisticsmanagementsystem.pojo.User;
import com.lynz.logisticsmanagementsystem.service.serviceimpl.UserServiceImpl;
import com.lynz.logisticsmanagementsystem.util.Result;
import com.lynz.logisticsmanagementsystem.util.ResultUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@SuppressWarnings({"all"})
@Controller
@RestController
public class UserController {
    /**
     * 日志控制器
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserServiceImpl userServiceImpl;

    @RequestMapping("/user/api/login")
    public Result login(@RequestParam("username") String username, @RequestParam("password") int password, HttpSession session) {
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

    @RequestMapping(value = "/user/api/unlogin")
    public ModelAndView unlogin(HttpSession session, Model model) {
        session.removeAttribute("username");
        return new ModelAndView("redirect:/index");
    }

    @RequestMapping("/user/api/register")
    public Result register(@RequestBody User user) {
        Date date = new Date();
        UUID uuid = UUID.randomUUID();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String create_time = sdf.format(date);
        String update_time = sdf.format(date);
        user.setCreateTime(create_time);
        user.setUpdateTime(update_time);
        user.setIsRoot(0);
        LOGGER.info(user.toString());
        String msg = userServiceImpl.registerService(user);
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
    public Result update(@RequestBody User user,HttpSession session){

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //String username = session.getAttribute("username").toString();
        String username = user.getUsername();
        User userE = userServiceImpl.getUser(username);
        user.setUserId(userE.getUserId());
        user.setUsername(username);
        user.setUpdateTime(sdf.format(date));
        user.setCreateTime(userE.getCreateTime());
        user.setIsRoot(userE.getIsRoot());
        LOGGER.info(user.toString());

        userServiceImpl.updateUser(username, user);
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
