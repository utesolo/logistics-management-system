package com.lynz.logisticsmanagementsystem.service;

import com.lynz.logisticsmanagementsystem.pojo.User;

public interface UserService {

    public String loginService(String username, int password);

    public String registerService(User user);

}
