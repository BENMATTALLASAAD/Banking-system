package com.BWA.Banking.Web.Application.dto;

import java.time.LocalDateTime;

import com.BWA.Banking.Web.Application.model.Account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {
    private Long id;

    private Account fromAccount;

    private Account toAccount;
    
    private double amount;
   
    private LocalDateTime timestamp;
}
