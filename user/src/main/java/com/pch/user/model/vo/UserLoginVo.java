package com.pch.user.model.vo;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: pch
 * @date: 2020/9/11
 */
@Data
@EqualsAndHashCode
@ApiModel("用户登录模型")
public class UserLoginVo {

    @NotBlank(message = "loginName is not be blank")
    @Length(max = 32)
    @ApiModelProperty("账号")
    private String loginName;

    @ApiModelProperty("密码")
    private String password;

}
