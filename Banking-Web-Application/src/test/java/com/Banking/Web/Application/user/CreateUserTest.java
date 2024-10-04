package com.Banking.Web.Application.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.Calendar;


import com.BWA.Banking.Web.Application.dto.UserDto;
import com.BWA.Banking.Web.Application.mapper.UserMapper;
import com.BWA.Banking.Web.Application.model.Role;
import com.BWA.Banking.Web.Application.model.User;
import com.BWA.Banking.Web.Application.repository.RoleRepository;
import com.BWA.Banking.Web.Application.repository.UserRepository;
import com.BWA.Banking.Web.Application.service.serviceImpl.UserServiceImpl;

public class CreateUserTest {
    @InjectMocks
    private UserServiceImpl userService;  // Service to test
    
    @Mock
    private UserRepository userRepository;    // Mock repository

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private UserMapper userMapper;  // Mock mapper

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);  // Initialize mocks
    }

    @Test
    public void testCreateUser(){
        User user = new User();
        user.setUserFirstname("User Firstname");
        user.setUserLastname("User Lastname");
        user.setEmail("User@email.com");
        
        Role role = new Role();
        role.setRoleName("User");

        Calendar calendar = Calendar.getInstance();
        calendar.set(1990, Calendar.MAY, 25);
        Date birthday = (Date) calendar.getTime();
        user.setBirthday(birthday);
        user.setPassword("123456");
        user.setGender("M");
        user.setRole(role);
        user.setPhoneNumber("0123456789");

        UserDto userDTO = new UserDto();
        userDTO.setUserFirstname("User Firstname");
        userDTO.setUserLastname("User Lastname");
        userDTO.setEmail("User@email.com");
        userDTO.setBirthday(birthday);
        userDTO.setPassword("123456");
        userDTO.setGender("M");
        userDTO.setRole(role);
        userDTO.setPhoneNumber("0123456789");
        
        
        when(roleRepository.findByRoleName("User")).thenReturn(role);
        when(userMapper.dtoToEntity(userDTO)).thenReturn(user);
        when(userRepository.save(user)).thenReturn(user);
        when(userMapper.entityToDto(any(User.class))).thenReturn(userDTO);


        UserDto createUserDto = userService.createUser(userDTO);

        assertEquals(userDTO, createUserDto);

        verify(userMapper).dtoToEntity(userDTO);
        verify(userRepository).save(user);
    }
}