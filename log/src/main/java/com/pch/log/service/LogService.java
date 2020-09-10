package com.pch.log.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pch.log.model.dto.LogDTO;

/**
 * @author: pch
 * @date: 2020/9/10
 */
public interface LogService {

    @Transactional
    Long save(LogDTO logDTO);

    List<LogDTO> findAll();
}
