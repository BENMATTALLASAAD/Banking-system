package com.BWA.Banking.Web.Application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.BWA.Banking.Web.Application.model.Role;

public interface RoleRepository extends JpaRepository<Role,Long>{
    Role findByRoleName(String roleName);
}
