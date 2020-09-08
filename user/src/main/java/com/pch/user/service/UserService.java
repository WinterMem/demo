package com.pch.user.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.UserDetails;

import com.pch.user.model.dto.UserDto;

public interface UserService {

    UserDetails loadUserByUsername(String username);

    @Transactional
    Long register(UserDto userDTO);

    String login(UserDto userDTO);

    Optional<UserDto> findById(Long id);
}
