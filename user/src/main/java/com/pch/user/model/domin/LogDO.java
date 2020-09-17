package com.pch.user.model.domin;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.mongodb.core.mapping.Document;

import com.pch.common.model.DOBase;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author: pch
 * @date: 2020/9/10
 */
@Getter
@Setter
@NoArgsConstructor
@Document("tb_log")
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class LogDO extends DOBase {

    private static final long serialVersionUID = -6949766987335754417L;

    /** 操作用户 */
    private String username;

    /** 描述 */
    private String description;

    /** 方法名 */
    private String method;

    /** 参数 */
    private String params;

    /** 日志类型 */
    private String logType;

    /** 请求ip */
    private String requestIp;

    /** 地址 */
    private String address;

    /** 浏览器  */
    private String browser;

    /** 请求耗时 */
    private Long time;

    /** 异常详细  */
    private byte[] exceptionDetail;

    /** 创建日期 */
    @CreationTimestamp
    private LocalDateTime createTime;
}
