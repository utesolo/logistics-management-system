package com.lynz.logisticsmanagementsystem.mapper;

import com.lynz.logisticsmanagementsystem.pojo.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    Users selectUserByUsername(String username);
    /**
     * 查找密码
     * @param username 用户名称
     * @return 密码
     */
    String selectPasswordByUsername(String username);
    /**
     * 插入用户
     * @param users 用户信息
     */
    void insertUser(Users users);
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
     * @param users 用户信息
     * @param username 用户名
     */
    void updateUser(String username, Users users);

    /**
     * 查找全部用户
     * @return 全部用户
     */
    List<Users> findAll();

}
