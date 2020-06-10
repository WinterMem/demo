package com.pch.user.dao;

import org.springframework.stereotype.Repository;

import com.pch.user.po.UserPO;

@Repository
public interface UserMapper {

    int insertUser(UserPO userPO);

    UserPO loadUserByUsername(String username);
}
