package com.BWA.Banking.Web.Application.mapper;


import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.BWA.Banking.Web.Application.dto.TransactionDto;
import com.BWA.Banking.Web.Application.model.Transaction;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    
    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);
    TransactionDto entityToDto(Transaction transactionEntity);
    Transaction dtoToEntity(TransactionDto transactionDto);
    List<TransactionDto> entityToDtoList(List<Transaction> transactionEntityList);
    List<Transaction> dtoToEntityList(List<TransactionDto>transactiondtoList);

}
