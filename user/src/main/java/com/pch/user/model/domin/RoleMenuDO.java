package com.pch.user.model.domin;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 角色菜单实体
 * @author: pch
 * @date: 2020/9/11
 */
@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "tb_role_menu")
public class RoleMenuDO implements Serializable {

    private static final long serialVersionUID = -2946108570423845147L;

    @Id
    private Long roleId;

    private Long menuId;
}
