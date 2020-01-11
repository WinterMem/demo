package com.pch.user.dao;

import org.springframework.stereotype.Repository;

import com.pch.user.po.UserPO;

@Repository
public interface UserMapper {

    UserPO queryUserByLogin(String username);

    int insertUser(UserPO userPO);
}
