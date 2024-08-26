package com.lynz.logisticsmanagementsystem.service;

import com.lynz.logisticsmanagementsystem.pojo.Users;

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
    String loginService(String username, String password);
    /**
     * 插入用户
     * @param users 用户信息
     * @return 注册是否成功
     */
    String registerService(Users users);
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
     * @param users 用户
     * @param username 用户名
     * @return 返回成功
     */
    String updateUser(String username, Users users);

    /**
     * 获取用户信息
     * @param username 用户名
     * @return 用户信息
     */
    Users getUser(String username);
}
