package com.pch.user.dao;

import com.pch.user.po.CommodityPO;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommodityMapper extends PagingAndSortingRepository<CommodityPO, Long> {


}
