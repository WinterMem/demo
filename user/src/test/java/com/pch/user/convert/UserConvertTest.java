package com.pch.user.convert;

import com.pch.user.dto.UserDTO;
import com.pch.user.po.UserPO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class UserConvertTest {

    @Test
    public void userDTOCovert() {
        UserPO userPO = new UserPO();
        userPO.setId(111).setUsername("winter").setPassword("winter")
            .setLoginName("winter").setTellPhone("1111");
        UserDTO userDTO = UserConvert.INSTANCE.UserDTOCovert(userPO);
        log.info("userDTO : {}", userDTO);
    }

    @Test
    public void testLinkedList() {
        List<Integer> integers = new ArrayList<>();
        integers.add(0);
        integers.add(4);
        integers.add(5);
        integers.add(3);
        integers.sort((o1, o2) -> o1.compareTo(o2));
        System.out.println(integers);
    }
}