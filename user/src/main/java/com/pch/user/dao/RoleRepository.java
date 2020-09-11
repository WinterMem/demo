package com.pch.user.dao;

import org.springframework.data.repository.CrudRepository;

import com.pch.user.model.domin.RoleDOBase;

/**
 * @author: pch
 * @date: 2020/9/11
 */
public interface RoleRepository extends CrudRepository<RoleDOBase, Long> {

}
