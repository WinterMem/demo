package com.pch.user.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pch.user.model.domin.LogDO;

/**
 * @author: pch
 * @date: 2020/9/10
 */
public interface LogRepository extends MongoRepository<LogDO, Long> {

    List<LogDO> findAll();
}
