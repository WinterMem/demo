package com.pch.user.common;

import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import com.pch.user.po.UserPO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class CommonResultTest {

	@Test
	public void resultDemo() {
		UserPO userPO = new UserPO();
		userPO.setId(111).setLoginName("wttt");
		CommonResult<UserPO> success = CommonResult.success(userPO);
		UserPO data = success.getData();

	}

	@Test
	public void testCase1() {
		String age = "29";
		System.out.println(age);
	}

	@Test
	public void testCase2() {
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i + " * " + j + " = " + i * j + "\t");
			}
			System.out.println();
		}
	}

	@Test
	public void testCase3() {

		Set<Integer> treeSet = new TreeSet<>((o1, o2) -> o1.compareTo(o2));

		treeSet.add(1);
		treeSet.add(6);
		treeSet.add(65);
		treeSet.add(10);

		CommonResultTest.log.info("{}", treeSet);
	}

	private static boolean flag = false;

	private static Integer i = 0;

	public static void main(String[] args) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(1);
					CommonResultTest.flag = true;

					System.out.println("改变了flag的值....");

				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

		while (!CommonResultTest.flag) {
			CommonResultTest.i++;
//            System.out.println(i);
		}
		System.out.println("执行完了。 i = " + CommonResultTest.i);
	}

}