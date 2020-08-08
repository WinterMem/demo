package com.pch.user.controller;

import com.pch.user.common.CommonResult;
import com.pch.user.dto.UserDto;
import com.pch.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户管理模块")
@RestController
//@RequestMapping(value = "")
public class UserController {

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private UserService userService;

    //    @ApiModelProperty(value = )
    @GetMapping("/user/{id}")
    public CommonResult<UserDto> findById(@PathVariable Long id) {
        return CommonResult.success(userService.findById(id).get());
    }

    @ApiOperation(value = "用户登录", notes = "根据用户id修改密码")
    @PostMapping("/user/login")
    public CommonResult<String> login(@RequestBody @Validated UserDto userDTO) {
        return CommonResult.success(userService.login(userDTO));
    }

    @ApiOperation(value = "用户登录", notes = "根据用户id修改密码")
    @PostMapping("/user/register")
    public CommonResult<Long> register(@Validated @RequestBody UserDto userDTO) {
        return CommonResult.success(userService.register(userDTO));
    }

}
