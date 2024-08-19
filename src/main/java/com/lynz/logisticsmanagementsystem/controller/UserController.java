package com.lynz.logisticsmanagementsystem.controller;

import com.lynz.logisticsmanagementsystem.pojo.user;
import com.lynz.logisticsmanagementsystem.service.serviceImpl.UserServiceImpl;
import com.lynz.logisticsmanagementsystem.util.Result;
import com.lynz.logisticsmanagementsystem.util.ResultUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Before;
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
    public Result register(@RequestBody user user) {
        Date date = new Date();
        UUID uuid = UUID.randomUUID();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String create_time = sdf.format(date);
        String update_time = sdf.format(date);
        user.setCreateTime(create_time);
        user.setUpdateTime(update_time);
        user.setIsRoot(0);
        log.info(user.toString());
        String msg = userServiceImpl.registerService(user);
        log.info(msg);
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
        log.info(profile);
        return profile;
    }

    @GetMapping("/user/login")
    public ModelAndView login(Model model){
        return new ModelAndView("login");
    }

    @GetMapping("/user/register")
    public ModelAndView register(Model model){
        return new ModelAndView("register");
    }
}
