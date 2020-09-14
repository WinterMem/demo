package com.pch.user.service;

import java.util.List;

import javax.transaction.Transactional;

import com.pch.user.model.dto.RoleDTO;

/**
 * @description: 角色repository
 * @author: pch
 * @date: 2020/9/13
 */
public interface RoleService {

    /**
     * 创建一个角色
     *
     * @return 返回role实体id
     */
    @Transactional
    Long create(RoleDTO roleDTO);

    /**
     * 更新角色信息
     *
     * @return 成功返回true
     */
    @Transactional
    Boolean update(RoleDTO roleDTO);

    /**
     * 查询所有角色实体
     *
     * @return 返回角色集合
     */
    List<RoleDTO> findAll();

    /**
     * 通过用户id查询角色集合
     *
     * @param userId 用户id
     * @return 返回角色集合
     */
    List<RoleDTO> findRoleByUserId(Long userId);

    /**
     * 绑定用户
     *
     * @param id        角色id
     * @param userIds       用户id集合
     */
    @Transactional
    Boolean bindUsers(Long id, List<Long> userIds);
}
