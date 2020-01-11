package com.pch.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pch.user.common.CommonResult;
import com.pch.user.po.UserPO;
import com.pch.user.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public CommonResult<UserPO> login(UserPO userPO) {
        return CommonResult.success(userService.queryUserByLogin(userPO.getUsername()));
    }


}
