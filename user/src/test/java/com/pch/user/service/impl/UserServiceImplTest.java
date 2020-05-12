package com.pch.user.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pch.user.po.UserPO;
import com.pch.user.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void queryUserByLoginTest() {
        Assert.assertNotNull(userService.queryUserByLogin("winter"));
    }

    @Test
    public void insertUser() {
        UserPO userPO = new UserPO();
        userPO.setUsername("winter").setLoginName("winter").setTellPhone("1111").setPassword("winter");
        userService.insertUser(userPO);
    }

}