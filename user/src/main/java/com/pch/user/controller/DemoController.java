package com.pch.user.controller;

import io.swagger.annotations.ApiOperation;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pch.user.common.CommonResult;
import com.pch.user.po.CommodityPO;
import com.pch.user.po.UserPO;

@RestController
@RequestMapping(value = "/das")
public class DemoController {

    @ApiOperation(notes = "代办事项", value = "测试界面")
    @GetMapping(value = "/todo")
    public CommonResult<Integer> getToDo() {
        return CommonResult.success(5);
    }

    @GetMapping(value = "/validatePo")
    public CommonResult<UserPO> validatePo(@Validated UserPO userPO, CommodityPO commodityPO) {
        return CommonResult.success(userPO);
    }
}
