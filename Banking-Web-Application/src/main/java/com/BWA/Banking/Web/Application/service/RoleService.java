package com.BWA.Banking.Web.Application.service;

import java.util.List;

import com.BWA.Banking.Web.Application.dto.RoleDto;
import com.BWA.Banking.Web.Application.model.Role;


public interface RoleService {

    RoleDto createRole(RoleDto roleDto);

    RoleDto updateRole(Long id,RoleDto roleDto);
    
    String deleteRole(Long id);

    List<RoleDto> findAllRoles();

    RoleDto findRoleById(Long id);

    public Role findRoleByName(String roleName);
}
