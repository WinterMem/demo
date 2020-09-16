package com.pch.user.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import com.pch.common.mapper.BaseMapper;
import com.pch.user.model.domin.UserDO;
import com.pch.user.model.dto.UserDTO;

/**
 * @author: pch
 * @date: 2020/9/11
 */
@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends BaseMapper<UserDO, UserDTO> {

}
