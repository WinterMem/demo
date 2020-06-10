package com.pch.user.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.pch.user.service.UserService;

/**
 * @Author: pch
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class UserSecurityConfig extends SecurityConfig {

    @Autowired
    private UserService userService;

    @Bean
    public UserDetailsService userDetailsService() {
//        获取登录用户信息
        return username -> userService.loadUserByUsername(username);
    }


}
