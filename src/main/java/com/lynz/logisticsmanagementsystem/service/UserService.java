package com.lynz.logisticsmanagementsystem.service;

import com.lynz.logisticsmanagementsystem.pojo.User;

public interface UserService {

    public String loginService(String username, String password);

    public String registerService(User user);

}
