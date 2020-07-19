package com.pch.user.convert;

import com.pch.user.dto.UserDTO;
import com.pch.user.po.UserPO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConvert {

	UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

	@Mappings({})
	UserDTO UserDTOCovert(UserPO userPO);

	@Mappings({})
	UserPO userDtoToPoConvert(UserDTO userDTO);

}
