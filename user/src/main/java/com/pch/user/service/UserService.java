package com.pch.user.service;

import java.util.Optional;

import javax.transaction.Transactional;

import com.pch.user.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

    UserDetails loadUserByUsername(String username);

    @Transactional
    Long register(UserDTO userDTO);

    String login(UserDTO userDTO);

    Optional<UserDTO> findById(Long id);
}
