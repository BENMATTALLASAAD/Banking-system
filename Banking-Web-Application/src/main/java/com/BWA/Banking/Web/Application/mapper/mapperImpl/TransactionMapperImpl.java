package com.BWA.Banking.Web.Application.mapper.mapperImpl;

import java.util.List;
import java.util.stream.Collectors;

import com.BWA.Banking.Web.Application.dto.TransactionDto;
import com.BWA.Banking.Web.Application.mapper.TransactionMapper;
import com.BWA.Banking.Web.Application.model.Transaction;

public class TransactionMapperImpl implements TransactionMapper{

    @Override
    public TransactionDto entityToDto(Transaction transactionEntity) {
        if(transactionEntity == null){
            return null;
        }
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setAmount(transactionEntity.getAmount());
        transactionDto.setFromAccount(transactionEntity.getFromAccount());
        transactionDto.setToAccount(transactionEntity.getToAccount());
        return transactionDto;
    }

    @Override
    public Transaction dtoToEntity(TransactionDto transactionDto) {
        Transaction transaction = new Transaction();
        transaction.setAmount(transactionDto.getAmount());
        transaction.setFromAccount(transactionDto.getFromAccount());
        transaction.setToAccount(transactionDto.getToAccount());
        return transaction;
    }

    @Override
    public List<TransactionDto> entityToDtoList(List<Transaction> transactionEntityList) {
        return transactionEntityList.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public List<Transaction> dtoToEntityList(List<TransactionDto> transactiondtoList) {
        return transactiondtoList.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }
    
}
