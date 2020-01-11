package com.pch.user;

import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pch.user.po.UserPO;
import com.pch.user.service.UserService;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class UserApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
        UserPO userPO = userService.queryUserByLogin("4555");
        log.info("user : {}", userPO);
    }

}
