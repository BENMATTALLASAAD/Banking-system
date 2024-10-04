package com.BWA.Banking.Web.Application.service;

import java.util.List;

import com.BWA.Banking.Web.Application.dto.UserDto;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto updateUser(Long id,UserDto userDto);
    
    String deleteUser(Long id);

    List<UserDto> findAllUsers();

    UserDto findUserById(Long id);

}
