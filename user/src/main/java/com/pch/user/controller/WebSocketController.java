package com.pch.user.controller;

import com.pch.user.common.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.pch.user.common.CommonResult.success;

@RestController
@RequestMapping("/app")
public class WebSocketController {

    @GetMapping("/getMsg")
    public CommonResult<String> getMsg() {

        return success("发送成功");
    }

}
