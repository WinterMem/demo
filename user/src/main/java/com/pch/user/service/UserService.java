package com.pch.user.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.pch.user.dto.UserDTO;
import com.pch.user.po.UserPO;

public interface UserService {

    UserDetails loadUserByUsername(String username);

    int insertUser(UserPO userPO);

    String login(UserDTO userDTO);
}
