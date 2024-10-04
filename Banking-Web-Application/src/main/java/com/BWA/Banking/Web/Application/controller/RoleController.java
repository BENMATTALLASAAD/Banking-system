package com.BWA.Banking.Web.Application.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.BWA.Banking.Web.Application.dto.RoleDto;
import com.BWA.Banking.Web.Application.service.RoleService;

import lombok.RequiredArgsConstructor;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/role")
public class RoleController {
    
    private final RoleService rService;

    @PostMapping("/create")
    public RoleDto createRole(@RequestBody RoleDto roleDto){
        return rService.createRole(roleDto);
    }

    @GetMapping("/list")
    public List<RoleDto> findAllRoles(){
        return rService.findAllRoles();
    }

    @GetMapping("/{id}")
    public RoleDto findRoleById(@PathVariable Long id){
        return rService.findRoleById(id);
        
    }
    
    @PutMapping("/update/{id}")
    public RoleDto updateColab(@PathVariable Long id , @RequestBody RoleDto roleDto){
        return rService.updateRole(id, roleDto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRole(@PathVariable Long id){
        return rService.deleteRole(id);
    }
}
