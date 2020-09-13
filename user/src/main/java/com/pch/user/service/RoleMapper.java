package com.pch.user.service;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import com.pch.log.mapper.BaseMapper;
import com.pch.user.model.domin.RoleDO;
import com.pch.user.model.dto.RoleDTO;

/**
 * @description:
 * @author: pch
 * @date: 2020/09/13
 */
@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper extends BaseMapper<RoleDO, RoleDTO> {

}
