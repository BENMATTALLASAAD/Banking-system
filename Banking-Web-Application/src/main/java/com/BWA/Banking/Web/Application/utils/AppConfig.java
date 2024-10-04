package com.BWA.Banking.Web.Application.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.BWA.Banking.Web.Application.mapper.AccountMapper;
import com.BWA.Banking.Web.Application.mapper.RoleMapper;
import com.BWA.Banking.Web.Application.mapper.TransactionMapper;
import com.BWA.Banking.Web.Application.mapper.UserMapper;
import com.BWA.Banking.Web.Application.mapper.mapperImpl.AccountMapperImpl;
import com.BWA.Banking.Web.Application.mapper.mapperImpl.RoleMapperImpl;
import com.BWA.Banking.Web.Application.mapper.mapperImpl.TransactionMapperImpl;
import com.BWA.Banking.Web.Application.mapper.mapperImpl.UserMapperImpl;

@Configuration
public class AppConfig {

    @Bean
    public UserMapper userMapper() {
        return new UserMapperImpl();
    }

    @Bean
    public AccountMapper accountMapper(){
        return new AccountMapperImpl();
    }

    @Bean 
    public RoleMapper roleMapper(){
        return new RoleMapperImpl();
    }

    @Bean
    public TransactionMapper transactionMapper(){
        return new TransactionMapperImpl();
    }
}
