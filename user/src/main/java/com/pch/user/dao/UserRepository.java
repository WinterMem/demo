package com.pch.user.dao;

import java.util.Optional;

import com.pch.user.model.po.UserPo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserPo, Long> {

    Optional<UserPo> findByLoginName(String loginName);

    Integer countByEmail(String email);

    Integer countByTelephone(String telephone);
}
