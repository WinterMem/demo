package com.pch.user.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.pch.common.model.DTOBase;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户模型")
@Accessors(chain = true)
public class UserDTO extends DTOBase {

    private static final long serialVersionUID = -3588681970139736184L;

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
    private String captcha;

    @ApiModelProperty("启用禁用")
    private Boolean enable;

    @ApiModelProperty("锁定账户")
    private Boolean lock;
}
