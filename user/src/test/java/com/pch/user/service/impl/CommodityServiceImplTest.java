package com.pch.user.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pch.user.dto.CommodityDto;
import com.pch.user.service.CommodityService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CommodityServiceImplTest {

    @Autowired
    private CommodityService commodityService;

    @Test
    public void queryAllCommodity() {
    }

    @Test
    public void insertCommodity() {
        CommodityDto commodityDto = new CommodityDto();
        commodityDto.setName("原味薯片").setPrice(5.0d).setReserve(100);
        int i = commodityService.insertCommodity(commodityDto);
    }
}