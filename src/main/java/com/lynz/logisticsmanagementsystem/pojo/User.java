package com.lynz.logisticsmanagementsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

// 用户表
public class User {
    private String userId; // 用户id
    private String username; //用户名
    private int password; // 用户密码
    private String email; // 用户邮箱
    private String phone; // 用户电话
    private String  createTime; // 创建时间
    private String  updateTime; // 更新时间
    private int isRoot; // 是否为管理员 1是 0否
}
