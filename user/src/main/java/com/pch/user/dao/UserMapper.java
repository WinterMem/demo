package com.pch.user.dao;

import com.pch.user.po.UserPO;
import java.util.Optional;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends PagingAndSortingRepository<UserPO, Long> {

    Optional<UserPO> findByLoginName(String loginName);

    Integer countByEmailOrTelephone(String email, String telephone);
}
