package com.BWA.Banking.Web.Application.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.BWA.Banking.Web.Application.dto.TransactionDto;
import com.BWA.Banking.Web.Application.mapper.TransactionMapper;
import com.BWA.Banking.Web.Application.model.Transaction;
import com.BWA.Banking.Web.Application.repository.TransactionRepository;
import com.BWA.Banking.Web.Application.service.TransactionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService{

    private final TransactionRepository tRepository;
    private final TransactionMapper tMapper;

    @Override
    public TransactionDto createTransaction(TransactionDto transactionDto) {
        Transaction transaction = tMapper.dtoToEntity(transactionDto);
        if(transaction != null){
            tRepository.save(transaction);
            return transactionDto;
        }
        return null;
    }

    @Override
    public TransactionDto updateTransaction(Long id, TransactionDto transactionDto) {
        if(tRepository.findById(id).isPresent()){
            Transaction existingTransaction = tRepository.findById(id).get();
            existingTransaction.setAmount(transactionDto.getAmount());
            existingTransaction.setFromAccount(transactionDto.getFromAccount());
            existingTransaction.setToAccount(transactionDto.getToAccount());
            Transaction updatedTransaction = tRepository.save(existingTransaction);
            return tMapper.entityToDto(updatedTransaction);
        }
        return null;
    }

    @Override
    public String deleteTransaction(Long id) {
        tRepository.deleteById(id);
        return "Transaction deleted";
    }

    @Override
    public List<TransactionDto> findAllTransactions() {
        List<Transaction> transactions=tRepository.findAll();
        return tMapper.entityToDtoList(transactions);  
    }

    @Override
    public TransactionDto findTransactionById(Long id) {
        Optional <Transaction> transaction= tRepository.findById(id);
        if(transaction.isPresent()){
            return tMapper.entityToDto(transaction.get());
        }
        return null;
    }
    
}
