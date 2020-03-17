package com.pch.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pch.user.common.CommonResult;
import com.pch.user.dto.CommodityDto;
import com.pch.user.service.CommodityService;

import static com.pch.user.common.CommonResult.success;

@RestController
@RequestMapping("/commodity")
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    @GetMapping("/queryAllCommodity")
    public CommonResult<List<CommodityDto>> queryAllCommodity() {
        return success(commodityService.queryAllCommodity());
    }

    @GetMapping("/insertAllCommodity")
    public CommonResult<Integer> insertAllCommodity(CommodityDto commodityDto) {
        return success(commodityService.insertCommodity(commodityDto));
    }

}
