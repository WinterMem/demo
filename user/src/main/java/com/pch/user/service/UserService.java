package com.pch.user.service;

import com.pch.user.dto.UserDTO;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

	UserDetails loadUserByUsername(String username);

	Integer insertUser(UserDTO userDTO);

	String login(UserDTO userDTO);
}
