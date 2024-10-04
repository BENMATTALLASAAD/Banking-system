package com.BWA.Banking.Web.Application.mapper.mapperImpl;

import java.util.List;
import java.util.stream.Collectors;

import com.BWA.Banking.Web.Application.dto.UserDto;
import com.BWA.Banking.Web.Application.mapper.UserMapper;
import com.BWA.Banking.Web.Application.model.User;

public class UserMapperImpl implements UserMapper{

    @Override
    public UserDto entityToDto(User userEntity) {
        if(userEntity == null){
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setUserFirstname(userEntity.getUserFirstname());
        userDto.setUserLastname(userEntity.getUserLastname());
        userDto.setEmail(userEntity.getEmail());
        userDto.setBirthday(userEntity.getBirthday());
        userDto.setGender(userEntity.getGender());
        userDto.setPassword(userEntity.getPassword());
        userDto.setPhoneNumber(userEntity.getPhoneNumber());
        userDto.setAdress(userEntity.getAdress());
        userDto.setRole(userEntity.getRole());
        return userDto;
    }

    @Override
    public User dtoToEntity(UserDto userDto) {
        User user = new User();
        user.setUserFirstname(userDto.getUserFirstname());
        user.setUserLastname(userDto.getUserLastname());
        user.setEmail(userDto.getEmail());
        user.setBirthday(userDto.getBirthday());
        user.setGender(userDto.getGender());
        user.setPassword(userDto.getPassword());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setAdress(userDto.getAdress());
        user.setRole(userDto.getRole());
        return user;
    }

    @Override
    public List<UserDto> entityToDtoList(List<User> userEntityList) {
        return userEntityList.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public List<User> dtoToEntityList(List<UserDto> userDtoList) {
        return userDtoList.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }
    
}
