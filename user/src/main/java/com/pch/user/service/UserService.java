package com.pch.user.service;

import com.pch.user.po.UserPO;

public interface UserService {

    UserPO queryUserByLogin(String username);

    int insertUser(UserPO userPO);
}
