package com.lynz.logisticsmanagementsystem.service;

import com.lynz.logisticsmanagementsystem.pojo.User;

/**
 * @author lynz
 */
public interface UserService {
    /**
     * 登录用户
     * @param username 用户名称
     * @param password 密码
     * @return 用户
     */
    String loginService(String username, int password);
    /**
     * 插入用户
     * @param user 用户信息
     * @return 注册是否成功
     */
    String registerService(User user);
    /**
     * 确认是否为管理员
     * @param username 用户名称
     * @return 管理员权限
     */
    boolean checkRoot(String username);
    /**
     * 获取头像
     * @param username 用户名称
     * @return 头像地址
     */
    String getProfile(String username);

    /**
     * 更新用户信息
     * @param user 用户
     * @param username 用户名
     * @return 返回成功
     */
    String updateUser(String username,User user);

    /**
     * 获取用户信息
     * @param username 用户名
     * @return 用户信息
     */
    User getUser(String username);
}
