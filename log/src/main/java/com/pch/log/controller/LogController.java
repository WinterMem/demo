package com.pch.log.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pch.common.response.CommonResult;
import com.pch.log.model.dto.LogDTO;
import com.pch.log.service.LogService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author: pch
 * @date: 2020/9/10
 */
@Api(tags = "日志管理")
@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping
    @ApiOperation("获取日志集合")
    public CommonResult<List<LogDTO>> findAll() {
        return CommonResult.success(logService.findAll());
    }

    @PostMapping
    @ApiOperation("创建一条日志")
    public CommonResult<Long> create(@Validated @RequestBody LogDTO logDTO) {
        return CommonResult.success(logService.save(logDTO));
    }

}
