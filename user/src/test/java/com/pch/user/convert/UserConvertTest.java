package com.pch.user.convert;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;

import com.pch.user.dto.UserDTO;
import com.pch.user.po.UserPO;

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
}