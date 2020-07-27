package com.pch.user.service.impl;

import java.util.List;

import com.pch.user.convert.CommodityConvert;
import com.pch.user.dao.CommodityRepository;
import com.pch.user.dto.CommodityDto;
import com.pch.user.po.CommodityPO;
import com.pch.user.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityRepository commodityRepository;

    @Override
    public List<CommodityDto> queryAllCommodity() {
        Iterable<CommodityPO> all = commodityRepository.findAll();
        return CommodityConvert.CONVERT.COMMODITY_DTO_LIST(all);
    }

    @Override
    public Long insertCommodity(CommodityDto commodityDto) {
        CommodityPO save = commodityRepository
                .save(CommodityConvert.CONVERT.COMMODITY_PO(commodityDto));
        return save.getId();
    }
}
