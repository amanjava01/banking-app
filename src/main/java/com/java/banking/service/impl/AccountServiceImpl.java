package com.java.banking.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.java.banking.dto.AccountDto;
import com.java.banking.entity.Account;
import com.java.banking.mapper.AccountMapper;
import com.java.banking.repository.AccountRepository;
import com.java.banking.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
	
    public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	@Override
    public AccountDto createAccount(AccountDto accountdto) {

        Account account = AccountMapper.mapToAccount(accountdto);
        Account savedAccount =accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }



	@Override
	public AccountDto getAccountById(Long id) {

		Account account = accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account Does not exits with id : "+id));
		
		return AccountMapper.mapToAccountDto(account);
	}




	@Override
	public AccountDto deposit(Long id, double amount) {
		
		Account account = accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account Does not exits with id : "+id));

		double totalAmount= account.getBalance()+amount;
		account.setBalance(totalAmount);
		Account saveAccount=accountRepository.save(account);

		return AccountMapper.mapToAccountDto(saveAccount);
	}

	@Override
	public AccountDto withdraw(Long id, double amount) {
		
		Account account = accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account Does not exits with id : "+id));

	   if(account.getBalance()<amount) {
		   throw new  RuntimeException("Insufficient Balance");
		   
	   }
		
		Double totalAmount = account.getBalance()-amount;
		 
		account.setBalance(amount);
		
		Account savedAmount = accountRepository.save(account);
		
		return AccountMapper.mapToAccountDto(savedAmount);
	}

	@Override
	public List<AccountDto> getAllAccount() {

		List<Account>accounts = accountRepository.findAll();
		
		List<AccountDto> allAccount = accounts.stream().map((account)->AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
		
		return allAccount;
	}

	@Override
	public void deleteAccount(Long id) {
		
		 accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account Does not exits with id : "+id));
		accountRepository.deleteById(id);
		
	}
	
	

}
