package com.pch.user.service.impl;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.pch.user.dto.UserDTO;
import com.pch.user.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class UserServiceImplTest {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;
    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @Test
    public void queryUserByLoginTest() {
        int order = requestMappingHandlerAdapter.getOrder();
        int order1 = requestMappingHandlerMapping.getOrder();
    }

    @Test
    public void insertUser() {
        UserDTO userDTO = new UserDTO();
//        userDTO.setUsername("winter").setLoginName("")
//        userService.
//        userService.insertUser();
    }

    @Test
    public void login() {
        UserDTO userDTO = new UserDTO();
//        userService.login()
    }

}