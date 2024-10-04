package com.BWA.Banking.Web.Application.mapper.mapperImpl;

import java.util.List;
import java.util.stream.Collectors;

import com.BWA.Banking.Web.Application.dto.AccountDto;
import com.BWA.Banking.Web.Application.mapper.AccountMapper;
import com.BWA.Banking.Web.Application.model.Account;

public class AccountMapperImpl implements AccountMapper{

    @Override
    public AccountDto entityToDto(Account accountEntity) {
        if(accountEntity == null){
            return null;
        }
        AccountDto accountDto = new AccountDto();
        accountDto.setAccountNumber(accountEntity.getAccountNumber());
        accountDto.setBalance(accountEntity.getBalance());
        accountDto.setUser(accountEntity.getUser());
        return accountDto;
    }

    @Override
    public Account dtoToEntity(AccountDto accountDto) {
        Account account = new Account();
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setBalance(accountDto.getBalance());
        account.setUser(accountDto.getUser());
        return account;
    }

    @Override
    public List<AccountDto> entityToDtoList(List<Account> accountEntityList) {
        return accountEntityList.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public List<Account> dtoToEntityList(List<AccountDto> accountDtoList) {
        return accountDtoList.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }
    
}
