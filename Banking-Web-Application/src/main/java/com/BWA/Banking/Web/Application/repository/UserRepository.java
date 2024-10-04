package com.BWA.Banking.Web.Application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BWA.Banking.Web.Application.model.User;

public interface UserRepository extends JpaRepository<User,Long>{
    
}
