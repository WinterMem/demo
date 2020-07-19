package com.pch.user.controller;

import com.pch.user.common.CommonResult;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/das")
public class DemoController {

	@ApiOperation(notes = "代办事项", value = "测试界面")
	@GetMapping(value = "/todo")
	public CommonResult<Integer> getToDo() {
		return CommonResult.success(5);
	}

}
