package com.BWA.Banking.Web.Application.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BWA.Banking.Web.Application.dto.AccountDto;
import com.BWA.Banking.Web.Application.service.AccountService;

import lombok.RequiredArgsConstructor;


@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService aService;

    @PostMapping("/create")
    public AccountDto createTransaction(@RequestBody AccountDto accountDto){
        return aService.createAccount(accountDto);
    }

    @GetMapping("/list")
    public List<AccountDto> findAllTransactions(){
        return aService.findAllAccounts();
    }
    
    @PutMapping("/update/{id}")
    public AccountDto updateTransaction(@PathVariable Long id , @RequestBody AccountDto accountDto){
        return aService.updateAccount(id, accountDto);
    }

    @GetMapping("/{id}")
    public AccountDto findTransaction(@PathVariable Long id){
        return aService.findAccountById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTransaction(@PathVariable Long id){
        return aService.deleteAccount(id);
    }
}
