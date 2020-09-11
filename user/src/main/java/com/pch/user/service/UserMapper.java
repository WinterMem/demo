package com.pch.user.service;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.pch.log.mapper.BaseMapper;
import com.pch.user.model.domin.UserDO;
import com.pch.user.model.dto.UserDTO;

/**
 * @author: pch
 * @date: 2020/9/11
 */
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends BaseMapper<UserDO, UserDTO> {

}
