package com.pch.user.service.impl;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.pch.user.po.UserPO;
import com.pch.user.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners
@SpringBootTest
@Slf4j
public class UserServiceImplTest {

    @Autowired
    private UserService userService;
    @Autowired
    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;
    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @Test
    public void queryUserByLoginTest() {
        int order = requestMappingHandlerAdapter.getOrder();
        int order1 = requestMappingHandlerMapping.getOrder();
        UserPO userPO = userService.queryUserByLogin(null);
        log.info(" ----- {}",userPO);
    }

    @Test
    public void insertUser() {
        UserPO userPO = new UserPO();
        userPO.setUsername("winter").setLoginName("winter").setTellPhone("1111").setPassword("winter");
        userService.insertUser(userPO);
    }

}