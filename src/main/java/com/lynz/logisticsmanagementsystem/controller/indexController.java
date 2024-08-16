package com.lynz.logisticsmanagementsystem.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lynz
 */

@Controller
public class indexController {

    @GetMapping("/")
    public String index() {
        // 重定向到主页
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String home() {
        // 返回主页视图
        return "index";
    }

    @GetMapping("/layouts")
    public String layouts() {
        return "Layout";
    }

}
