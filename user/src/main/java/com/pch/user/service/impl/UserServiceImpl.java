package com.pch.user.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pch.common.constant.SysState;
import com.pch.user.convert.UserConvert;
import com.pch.user.dao.UserRepository;
import com.pch.user.exception.ServiceException;
import com.pch.user.model.domin.UserDO;
import com.pch.user.model.dto.UserDTO;
import com.pch.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<UserDO> userDO = userRepository.findByLoginName(username);
        if (!userDO.isPresent()) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        return null;
    }

    @Override
    public String login(UserDTO userDTO) {

        return null;
    }

    @Override
    public Optional<UserDTO> findById(Long id) {
        Optional<UserDO> byId = userRepository.findById(id);

        return byId.map(userPO -> UserConvert.INSTANCE.UserDTOCovert(byId));
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
        UserDO save = userRepository.save(UserConvert.INSTANCE.userDtoToPoConvert(userDTO));
        return save.getId();
    }
}
