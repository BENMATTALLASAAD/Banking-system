package com.BWA.Banking.Web.Application.dto;

import com.BWA.Banking.Web.Application.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private Long id;

    private Long accountNumber;

    private double balance;

    private User user;
}
