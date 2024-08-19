package com.lynz.logisticsmanagementsystem.service;

import com.lynz.logisticsmanagementsystem.pojo.user;

/**
 * @author lynz
 */
public interface UserService {
    // 登录查询
    String loginService(String username, int password);
    // 注册查询
    String registerService(user user);
    // 管理员查询
    boolean checkRoot(String username);
    // 获取头像
    String getProfile(String username);
}
