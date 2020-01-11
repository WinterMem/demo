package com.pch.user.po;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 *
 */
@Data
@Accessors(chain = true)
public class UserPO implements Serializable {

    private static final long serialVersionUID = -8692760072307721060L;

    private Integer id;

    private String username;

    private String loginName;

    private String password;

    private String tellPhone;
}
