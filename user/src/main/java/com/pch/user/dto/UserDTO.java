package com.pch.user.dto;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 *
 */
@Data
@Accessors(chain = true)
public class UserDTO implements Serializable {

    private static final long serialVersionUID = -3588681970139736184L;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    @NotEmpty(message = "用户名不能为空")
    private String username;

    /**
     * 电话号码
     */
    @ApiModelProperty("电话号码")
    private String telephone;

    @ApiModelProperty("邮箱")
    @Email
    private String email;

    @ApiModelProperty("验证码")
//    @NotBlank(message = "验证码不能为空")
    private String captcha;
}
