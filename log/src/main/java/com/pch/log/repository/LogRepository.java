package com.pch.log.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.pch.log.model.domin.LogDOBase;

/**
 * @author: pch
 * @date: 2020/9/10
 */
public interface LogRepository extends PagingAndSortingRepository<LogDOBase, Long> {

    List<LogDOBase> findAll();
}
