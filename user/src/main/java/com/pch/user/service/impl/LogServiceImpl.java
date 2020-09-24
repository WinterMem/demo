package com.pch.user.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.pch.user.model.domin.LogDO;
import com.pch.user.model.dto.LogDTO;
import com.pch.user.repository.LogRepository;
import com.pch.user.service.LogService;
import com.pch.user.service.mapper.LogMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: pch
 * @date: 2020/9/10
 */
@Service
@Slf4j
public class LogServiceImpl implements LogService {

    @Autowired
    private LogRepository logRepository;
    @Autowired
    private LogMapper logMapper;

    @Async
    public void asyncSave(LogDTO logDTO) {
        logRepository.save(logMapper.toDto(logDTO));
    }

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
