package com.pch.user.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pch.user.model.domin.UserDO;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserDO, Long> {

    Optional<UserDO> findByLoginName(String loginName);

    Integer countByEmail(String email);

    Integer countByTelephone(String telephone);

    List<UserDO> findAll();
}
