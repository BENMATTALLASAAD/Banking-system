package com.BWA.Banking.Web.Application.service.serviceImpl;

import java.util.List;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.BWA.Banking.Web.Application.dto.AccountDto;
import com.BWA.Banking.Web.Application.mapper.AccountMapper;
import com.BWA.Banking.Web.Application.model.Account;
import com.BWA.Banking.Web.Application.repository.AccountRepository;
import com.BWA.Banking.Web.Application.service.AccountService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepository aRepository;
    private final AccountMapper aMapper;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account=aMapper.dtoToEntity(accountDto);
        if(account != null){
            aRepository.save(account);
            return accountDto;
        }
        return null;
    }

    @Override
    public AccountDto updateAccount(Long id, AccountDto accountDto) {
        if (aRepository.findById(id).isPresent()) {
            Account existingAccount = aRepository.findById(id).get();
            existingAccount.setAccountNumber(accountDto.getAccountNumber());
            existingAccount.setBalance(accountDto.getBalance());
            existingAccount.setUser(accountDto.getUser());
            Account updatedAccount =aRepository.save(existingAccount);
            return aMapper.entityToDto(updatedAccount);
        }
        return null;
    }

    @Override
    public String deleteAccount(Long id) {
        aRepository.deleteById(id);
        return "Account deleted";
    }

    @Override
    public List<AccountDto> findAllAccounts() {
        List<Account> accounts = aRepository.findAll();
        return aMapper.entityToDtoList(accounts);
    }

    @Override
    public AccountDto findAccountById(Long id) {
        Optional<Account> account= aRepository.findById(id);
        if (account.isPresent()) {
            return aMapper.entityToDto(account.get());
        }
        return null;
    }
    
}
