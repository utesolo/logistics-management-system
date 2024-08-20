package com.lynz.logisticsmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lynz
 */
@Controller
public class WebSocketController {
    @GetMapping("/websocket")
    public String websocket() {
        return "websocket";
    }
}
