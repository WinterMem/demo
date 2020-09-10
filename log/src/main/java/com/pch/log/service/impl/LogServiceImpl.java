package com.pch.log.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pch.log.model.domin.LogDO;
import com.pch.log.model.dto.LogDTO;
import com.pch.log.repository.LogRepository;
import com.pch.log.service.LogService;
import com.pch.log.service.mapper.LogMapper;

/**
 * @author: pch
 * @date: 2020/9/10
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogRepository logRepository;
    @Autowired
    private LogMapper logMapper;

    @Override
    public List<LogDTO> findAll() {
        List<LogDO> all = logRepository.findAll();
        return all.stream().map(logDO -> logMapper.toEntity(logDO)).collect(Collectors.toList());
    }

    @Override
    public Long save(LogDTO logDTO) {
        LogDO logDO = logMapper.toDto(logDTO);
        LogDO save = logRepository.save(logDO);
        return save.getId();
    }

}
