package com.pch.user.convert;

import java.util.Optional;

import com.pch.user.model.domin.UserDO;
import com.pch.user.model.dto.UserDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConvert {

    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    @Mappings({})
    UserDTO UserDTOCovert(Optional<UserDO> userPO);

    @Mappings({})
    UserDO userDtoToPoConvert(UserDTO userDto);

}
