package com.pch.user.constant;

import java.util.Set;
import java.util.TreeSet;

import com.pch.user.po.UserPO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class WebSocketConstantTest {

	@Test
	public void testCase() {
		WebSocketConstantTest.log.info("constant :{}", WebSocketConstant.CLIENT_TO_CLIENT);
	}

	@Test
	public void testCase1() {
		Set<UserPO> treeSet = new TreeSet<>((user1, user2) -> {

			if (!user1.getUsername().equals(user2.getUsername())) {
				return user1.getUsername().compareTo(user2.getUsername());
			}

			return user1.getLoginName().compareTo(user2.getLoginName());
		});


//        treeSet.forEach(log::info);
		for (UserPO userPO : treeSet) {
			WebSocketConstantTest.log.info("treeSet 排序为: {}", userPO);
		}
	}
}