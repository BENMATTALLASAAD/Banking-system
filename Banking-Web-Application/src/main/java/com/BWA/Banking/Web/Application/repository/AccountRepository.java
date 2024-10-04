package com.BWA.Banking.Web.Application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BWA.Banking.Web.Application.model.Account;

public interface AccountRepository extends JpaRepository<Account,Long>{
    
}
