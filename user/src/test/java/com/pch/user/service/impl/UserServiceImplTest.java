package com.pch.user.service.impl;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.pch.user.dto.UserDTO;
import com.pch.user.po.UserPO;
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
        UserPO userPO = new UserPO();
        userPO.setUsername("管理员");
        userPO.setLoginName("admin");
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String admin1 = passwordEncoder.encode("admin");
        log.info(admin1);
        String admin = bCryptPasswordEncoder.encode("admin");
        userPO.setPassword(admin);
        userPO.setTellPhone("17771568965");
        userService.insertUser(userPO);
    }

    @Test
    public void login() {
        UserDTO userDTO = new UserDTO();
//        userService.login()
    }

}