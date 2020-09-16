package com.pch.user.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pch.user.repository.RoleRepository;
import com.pch.user.repository.UserRoleRepository;
import com.pch.user.model.domin.RoleDO;
import com.pch.user.model.domin.UserRoleDO;
import com.pch.user.model.dto.RoleDTO;
import com.pch.user.service.mapper.RoleMapper;
import com.pch.user.service.RoleService;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;

/**
 * @description: 角色业务实现
 * @author: pch
 * @date: 2020/09/13
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public Long create(RoleDTO roleDTO) {
        RoleDO roleDO = roleMapper.toDto(roleDTO);
        RoleDO save = roleRepository.save(roleDO);
        return save.getId();
    }

    @Override
    public Boolean update(RoleDTO roleDTO) {
        Optional<RoleDO> byId = roleRepository.findById(roleDTO.getId());
        byId.ifPresent(roleDO -> BeanUtil.copyProperties(roleDO, roleDTO, CopyOptions.create().setIgnoreNullValue(true)));
        return true;
    }

    @Override
    public List<RoleDTO> findAll() {
        List<RoleDO> all = roleRepository.findAll();
        return all.stream().map(roleDO -> roleMapper.toEntity(roleDO)).collect(Collectors.toList());
    }

    @Override
    public Boolean bindUsers(Long id, List<Long> userIds) {
        List<UserRoleDO> userRoleDOS = new ArrayList<>();
        userIds.forEach(userId -> {
            UserRoleDO userRoleDO = new UserRoleDO();
            userRoleDO.setUserId(userId);
            userRoleDO.setRoleId(id);
            userRoleDOS.add(userRoleDO);
        });
        userRoleRepository.saveAll(userRoleDOS);
        return true;
    }

    @Override
    public List<RoleDTO> findRoleByUserId(Long userId) {
        List<RoleDO> roleDOS = roleRepository.findRoleByUserId(userId);
        return roleDOS.stream().map(roleDO -> roleMapper.toEntity(roleDO)).collect(Collectors.toList());
    }
}
