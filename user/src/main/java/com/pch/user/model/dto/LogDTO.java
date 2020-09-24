package com.pch.user.model.dto;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: pch
 * @date: 2020/9/10
 */
@Data
@Accessors(chain = true)
@ApiModel("日志模型")
public class LogDTO {

    private Long id;

    /** 操作用户 */
    private String username;

    /** 用户id */
    private Long userId;

    /** 描述 */
    private String description;

    /** 方法名 */
    private String method;

    /** 参数 */
    private String params;

    /** 日志类型 */
    private String logType;

    /** 请求ip */
    private String ip;

    /** 地址 */
    private String address;

    /** 浏览器  */
    private String browser;

    /** 请求耗时 */
    private Long time;

    /** 异常详细  */
    private byte[] exceptionDetail;

    /** 创建日期 */
    private LocalDateTime createTime;

}
