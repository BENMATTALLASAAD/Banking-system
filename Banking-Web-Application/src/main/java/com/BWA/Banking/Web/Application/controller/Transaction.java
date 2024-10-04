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

import com.BWA.Banking.Web.Application.dto.TransactionDto;
import com.BWA.Banking.Web.Application.service.TransactionService;

import lombok.RequiredArgsConstructor;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/transaction")
public class Transaction {
    private final TransactionService tService;

    @PostMapping("/create")
    public TransactionDto createTransaction(@RequestBody TransactionDto transactionDto){
        return tService.createTransaction(transactionDto);
    }

    @GetMapping("/list")
    public List<TransactionDto> findAllTransactions(){
        return tService.findAllTransactions();
    }
    
    @PutMapping("/update/{id}")
    public TransactionDto updateTransaction(@PathVariable Long id , @RequestBody TransactionDto transactionDto){
        return tService.updateTransaction(id, transactionDto);
    }

    @GetMapping("/{id}")
    public TransactionDto findTransaction(@PathVariable Long id){
        return tService.findTransactionById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTransaction(@PathVariable Long id){
        return tService.deleteTransaction(id);
    }
    
}
