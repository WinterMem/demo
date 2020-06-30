package com.pch.user.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.pch.user.dto.UserDTO;

public interface UserService {

    UserDetails loadUserByUsername(String username);

    Integer insertUser(UserDTO userDTO);

    String login(String name, String password, String tellPhone, String captcha);
}
