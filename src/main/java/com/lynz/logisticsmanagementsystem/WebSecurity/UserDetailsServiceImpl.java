package com.lynz.logisticsmanagementsystem.WebSecurity;

import com.lynz.logisticsmanagementsystem.mapper.UserMapper;
import com.lynz.logisticsmanagementsystem.pojo.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author lynz
 */
@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userMapper.selectUserByUsername(username);
        if (Objects.isNull(users)) {
            log.info("\n+未找到用户");
            throw new UsernameNotFoundException(username);
        }else {
            log.info("\n+{}",users.toString());
            return users;
        }


    }
}
