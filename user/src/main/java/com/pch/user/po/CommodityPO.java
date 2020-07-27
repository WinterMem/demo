package com.pch.user.po;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 商品
 */
@Data
@Entity
@Accessors(chain = true)
@Table(name = "tb_commodity")
public class CommodityPO implements Serializable {

    private static final long serialVersionUID = 5788523262610242095L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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
