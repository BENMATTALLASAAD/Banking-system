package com.BWA.Banking.Web.Application.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.BWA.Banking.Web.Application.dto.AccountDto;
import com.BWA.Banking.Web.Application.model.Account;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);
    AccountDto entityToDto(Account accountEntity);
    Account dtoToEntity(AccountDto accountDto);
    List<AccountDto> entityToDtoList(List<Account> accountEntityList);
    List<Account> dtoToEntityList(List<AccountDto> accountDtoList);
}
