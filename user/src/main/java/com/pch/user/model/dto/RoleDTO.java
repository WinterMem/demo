package com.pch.user.model.dto;

import javax.validation.constraints.NotBlank;

import com.pch.common.model.DTOBase;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @description: 角色dto模型
 * @author: pch
 * @date: 2020/09/13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("角色模型")
@Accessors(chain = true)
public class RoleDTO extends DTOBase {

    private static final long serialVersionUID = -2091646178325109751L;

    @NotBlank(message = "role name is not be blank")
    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("启用禁用")
    private Boolean enable;

    @ApiModelProperty("创建人")
    private String createBy;


}
