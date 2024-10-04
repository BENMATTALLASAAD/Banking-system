package com.BWA.Banking.Web.Application.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BWA.Banking.Web.Application.dto.UserDto;
import com.BWA.Banking.Web.Application.service.UserService;

import lombok.RequiredArgsConstructor;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    public final UserService uService;

    @PostMapping("/create")
    public UserDto createBooking(@RequestBody UserDto userDto) {
        return uService.createUser(userDto);
    }

    @GetMapping("/list")
    public List<UserDto> findAllRoles(){
        return uService.findAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto findRoleById(@PathVariable Long id){
        return uService.findUserById(id);
        
    }
    
    @PutMapping("/update/{id}")
    public UserDto updateColab(@PathVariable Long id , @RequestBody UserDto userDto){
        return uService.updateUser(id, userDto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRole(@PathVariable Long id){
        return uService.deleteUser(id);
    }
    
}
