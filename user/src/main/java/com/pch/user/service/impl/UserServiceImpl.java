package com.pch.user.service.impl;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pch.user.dao.UserMapper;
import com.pch.user.po.UserPO;
import com.pch.user.service.UserService;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserPO queryUserByLogin(String username) {
        return userMapper.queryUserByLogin(username);
    }

    @Override
    public int insertUser(UserPO userPO) {
        return userMapper.insertUser(userPO);
    }
}
