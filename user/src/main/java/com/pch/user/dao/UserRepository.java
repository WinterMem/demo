package com.pch.user.dao;

import java.util.Optional;

import com.pch.user.po.UserPO;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserPO, Long> {

    Optional<UserPO> findByLoginName(String loginName);

    Integer countByEmailOrTelephone(String email, String telephone);
}
