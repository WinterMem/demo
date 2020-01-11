package com.pch.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pch.user.common.CommonResult;

@RestController
@RequestMapping(value = "/das")
public class DemoController {

    @GetMapping(value = "/todo")
    public CommonResult<Integer> getToDo() {
        return CommonResult.success(5);
    }


}
