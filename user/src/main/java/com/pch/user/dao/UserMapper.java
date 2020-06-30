package com.pch.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.pch.user.po.UserPO;

@Repository
public interface UserMapper {

    int insertUser(UserPO userPO);

    UserPO loadUserByUsername(String username);

    List<String> queryUserByEmailOrTell(@Param("email") String email,
                                        @Param("telephone") String telephone);
}
