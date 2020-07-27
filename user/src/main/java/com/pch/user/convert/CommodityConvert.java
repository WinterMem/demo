package com.pch.user.convert;

import java.util.List;

import com.pch.user.dto.CommodityDto;
import com.pch.user.po.CommodityPO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 商品转化类
 */
@Mapper
public interface CommodityConvert {

    CommodityConvert CONVERT = Mappers.getMapper(CommodityConvert.class);

    /**
     * po => dto
     *
     * @param commodityPOList
     * @return dto list集合
     */
    @Mappings({})
    List<CommodityDto> COMMODITY_DTO_LIST(Iterable<CommodityPO> commodityPOList);

    /**
     * dto => po
     *
     * @param commodityDto
     * @return po实例
     */
    @Mappings({})
    CommodityPO COMMODITY_PO(CommodityDto commodityDto);
}
