package com.lynz.logisticsmanagementsystem.service;

import com.lynz.logisticsmanagementsystem.pojo.User;

/**
 * @author lynz
 */
public interface UserService {

    public String loginService(String username, int password);

    public String registerService(User user);

    public boolean checkRoot (String username);

}
