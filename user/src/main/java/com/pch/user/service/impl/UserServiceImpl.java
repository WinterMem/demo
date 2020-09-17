package com.pch.user.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pch.common.constant.SysState;
import com.pch.common.exception.ServiceException;
import com.pch.user.repository.MenuRepository;
import com.pch.user.repository.UserRepository;
import com.pch.user.model.AdminUserDetail;
import com.pch.user.model.domin.MenuDO;
import com.pch.user.model.domin.UserDO;
import com.pch.user.model.dto.UserDTO;
import com.pch.user.model.vo.UserLoginVo;
import com.pch.user.service.mapper.UserMapper;
import com.pch.user.service.UserService;
import com.pch.user.util.JwtUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<UserDO> userDOOptional = userRepository.findByLoginName(username);
        if (!userDOOptional.isPresent()) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        UserDTO userDTO = userMapper.toEntity(userDOOptional.get());
        List<MenuDO> menuDOS = menuRepository.findByUserId(userDTO.getId());
        Set<GrantedAuthority> authorities = new HashSet<>();
        menuDOS.forEach(
                menuDO -> authorities.add(new SimpleGrantedAuthority(menuDO.getPermission())));
        return new AdminUserDetail(userDTO, authorities);
    }

    @Override
    public String login(UserLoginVo userLoginVo) {
        UserDetails userDetails = loadUserByUsername(userLoginVo.getLoginName());
        if (!passwordEncoder.matches(userLoginVo.getPassword(), userDetails.getPassword())) {
            throw new BadCredentialsException("密码错误");
        }
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtUtils.generateToken(userDetails);
    }

    @Override
    public List<UserDTO> findAll() {
        List<UserDO> all = userRepository.findAll();
        return all.stream().map(userDO -> userMapper.toEntity(userDO)).collect(Collectors.toList());
    }

    @Override
    public Optional<UserDTO> findById(Long id) {
        Optional<UserDO> byId = userRepository.findById(id);
        return byId.map(userPO -> userMapper.toEntity(userPO));
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
        UserDO userDO = userMapper.toDto(userDTO);
        userDO.setEnable(true);
        UserDO save = userRepository.save(userDO);
        return save.getId();
    }
}
