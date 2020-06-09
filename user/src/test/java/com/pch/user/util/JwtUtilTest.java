package com.pch.user.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pch.user.config.IgnoreUrlsConfig;

/**
 * @Author: pch
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
public class JwtUtilTest {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private IgnoreUrlsConfig ignoreUrlsConfig;

    @Test
    public void generateToken() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("sub", "username");
        claims.put("created", new Date());
        String token = jwtUtil.generateToken(claims);
        log.info("测试token为：{}", token);
    }

    @Test
    public void ignoreUrlsConfig() {
        List<String> urls = ignoreUrlsConfig.getUrls();
        System.out.println(urls);
    }
}