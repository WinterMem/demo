package com.pch.user.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.pch.common.mapper.BaseMapper;
import com.pch.user.model.domin.LogDO;
import com.pch.user.model.dto.LogDTO;

/**
 * @author: pch
 * @date: 2020/9/10
 */
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LogMapper extends BaseMapper<LogDO, LogDTO> {


}
