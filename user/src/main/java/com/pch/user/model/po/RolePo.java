package com.pch.user.model.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 角色bo
 *
 * @Author: pch
 */
@Data
@Entity
@Accessors(chain = true)
@Table(name = "tb_role")
public class RolePo implements Serializable {

    private static final long serialVersionUID = -4919650087858107971L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
