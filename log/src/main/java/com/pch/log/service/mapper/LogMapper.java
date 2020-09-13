package com.pch.log.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.pch.log.mapper.BaseMapper;
import com.pch.log.model.domin.LogDO;
import com.pch.log.model.dto.LogDTO;

/**
 * @author: pch
 * @date: 2020/9/10
 */
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LogMapper extends BaseMapper<LogDO, LogDTO> {


}
