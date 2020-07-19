package com.pch.user.service.impl;

import java.util.List;

import com.pch.user.convert.CommodityConvert;
import com.pch.user.dao.CommodityMapper;
import com.pch.user.dto.CommodityDto;
import com.pch.user.exception.ServiceException;
import com.pch.user.po.CommodityPO;
import com.pch.user.service.CommodityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommodityServiceImpl implements CommodityService {

	@Autowired
	private CommodityMapper commodityMapper;

	@Override
	public List<CommodityDto> queryAllCommodity() {
		if (true) {
			throw new ServiceException(100L, "ceshi");
		}
		List<CommodityPO> commodityPOS = commodityMapper.queryAllCommodity();
		return CommodityConvert.CONVERT.COMMODITY_DTO_LIST(commodityPOS);
	}

	@Override
	public int insertCommodity(CommodityDto commodityDto) {
		return commodityMapper.insertCommodity(CommodityConvert.CONVERT.COMMODITY_PO(commodityDto));
	}
}
