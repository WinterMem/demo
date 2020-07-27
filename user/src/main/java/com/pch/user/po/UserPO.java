package com.pch.user.po;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 *
 */
@Data
@Entity
@Accessors(chain = true)
@Table(name = "tb_user")
public class UserPO implements Serializable {

    private static final long serialVersionUID = -8692760072307721060L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

//    /**
//     * 金钱
//     */
//    private float money;
}
