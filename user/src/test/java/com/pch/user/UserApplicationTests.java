package com.pch.user;

import com.pch.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class UserApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	public void contextLoads() {

	}

}
