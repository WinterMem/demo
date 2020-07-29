package com.pch.user.service.impl;

import java.util.Optional;

import com.pch.user.constant.SysState;
import com.pch.user.convert.UserConvert;
import com.pch.user.dao.UserRepository;
import com.pch.user.dto.UserDTO;
import com.pch.user.exception.ServiceException;
import com.pch.user.po.MyUserDetails;
import com.pch.user.po.UserPO;
import com.pch.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<UserPO> userPO = userRepository.findByLoginName(username);
        if (userPO.isPresent()) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        return new MyUserDetails(userPO.get(), null);
    }

    @Override
    public String login(UserDTO userDTO) {

        return null;
    }

    @Override
    public Long register(UserDTO userDTO) {
        Integer count = userRepository
                .countByEmail(userDTO.getEmail() != null ? userDTO.getEmail() : "");
        if (count > 0) {
            throw new ServiceException(SysState.user_email_exist);
        }
        count = userRepository
                .countByTelephone(userDTO.getTelephone() != null ? userDTO.getTelephone() : "");
        if (count > 0) {
            throw new ServiceException(SysState.user_telephone_exist);
        }
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        UserPO save = userRepository.save(UserConvert.INSTANCE.userDtoToPoConvert(userDTO));
        return save.getId();
    }
}
