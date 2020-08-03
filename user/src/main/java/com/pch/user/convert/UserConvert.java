package com.pch.user.convert;

import java.util.Optional;

import com.pch.user.dto.UserDTO;
import com.pch.user.po.UserPO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConvert {

    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    @Mappings({})
    UserDTO UserDTOCovert(Optional<UserPO> userPO);

    @Mappings({})
    UserPO userDtoToPoConvert(UserDTO userDTO);

}
