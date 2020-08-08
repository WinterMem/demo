package com.pch.user.convert;

import java.util.Optional;

import com.pch.user.dto.UserDto;
import com.pch.user.po.UserPo;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConvert {

    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    @Mappings({})
    UserDto UserDTOCovert(Optional<UserPo> userPO);

    @Mappings({})
    UserPo userDtoToPoConvert(UserDto userDto);

}
