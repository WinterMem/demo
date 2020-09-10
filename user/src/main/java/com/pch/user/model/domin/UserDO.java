package com.pch.user.model.domin;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.pch.common.model.BaseDO;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 */
@Data
@Entity
@Table(name = "tb_user")
@EqualsAndHashCode(callSuper = true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UserDO extends BaseDO {

    private static final long serialVersionUID = -8692760072307721060L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 登录名称
     */
    private String loginName;

    /**
     * 密码
     */
    private String password;

    /**
     * tell
     */
    private String telephone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 启用禁用
     */
    private Boolean enable;

}
