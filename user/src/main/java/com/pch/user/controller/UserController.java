package com.pch.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pch.user.common.CommonResult;
import com.pch.user.dto.UserDTO;
import com.pch.user.po.UserPO;
import com.pch.user.service.UserService;

@Api(value = "用户管理模块")
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private UserService userService;

    @ApiOperation(value="修改用户密码", notes="根据用户id修改密码")
    @PostMapping("/login")
    public CommonResult<UserPO> login(UserDTO userDTO) {
        String token = userService.login(userDTO);
        return CommonResult.success(null);
    }

}
