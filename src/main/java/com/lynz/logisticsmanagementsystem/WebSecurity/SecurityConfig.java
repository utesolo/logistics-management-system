package com.lynz.logisticsmanagementsystem.WebSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author lynz
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig{

    private final UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public UserDetailsService userDetailsService() {
        return userDetailsService;
    }

    /**
     * 密码编码器，不解析密码
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Security详细配置
     *
     */
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        // anyRequest 请求需要授权
        // authenticated 请求需要认证（登录）
        http.authorizeHttpRequests(authorizeHttpRequests ->
                authorizeHttpRequests
                        .requestMatchers("/login","/","/index","register.html").permitAll()
                        .requestMatchers("/users/**").permitAll()
                        .requestMatchers("/static/**").permitAll()
                        .anyRequest()
                        .authenticated()
        );
        // loginPage 登录界面
        // loginProcessingUrl 登录url 过滤器
        http.formLogin(formLogin->
                formLogin
                    .loginPage("/login.html").permitAll()
                    .loginProcessingUrl("/login")
                    .defaultSuccessUrl("/")
        );

        http.csrf(csrf->csrf.disable());

        http.logout(logout->
                logout
                        .invalidateHttpSession(true)
                        .logoutSuccessUrl("/")
        );

        return http.build();
    }

}
