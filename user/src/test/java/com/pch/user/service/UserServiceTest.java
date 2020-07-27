package com.pch.user.service;

import com.pch.user.UserApplicationTests;
import com.pch.user.dto.UserDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: pch
 * @date: 2020/7/27
 */

public class UserServiceTest extends UserApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void register() {
        UserDTO userDTO = new UserDTO().setPassword("fire").setUsername("fire").setTelephone("177");
        userService.register(userDTO);
    }
}