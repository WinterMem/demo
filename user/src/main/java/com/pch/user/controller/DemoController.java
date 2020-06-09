package com.pch.user.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pch.user.common.CommonResult;
import com.pch.user.po.UserPO;

@RestController
@RequestMapping(value = "/das")
public class DemoController {

    @GetMapping(value = "/todo")
    public CommonResult<Integer> getToDo() {
        return CommonResult.success(5);
    }

    @GetMapping(value = "/validatePo")
    public CommonResult<UserPO> validatePo(@Validated @RequestBody UserPO userPO) {
        return CommonResult.success(userPO);
    }
}
