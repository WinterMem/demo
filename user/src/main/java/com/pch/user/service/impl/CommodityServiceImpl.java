package com.pch.user.service.impl;

import com.pch.user.convert.CommodityConvert;
import com.pch.user.dao.CommodityMapper;
import com.pch.user.dto.CommodityDto;
import com.pch.user.po.CommodityPO;
import com.pch.user.service.CommodityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityMapper commodityMapper;

    @Override
    public List<CommodityDto> queryAllCommodity() {
        Iterable<CommodityPO> all = commodityMapper.findAll();
        return CommodityConvert.CONVERT.COMMODITY_DTO_LIST(all);
    }

    @Override
    public Long insertCommodity(CommodityDto commodityDto) {
        CommodityPO save = commodityMapper
                .save(CommodityConvert.CONVERT.COMMODITY_PO(commodityDto));
        return save.getId();
    }
}
