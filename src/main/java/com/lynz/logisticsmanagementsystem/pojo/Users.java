package com.lynz.logisticsmanagementsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author lynz
 */

@Data
@AllArgsConstructor
@NoArgsConstructor


public class Users implements UserDetails {
    /**
     * 用户id
     */
    private String userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 用户电话
     */
    private String phone;
    /**
     * 创建时间
     */
    private String  createTime;
    /**
     * 更新时间
     */
    private String  updateTime;
    /**
     * 是否为管理员 1是 0否
     */
    private boolean isRoot;
    /**
     * 账户是否可用 1可用，0不可
     */
    private boolean enabled;

    /**
     * 用来放回当前用户的角色/权限信息
     *
     */

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
    /**
     * 账户是否没有过期（true是未过期，false是过期）
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 账户是否没有被锁定（true是未被锁定，false是已锁定）
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 密码是否没有过期
     * 一些公司邮件系统密码要求半年修改一次，不改就无法登录
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 账户是否可用
     */
    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
