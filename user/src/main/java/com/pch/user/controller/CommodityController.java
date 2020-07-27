package com.pch.user.controller;

import java.util.List;

import javax.validation.Valid;

import com.pch.user.common.CommonResult;
import com.pch.user.dto.CommodityDto;
import com.pch.user.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.pch.user.common.CommonResult.success;

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
    public CommonResult<Long> insertAllCommodity(@RequestBody @Valid CommodityDto commodityDto) {
        return success(commodityService.insertCommodity(commodityDto));
    }

}
