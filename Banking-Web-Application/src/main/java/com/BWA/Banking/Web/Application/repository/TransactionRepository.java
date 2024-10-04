package com.BWA.Banking.Web.Application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BWA.Banking.Web.Application.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,Long>{
    
}
