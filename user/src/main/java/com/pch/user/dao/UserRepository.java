package com.pch.user.dao;

import java.util.Optional;

import com.pch.user.model.domin.UserDO;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserDO, Long> {

    Optional<UserDO> findByLoginName(String loginName);

    Integer countByEmail(String email);

    Integer countByTelephone(String telephone);
}
