package com.pch.user.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pch.common.group.Insert;
import com.pch.common.group.Update;
import com.pch.common.response.CommonResult;
import com.pch.user.model.dto.UserDto;
import com.pch.user.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "用户管理模块")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("通过id获取用户信息")
    @GetMapping("/{id}")
    public CommonResult<UserDto> findById(@PathVariable Long id) {
        Optional<UserDto> byId = userService.findById(id);
        return byId.map(CommonResult::success).orElseGet(CommonResult::success);
    }

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public CommonResult<String> login(@Validated(Update.class) @RequestBody UserDto userDto) {
        return CommonResult.success(userService.login(userDto));
    }

    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    public CommonResult<Long> register(@Validated(Insert.class) @RequestBody UserDto userDto) {
        return CommonResult.success(userService.register(userDto));
    }

}
