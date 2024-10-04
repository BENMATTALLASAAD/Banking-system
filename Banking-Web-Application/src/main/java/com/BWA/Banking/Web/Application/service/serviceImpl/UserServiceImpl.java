package com.BWA.Banking.Web.Application.service.serviceImpl;

import java.util.List;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.BWA.Banking.Web.Application.dto.UserDto;
import com.BWA.Banking.Web.Application.mapper.UserMapper;
import com.BWA.Banking.Web.Application.model.User;
import com.BWA.Banking.Web.Application.repository.UserRepository;
import com.BWA.Banking.Web.Application.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository uRepository;
    private final UserMapper uMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user=uMapper.dtoToEntity(userDto);
        if(user != null){
            uRepository.save(user);
            return userDto;
        }
        return null;
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        if (uRepository.findById(id).isPresent()) {
            User existingUser = uRepository.findById(id).get();
            existingUser.setUserFirstname(userDto.getUserFirstname());
            existingUser.setUserLastname(userDto.getUserLastname());
            existingUser.setEmail(userDto.getEmail());
            existingUser.setBirthday(userDto.getBirthday());
            existingUser.setGender(userDto.getGender());
            existingUser.setPassword(userDto.getPassword());
            existingUser.setPhoneNumber(userDto.getPhoneNumber());
            existingUser.setAdress(userDto.getAdress());
            existingUser.setRole(userDto.getRole());
            User updatedUser =uRepository.save(existingUser);
            return uMapper.entityToDto(updatedUser);
            

        }
        return null;
    }

    @Override
    public String deleteUser(Long id) {
        uRepository.deleteById(id);
        return "User deleted";
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = uRepository.findAll();
        return uMapper.entityToDtoList(users);
    }

    @Override
    public UserDto findUserById(Long id) {
        Optional<User> user= uRepository.findById(id);
        if (user.isPresent()) {
            return uMapper.entityToDto(user.get());
        }
        return null;
    }

}
