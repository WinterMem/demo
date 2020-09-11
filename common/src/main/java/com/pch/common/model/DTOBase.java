package com.pch.common.model;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author: pch
 * @date: 2020/9/11
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class DTOBase implements Serializable {

    private static final long serialVersionUID = 1669987249741375694L;

    @NotEmpty(groups = Update.class)
    private Long id;

    public @interface Insert{}

    public @interface Update{}

}
