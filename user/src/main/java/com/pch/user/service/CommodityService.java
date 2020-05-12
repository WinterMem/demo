package com.pch.user.service;

import com.pch.user.dto.CommodityDto;

import java.util.List;

public interface CommodityService {

    /**
     * 查询所有商品
     *
     * @return 商品集合
     */
    List<CommodityDto> queryAllCommodity();

    /**
     * 添加商品
     *
     * @return 成功 > 0
     */
    int insertCommodity(CommodityDto commodityDto);
}
