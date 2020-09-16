package com.pch.user.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.pch.user.UserApplicationTests;
import com.pch.user.repository.RoleRepository;
import com.pch.user.repository.UserRepository;
import com.pch.user.model.dto.UserDTO;

/**
 * @author: pch
 * @date: 2020/7/27
 */

public class UserServiceTest extends UserApplicationTests {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void register() {
        UserDTO userDTO = new UserDTO().setPassword("fire").setUsername("fire").setTelephone("177");
        userService.register(userDTO);
    }

    @Test
    public void testSave() {


    }
}