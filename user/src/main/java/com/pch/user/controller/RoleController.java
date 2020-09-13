package com.pch.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pch.common.model.DTOBase;
import com.pch.common.response.CommonResult;
import com.pch.user.model.dto.RoleDTO;
import com.pch.user.service.RoleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @description: 角色api
 * @author: pch
 * @date: 2020/09/13
 */
@RestController
@RequestMapping("/role")
@Api(tags = "角色管理")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    @ApiOperation("创建角色")
    public CommonResult<Long> create(@Validated @RequestBody RoleDTO roleDTO) {
        return CommonResult.success(roleService.create(roleDTO));
    }

    @PutMapping
    @ApiOperation("更新角色")
    public CommonResult<Long> update(
            @Validated({DTOBase.Update.class}) @RequestBody RoleDTO roleDTO) {
        return CommonResult.success(roleService.create(roleDTO));
    }

    @GetMapping("/{userId}")
    @ApiOperation("查询用户相关角色")
    public CommonResult<List<RoleDTO>> findRolesByUserId(@PathVariable Long userId) {
        return CommonResult.success(roleService.findRoleByUserId(userId));
    }

}
