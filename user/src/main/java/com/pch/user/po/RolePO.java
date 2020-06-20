package com.pch.user.po;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色bo
 *
 * @Author: pch
 */
@Getter
@Setter
public class RolePO implements Serializable {

    private static final long serialVersionUID = -4919650087858107971L;

    private Integer id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 关联人数
     */
    private Integer adminCount;


}
