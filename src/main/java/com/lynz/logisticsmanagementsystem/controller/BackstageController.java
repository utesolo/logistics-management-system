package com.lynz.logisticsmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lynz
 */

@Controller
public class BackstageController {

    @RequestMapping("/backstage")
    public String backstage() {
        return "backstage";
    }
}
