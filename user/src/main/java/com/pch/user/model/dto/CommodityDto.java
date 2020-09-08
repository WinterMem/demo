package com.pch.user.model.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 商品
 */
@Data
@Accessors(chain = true)
public class CommodityDto implements Serializable {

    private static final long serialVersionUID = 5788523262610242095L;

    /**
     * 商品名称
     */
    @ApiParam("商品名称")
    @NotEmpty(message = "shop name is not empty")
    private String name;

    /**
     * 商品价格
     */
    @ApiParam("商品价格")
    private Double price;

    /**
     * 库存
     */
    private Integer reserve;

}
