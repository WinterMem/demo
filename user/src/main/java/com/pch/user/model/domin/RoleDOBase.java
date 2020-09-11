package com.pch.user.model.domin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;

import com.pch.common.model.DOBase;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色实体
 * @author: pch
 * @date: 2020/9/11
 */
@Data
@Entity
@Table(name = "tb_role")
@EqualsAndHashCode(callSuper = true)
public class RoleDOBase extends DOBase {

    private static final long serialVersionUID = -4919650087858107971L;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 描述
     */
    private String description;

    /**
     * 启用禁用
     */
    private Boolean enable;

    /**
     * 创建人
     */
    @CreatedBy
    @Column(updatable = false)
    private String createBy;

}
