package com.pch.user.service;

import com.pch.user.dto.UserDTO;
import javax.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

    UserDetails loadUserByUsername(String username);

    @Transactional
    Long register(UserDTO userDTO);

    String login(UserDTO userDTO);
}
