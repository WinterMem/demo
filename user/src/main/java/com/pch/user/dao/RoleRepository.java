package com.pch.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pch.user.model.domin.RoleDO;

/**
 * @author: pch
 * @date: 2020/9/11
 */
public interface RoleRepository extends CrudRepository<RoleDO, Long>,
        JpaSpecificationExecutor<RoleDO> {

    @Query("select r from RoleDO r inner join UserRoleDO ur on "
            + "ur.roleId = r.id where ur.userId = :userId")
    List<RoleDO> findRoleByUserId(@Param("userId") Long userId);

    List<RoleDO> findAll();
}
