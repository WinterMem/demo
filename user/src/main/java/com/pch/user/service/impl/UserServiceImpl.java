package com.pch.user.service.impl;

import java.util.List;

import com.pch.user.constant.SysState;
import com.pch.user.convert.UserConvert;
import com.pch.user.dao.UserMapper;
import com.pch.user.dto.UserDTO;
import com.pch.user.exception.ServiceException;
import com.pch.user.po.MyUserDetails;
import com.pch.user.po.UserPO;
import com.pch.user.service.UserService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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

		return null;
	}

	@Override
	public Integer insertUser(UserDTO userDTO) {
		UserPO userPO = userMapper.selectById(10);
		List<String> strings = userMapper.queryUserByEmailOrTell(userDTO.getEmail(),
				userDTO.getTelephone());
		if (strings.size() > 1) {
			throw new ServiceException(SysState.user_exist);
		}
		return userMapper.insertUser(UserConvert.INSTANCE.userDtoToPoConvert(userDTO));
	}
}
