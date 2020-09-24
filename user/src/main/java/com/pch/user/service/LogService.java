package com.pch.user.service;

import java.util.List;

import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;

import com.pch.user.model.dto.LogDTO;

/**
 * @author: pch
 * @date: 2020/9/10
 */
public interface LogService {

    @Async
    @Transactional
    void asyncSave(LogDTO logDTO);

    List<LogDTO> findAll();

    @Transactional
    Long save(LogDTO logDTO) ;
}
