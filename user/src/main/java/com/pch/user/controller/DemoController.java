package com.pch.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pch.common.response.CommonResult;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/das")
public class DemoController {

    @ApiOperation(notes = "代办事项", value = "测试界面")
    @GetMapping(value = "/todo")
    public CommonResult<Integer> getToDo() {
        return CommonResult.success(5);
    }

}
