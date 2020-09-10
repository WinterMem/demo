package com.pch.common.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: pch
 * @date: 2020/9/10
 */
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseDO implements Serializable {

    private static final long serialVersionUID = -6187240064997916904L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedBy
    @Column(name = "create_by", updatable = false)
    @ApiModelProperty(value = "创建人", hidden = true)
    private String createBy;

    @LastModifiedBy
    @Column(name = "update_by")
    @ApiModelProperty(value = "更新人", hidden = true)
    private String updatedBy;

    @CreationTimestamp
    @Column(name = "create_time", updatable = false)
    @ApiModelProperty(value = "创建时间", hidden = true)
    private LocalDateTime createTime;

    @UpdateTimestamp
    @Column(name = "update_time")
    @ApiModelProperty(value = "更新时间", hidden = true)
    private LocalDateTime updateTime;

    @Version
    private Integer version;

    public @interface Insert{}

    public @interface Update{}


}
