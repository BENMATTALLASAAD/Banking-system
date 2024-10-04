package com.BWA.Banking.Web.Application.service;

import java.util.List;

import com.BWA.Banking.Web.Application.dto.AccountDto;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    AccountDto updateAccount(Long id,AccountDto accountDto);
    
    String deleteAccount(Long id);

    List<AccountDto> findAllAccounts();

    AccountDto findAccountById(Long id);
}
