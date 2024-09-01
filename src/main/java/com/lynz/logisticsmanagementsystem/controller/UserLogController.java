package com.lynz.logisticsmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lynz
 */
@Controller
public class UserLogController {
    @GetMapping(value = "/userLog")
    public String userLog() {
        return "userlog";
    }
}
