package com.lynz.logisticsmanagementsystem.mapper;

import com.lynz.logisticsmanagementsystem.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author lynz
 */
@Mapper
@Repository
public interface UserMapper {
    /**
     * 查找用户
     * @param username 用户名称
     * @return 用户
     */
    User selectUserByUsername(String username);
    /**
     * 查找密码
     * @param username 用户名称
     * @return 密码
     */
    String selectPasswordByUsername(String username);
    /**
     * 插入用户
     * @param user 用户信息
     */
    void insertUser(User user);
    /**
     * 确认是否为管理员
     * @param username 用户名称
     * @return 管理员权限
     */
    int checkRoot(String username);
    /**
     * 获取头像
     * @param username 用户名称
     * @return 头像地址
     */
    String getProfile(String username);

    /**
     * 更新用户信息
     * @param user 用户信息
     * @param username 用户名
     */
    void updateUser(String username,User user);

}
