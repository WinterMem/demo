package com.pch.user.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pch.user.po.CommodityPO;

import org.springframework.stereotype.Repository;

@Repository
public interface CommodityMapper extends BaseMapper<CommodityPO> {

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
