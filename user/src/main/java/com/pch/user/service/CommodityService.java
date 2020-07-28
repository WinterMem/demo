package com.pch.user.service;

import java.util.List;

import com.pch.user.dto.CommodityDto;

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
    Long insertCommodity(CommodityDto commodityDto);
}
