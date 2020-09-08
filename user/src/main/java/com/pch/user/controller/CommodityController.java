package com.pch.user.controller;

import static com.pch.common.response.CommonResult.success;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pch.common.response.CommonResult;
import com.pch.user.model.dto.CommodityDto;
import com.pch.user.service.CommodityService;

@RestController
@RequestMapping("/commodity")
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    @GetMapping
    public CommonResult<List<CommodityDto>> queryAllCommodity() {
        return success(commodityService.queryAllCommodity());
    }

    @PostMapping
    public CommonResult<Long> insertAllCommodity(@RequestBody @Validated CommodityDto commodityDto) {
        return success(commodityService.insertCommodity(commodityDto));
    }

}
