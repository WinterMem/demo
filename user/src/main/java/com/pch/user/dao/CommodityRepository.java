package com.pch.user.dao;

import com.pch.user.model.po.CommodityPo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommodityRepository extends PagingAndSortingRepository<CommodityPo, Long> {


}
