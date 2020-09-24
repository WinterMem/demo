package com.pch.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pch.common.annotation.Logging;
import com.pch.common.model.DTOBase;
import com.pch.common.response.CommonResult;
import com.pch.user.model.dto.UserDTO;
import com.pch.user.model.vo.UserLoginVo;
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
    public CommonResult<UserDTO> findById(@PathVariable Long id) {
        Optional<UserDTO> byId = userService.findById(id);
        return byId.map(CommonResult::success).orElseGet(CommonResult::success);
    }

    @ApiOperation("获取用户集合")
    @GetMapping("/list")
    public CommonResult<List<UserDTO>> findAll() {
        return CommonResult.success(userService.findAll());
    }

    @Logging
    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public CommonResult<String> login(@Validated @RequestBody UserLoginVo userDto) {
        return CommonResult.success(userService.login(userDto));
    }

    @Logging
    @ApiOperation(value = "更新用户信息")
    @PutMapping
    public CommonResult<Boolean> update(
            @Validated(DTOBase.Update.class) @RequestBody UserDTO userDto) {
        return CommonResult.success(userService.update(userDto));
    }

    @Logging
    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    public CommonResult<Long> register(@Validated @RequestBody UserDTO userDto) {
        return CommonResult.success(userService.register(userDto));
    }

}
