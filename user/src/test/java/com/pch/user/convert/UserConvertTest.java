package com.pch.user.convert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.pch.user.dto.UserDTO;
import com.pch.user.po.UserPO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class UserConvertTest {

	public static List<UserPO> getUserPOList() {
		List<UserPO> arrayList = new ArrayList<>(300);
		for (int i = 0; i < 100; i++) {
//            UserPO userPO = new UserPO(i, "username" + i, null, null, null, null);
//            arrayList.add(userPO);
		}
		return arrayList;
	}

	@Test
	public void userDTOCovert() {
		UserPO userPO = new UserPO();
		userPO.setId(111).setUsername("winter").setPassword("winter")
				.setLoginName("winter").setTelephone("1111");
		UserDTO userDTO = UserConvert.INSTANCE.UserDTOCovert(userPO);
		UserConvertTest.log.info("userDTO : {}", userDTO);
	}

	@Test
	public void testLinkedList() {
		List<UserPO> userPOList = UserConvertTest.getUserPOList();
		for (UserPO userPO : userPOList) {
			userPOList.remove(userPO);
		}
	}

	@Test
	public void testLinkedList1() {
		List<UserPO> userPOList = UserConvertTest.getUserPOList();
		Iterator<UserPO> iterator = userPOList.iterator();
		while (iterator.hasNext()) {
			UserPO next = iterator.next();
			iterator.remove();
		}
	}

	@Test
	public void testCase() {
		List<UserPO> userPOList = UserConvertTest.getUserPOList();
		Map<String, UserPO> map;
		for (UserPO userPO : userPOList) {
			map = new HashMap<>();
		}
	}

	@Test
	public void testCase1() {
		Map<Integer, String> collect1 = UserConvertTest.getUserPOList()
				.stream()
				.map(bean -> bean.getId() + ":" + bean.getLoginName())
				.collect(Collectors.toMap(String::hashCode, String::toString));
		UserConvertTest.log.info("测试map拼接:{}", collect1);
		Map<Integer, UserPO> collect = UserConvertTest.getUserPOList().stream().filter(t -> t.getId() == 1).collect(Collectors.toMap(UserPO::getId, e -> e));
		UserConvertTest.log.info("filter 拦截换回值为{}", collect);
		List<Integer> integerStream = UserConvertTest.getUserPOList().stream().map(UserPO::getId).collect(Collectors.toList());
		UserConvertTest.log.info("map 过滤值为{}", integerStream);
	}

	@Test
	public void testCase2() {
		ArrayList<UserPO> userPOS = new ArrayList<>();
		List<UserPO> collect = userPOS.stream().limit(5).collect(Collectors.toList());
	}
}