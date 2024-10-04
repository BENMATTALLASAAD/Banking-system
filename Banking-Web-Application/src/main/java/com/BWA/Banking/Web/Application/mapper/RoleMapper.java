package com.BWA.Banking.Web.Application.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.BWA.Banking.Web.Application.dto.RoleDto;
import com.BWA.Banking.Web.Application.model.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
    RoleDto entityToDto(Role roleEntity);
    Role dtoToEntity(RoleDto roleDto);
    List<RoleDto> entityToDtoList(List<Role> roleEntityList);
    List<Role> dtoToEntityList(List<RoleDto> roleDtoList);
}
