package com.Banking.Web.Application.role;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.BWA.Banking.Web.Application.dto.RoleDto;
import com.BWA.Banking.Web.Application.mapper.RoleMapper;
import com.BWA.Banking.Web.Application.model.Role;
import com.BWA.Banking.Web.Application.repository.RoleRepository;
import com.BWA.Banking.Web.Application.service.serviceImpl.RoleServiceImpl;

public class CreateRoleTest {

    @InjectMocks
    private RoleServiceImpl roleService;  // Service to test
    
    @Mock
    private RoleRepository roleRepository;    // Mock repository

    @Mock
    private RoleMapper roleMapper;  // Mock mapper


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);  // Initialize mocks
    }

    @Test
    public void testCreateRole(){
        Role role = new Role();
        role.setRoleName("User");
        role.setRoleDescription("User of the banking system");

        // Create a RoleDTO object
        RoleDto roleDto = new RoleDto();
        roleDto.setRoleName("User");
        roleDto.setRoleDescription("User of the banking system");

        // Define the behavior of the mapper and repository
        when(roleMapper.dtoToEntity(roleDto)).thenReturn(role);
        when(roleRepository.save(role)).thenReturn(role);
        when(roleMapper.entityToDto(role)).thenReturn(roleDto);

        // Act: Call the service method to test
        RoleDto createdRoleDTO = roleService.createRole(roleDto);

        // Assert: Verify the roleDTO is returned with correct data
        assertEquals("User", createdRoleDTO.getRoleName());
        assertEquals("User of the banking system", createdRoleDTO.getRoleDescription());

        // Verify that the repository's save method and mapper were called
        verify(roleMapper).dtoToEntity(roleDto);
        verify(roleRepository).save(role);
        
    }

}
