package com.BWA.Banking.Web.Application.mapper.mapperImpl;

import java.util.List;
import java.util.stream.Collectors;

import com.BWA.Banking.Web.Application.dto.RoleDto;
import com.BWA.Banking.Web.Application.mapper.RoleMapper;
import com.BWA.Banking.Web.Application.model.Role;

public class RoleMapperImpl implements RoleMapper{

    @Override
    public RoleDto entityToDto(Role roleEntity) {
        if(roleEntity == null){
            return null;
        }
        RoleDto roleDto = new RoleDto();
        roleDto.setRoleName(roleEntity.getRoleName());
        roleDto.setRoleDescription(roleEntity.getRoleDescription());
        return roleDto;
    }

    @Override
    public Role dtoToEntity(RoleDto roleDto) {
        Role role = new Role();
        role.setRoleName(roleDto.getRoleName());
        role.setRoleDescription(roleDto.getRoleDescription());
        return role;
    }

    @Override
    public List<RoleDto> entityToDtoList(List<Role> roleEntityList) {
        return roleEntityList.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public List<Role> dtoToEntityList(List<RoleDto> roleDtoList) {
        return roleDtoList.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }
    
}
