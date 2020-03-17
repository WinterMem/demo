package com.pch.user.po;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 商品
 */
@Data
@Accessors(chain = true)
public class CommodityPO implements Serializable {

    private static final long serialVersionUID = 5788523262610242095L;

    private Integer id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品价格
     */
    private Double price;

    /**
     * 库存
     */
    private Integer reserve;

//    privat
}
