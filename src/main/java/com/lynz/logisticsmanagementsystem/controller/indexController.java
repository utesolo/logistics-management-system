package com.lynz.logisticsmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class indexController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

}
