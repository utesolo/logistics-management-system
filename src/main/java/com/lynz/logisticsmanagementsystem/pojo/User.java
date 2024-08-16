package com.lynz.logisticsmanagementsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lynz
 */

@Data
@AllArgsConstructor
@NoArgsConstructor

// 用户表
public class User {
    // 用户id
    private String userId;
    //用户名
    private String username;
    // 用户密码
    private int password;
    // 用户邮箱
    private String email;
    // 用户电话
    private String phone;
    // 创建时间
    private String  createTime;
    // 更新时间
    private String  updateTime;
    // 是否为管理员 1是 0否
    private int isRoot;
}
