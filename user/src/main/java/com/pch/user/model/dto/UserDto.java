package com.pch.user.model.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.pch.common.group.Update;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户模型")
@Accessors(chain = true)
public class UserDto implements Serializable {

    private static final long serialVersionUID = -3588681970139736184L;

    @NotNull(groups = Update.class, message = "id is not be null")
    private Long id;

    @ApiModelProperty("登录名称")
    @NotBlank(message = "loginName is not be blank")
    private String loginName;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    @NotBlank(message = "密码不能为空")
    private String password;

    @ApiModelProperty("电话号码")
    private String telephone;

    @ApiModelProperty("邮箱")
    @Email
    private String email;

    @ApiModelProperty("验证码")
    @NotBlank(message = "验证码不能为空")
    private String captcha;
}
