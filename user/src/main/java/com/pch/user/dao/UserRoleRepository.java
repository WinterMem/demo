package com.pch.user.dao;

import org.springframework.data.repository.CrudRepository;

import com.pch.user.model.domin.UserRoleDO;

/**
 * @author: pch
 * @date: 2020/9/14
 */
public interface UserRoleRepository extends CrudRepository<UserRoleDO, Long> {

}
