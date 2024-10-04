package com.BWA.Banking.Web.Application.service;

import java.util.List;

import com.BWA.Banking.Web.Application.dto.TransactionDto;

public interface TransactionService {

    TransactionDto createTransaction(TransactionDto transactionDto);

    TransactionDto updateTransaction(Long id,TransactionDto transactionDto);
    
    String deleteTransaction(Long id);

    List<TransactionDto> findAllTransactions();

    TransactionDto findTransactionById(Long id);
}
