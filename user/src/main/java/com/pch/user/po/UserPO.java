package com.pch.user.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

/**
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserPO implements Serializable {

    private static final long serialVersionUID = -8692760072307721060L;

    private Integer id;

    @NotEmpty
    private String username;

    @NotEmpty
    private String loginName;

    private String password;

    private String tellPhone;

    private float money;
}
