package com.pch.user.model.domin;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.pch.common.model.DOBase;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 菜单实体
 * @author: pch
 * @date: 2020/9/10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tb_menu")
public class MenuDOBase extends DOBase {

    private static final long serialVersionUID = -8809441423776369114L;

    /**
     * 菜单标题
     */
    private String title;

    /**
     * 菜单组件名称
     */
    private String componentName;

    /**
     * 排序
     */
    private Integer menuSort = 999;

    /**
     * 组件路径
     */
    private String component;

    /**
     * 路由地址
     */
    private String path;

    /**
     * 菜单类型，目录、菜单、按钮
     */
    private Integer type;

    /**
     * 权限标识
     */
    private String permission;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 缓存
     */
    private Boolean cache;

    /**
     * 是否隐藏
     */
    private Boolean hidden;

    /**
     * 上级菜单
     */
    private Long pid;

    /**
     * 外链菜单
     */
    private Boolean iFrame;



}
