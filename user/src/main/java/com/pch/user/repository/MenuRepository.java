package com.pch.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.pch.user.model.domin.MenuDO;

/**
 * @author: pch
 * @date: 2020/9/11
 */
public interface MenuRepository extends CrudRepository<MenuDO, Long> {

    @Query("select m from MenuDO m inner join RoleMenuDO rm on rm.menuId = m.id "
            + "inner join UserRoleDO ur on ur.roleId = rm.roleId where ur.userId = :userId")
    List<MenuDO> findByUserId(@Param("userId") Long userId);
}
