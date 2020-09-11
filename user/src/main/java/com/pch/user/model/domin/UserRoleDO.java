package com.pch.user.model.domin;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户角色实体
 * @author: pch
 * @date: 2020/9/11
 */
@Getter
@Setter
@Entity
@Table(name = "tb_user_role")
public class UserRoleDO implements Serializable {

    private static final long serialVersionUID = -3367234109963321071L;

    @Id
    private Long userId;

    private Long roleId;


}
