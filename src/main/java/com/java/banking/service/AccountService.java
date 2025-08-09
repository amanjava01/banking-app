package com.java.banking.service;

import java.util.List;

import com.java.banking.dto.AccountDto;

public interface AccountService {

    AccountDto createAccount(AccountDto accountdto);
    AccountDto getAccountById(Long id);
    AccountDto deposit(Long id,double amount);
    AccountDto withdraw(Long id , double amount);
    List<AccountDto> getAllAccount();
    void deleteAccount(Long id);

}
