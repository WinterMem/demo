package com.pch.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.pch.user.service.CommodityService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
public class CommodityServiceImplTest {

	@Autowired
	private CommodityService commodityService;

	@Autowired
	private PasswordEncoder passwordEncoder;


	@Test
	public void queryAllCommodity() {
	}

	@Test
	public void insertCommodity() {
		List<String> list = new ArrayList<>(12);
		list.add("$2a$10$.2oUhPrODf4c0BdRyIBin.OHv9q/1MrKZU9loDIcVhsTf08B1M7A6");
		list.add("$2a$10$.8yyT8l0vPqUgp30YLNXlO2pGusfAo/SqcyJSCMYzEiz581NNq8Ou");
		list.add("$2a$10$8HVT4EJmr1BE3NqC5n2t7uOskjOirSr5jOetfnUnLD7WgEqyI9xAu");
		list.add("$2a$10$ZhdsFTbTkcVP3/6F9ripteLKvTnb3hRdylxM88WfvSrL02FINumT2");
		list.add("$2a$10$lAqRiElhW1eRm7njdJKaeOPwt8xDLevrkxwW1PIX.6fjK9mYNbe1C");
		String pchmemory123654 = passwordEncoder.encode("pchmemory1&*^23651114");
		for (int i = 0; i < 10; i++) {
			System.out.println(pchmemory123654);

		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(passwordEncoder.matches("pchmemory1&*^23651114", list.get(i)));
		}
	}
}