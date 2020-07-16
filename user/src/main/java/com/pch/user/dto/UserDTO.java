package com.pch.user.dto;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
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
    @Pattern(regexp = "/^[1](([3][0-9])|([4][5-9])|([5][0-3,5-9])|([6][5,6])|([7][0-8])|([8][0-9])|([9][1,8,9]))[0-9]{8}$/", message = "手机号不合法")
    private String telephone;

    @ApiModelProperty("邮箱")
    @Email
    private String email;

    @ApiModelProperty("验证码")
    @NotBlank(message = "验证码不能为空")
    private String captcha;
}
