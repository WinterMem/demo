package com.pch.user.convert;

import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.pch.user.dto.UserDTO;
import com.pch.user.po.UserPO;

@Mapper
public interface UserConvert {

    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    @Mappings({})
    UserDTO UserDTOCovert(UserPO userPO);

    @Mappings({})
    UserPO userDtoToPoConvert(UserDTO userDTO);

}
