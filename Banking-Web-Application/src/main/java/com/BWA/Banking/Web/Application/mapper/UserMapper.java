package com.BWA.Banking.Web.Application.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.BWA.Banking.Web.Application.dto.UserDto;
import com.BWA.Banking.Web.Application.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDto entityToDto(User userEntity);
    User dtoToEntity(UserDto userDto);
    List<UserDto> entityToDtoList(List<User> userEntityList);
    List<User> dtoToEntityList(List<UserDto> userDtoList);

}
