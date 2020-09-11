package com.pch.user.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.pch.user.model.dto.UserDTO;
import com.pch.user.model.vo.UserLoginVo;

public interface UserService {

    /**
     * 注册一个用户
     *
     * @param userDTO       用户dto
     */
    @Transactional
    Long register(UserDTO userDTO);

    /**
     * 用户登录
     *
     * @param userLoginVo       用户登录vo
     */
    String login(UserLoginVo userLoginVo);

    /**
     * 通过id查询用户信息
     *
     * @param id        用户id
     */
    Optional<UserDTO> findById(Long id);

    /**
     * 查询用户集合
     *
     */
    List<UserDTO> findAll();
}
