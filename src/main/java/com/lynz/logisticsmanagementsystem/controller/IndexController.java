package com.lynz.logisticsmanagementsystem.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lynz
 */

@Controller
public class IndexController {

    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }

    @GetMapping("/")
    public String index() {
        // 重定向到主页
        return "redirect:/index";
    }

    @GetMapping("/layouts")
    public String layouts() {
        return "Layout";
    }

}
