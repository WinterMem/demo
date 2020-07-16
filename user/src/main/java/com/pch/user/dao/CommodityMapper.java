package com.pch.user.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pch.user.po.CommodityPO;

@Repository
public interface CommodityMapper extends com.baomidou.mybatisplus.core.mapper.BaseMapper<CommodityPO> {

    /**
     * 查询所有商品
     *
     * @return 商品集合
     */
    List<CommodityPO> queryAllCommodity();

    /**
     * 添加商品
     *
     * @return 成功 > 0
     */
    int insertCommodity(CommodityPO commodityPO);
}
