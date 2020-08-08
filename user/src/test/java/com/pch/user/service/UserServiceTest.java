package com.pch.user.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.pch.user.UserApplicationTests;
import com.pch.user.dto.UserDto;

/**
 * @author: pch
 * @date: 2020/7/27
 */

public class UserServiceTest extends UserApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void register() {
        UserDto userDTO = new UserDto().setPassword("fire").setUsername("fire").setTelephone("177");
        userService.register(userDTO);
    }
}