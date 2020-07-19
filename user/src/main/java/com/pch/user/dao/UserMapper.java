package com.pch.user.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pch.user.po.UserPO;
import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<UserPO> {

	int insertUser(UserPO userPO);

	UserPO loadUserByUsername(String username);

	List<String> queryUserByEmailOrTell(@Param("email") String email, @Param("telephone") String telephone);
}
