package com.BWA.Banking.Web.Application.service.serviceImpl;

import java.util.List;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.BWA.Banking.Web.Application.dto.RoleDto;
import com.BWA.Banking.Web.Application.mapper.RoleMapper;
import com.BWA.Banking.Web.Application.model.Role;
import com.BWA.Banking.Web.Application.repository.RoleRepository;
import com.BWA.Banking.Web.Application.service.RoleService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService{
    
    private final RoleRepository rRepository;
    private final RoleMapper rMapper;

    @Override
    public RoleDto createRole(RoleDto roleDto) {
        Role role=rMapper.dtoToEntity(roleDto);
        if(role != null){
            rRepository.save(role);
            return roleDto;
        }
        return null;
    }

    @Override
    public RoleDto updateRole(Long id, RoleDto roleDto) {
        if (rRepository.findById(id).isPresent()) {
            Role existingRole = rRepository.findById(id).get();
            existingRole.setRoleName(roleDto.getRoleName());
            existingRole.setRoleDescription(roleDto.getRoleDescription());
            Role updatedRole =rRepository.save(existingRole);
            return rMapper.entityToDto(updatedRole);
        }
        return null;
    }

    @Override
    public String deleteRole(Long id) {
        rRepository.deleteById(id);
        return "Role deleted";
    }

    @Override
    public List<RoleDto> findAllRoles() {
        List<Role> roles = rRepository.findAll();
        return rMapper.entityToDtoList(roles);
    }

    @Override
    public RoleDto findRoleById(Long id) {
        Optional<Role> role= rRepository.findById(id);
        if (role.isPresent()) {
            return rMapper.entityToDto(role.get());
        }
        return null;
    }

    @Override
    public Role findRoleByName(String roleName) {
        // Retrieve role by roleName using the repository
        Role role = rRepository.findByRoleName(roleName);
        return role;
    }



    
}
