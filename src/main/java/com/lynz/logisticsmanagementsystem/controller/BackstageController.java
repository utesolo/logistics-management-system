package com.lynz.logisticsmanagementsystem.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lynz
 */

@RestController
public class BackstageController {

    @RequestMapping("/backstage")
    public ModelAndView backstage() {
        return new ModelAndView("backstage");
    }
}
