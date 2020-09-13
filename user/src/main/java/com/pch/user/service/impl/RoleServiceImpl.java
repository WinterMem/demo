package com.pch.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pch.user.dao.RoleRepository;
import com.pch.user.model.domin.RoleDO;
import com.pch.user.model.dto.RoleDTO;
import com.pch.user.service.RoleMapper;
import com.pch.user.service.RoleService;

/**
 * @description:
 * @author: pch
 * @date: 2020/09/13
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Long create(RoleDTO roleDTO) {

        return null;
    }

    @Override
    public Boolean update(RoleDTO roleDTO) {
        return null;
    }

    @Override
    public List<RoleDO> findAll() {
        return null;
    }

    @Override
    public List<RoleDTO> findRoleByUserId(Long userId) {
        List<RoleDO> roleDOS = roleRepository.findRoleByUserId(userId);
        return null;
    }
}
