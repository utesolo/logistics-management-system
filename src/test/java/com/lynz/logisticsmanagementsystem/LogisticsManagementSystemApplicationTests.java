package com.lynz.logisticsmanagementsystem;

import com.lynz.logisticsmanagementsystem.WebSecurity.UserDetailsServiceImpl;
import com.lynz.logisticsmanagementsystem.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Objects;

@SpringBootTest(classes = LogisticsManagementSystemApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LogisticsManagementSystemApplicationTests {
    /*@Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        String profile = "";

        System.out.println(Objects.requireNonNullElse(profile,"kua5"));
    }

    @Test
    void userselect(){
        System.out.println(userDetailsService.loadUserByUsername("test"));
    }

    @Test
    void password(){
        System.out.println("\n+test+{}"+passwordEncoder.encode(userMapper.selectPasswordByUsername("test")));
        System.out.println("\n+test+{}"+passwordEncoder.encode(userMapper.selectPasswordByUsername("root")));
    }*/
}
