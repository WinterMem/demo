package com.pch.user.service.impl;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pch.user.po.MyUserDetails;
import com.pch.user.dao.UserMapper;
import com.pch.user.dto.UserDTO;
import com.pch.user.po.UserPO;
import com.pch.user.service.UserService;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserPO userPO = userMapper.loadUserByUsername(username);
        if (null == userPO) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        return new MyUserDetails(userPO, null);
    }

    @Override
    public String login(UserDTO userDTO) {
        UserDetails userDetails = loadUserByUsername(userDTO.getUsername());

        return null;
    }

    @Override
    public int insertUser(UserPO userPO) {
        return userMapper.insertUser(userPO);
    }
}
