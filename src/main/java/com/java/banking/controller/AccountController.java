package com.java.banking.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.banking.dto.AccountDto;
import com.java.banking.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	
	private final AccountService accountService;

	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	// create account 
	
	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
		return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
	}
	
	// get account details with id's
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
		AccountDto accountDto = accountService.getAccountById(id);
		return ResponseEntity.ok(accountDto);
	}
	
	// send amount with id's number 
	
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDto> addAmount(@PathVariable Long id,@RequestBody Map <String, Double> request){
		
		AccountDto accountDto=accountService.deposit(id, request.get("amount"));
		return ResponseEntity.ok(accountDto);
	}
	
	// withdrawal amount 
	
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDto> withdrawAmount(@PathVariable Long id,@RequestBody Map<String,Double> request){
		AccountDto withdrawAmount = accountService.withdraw(id, request.get("amount"));

		return ResponseEntity.ok(withdrawAmount);
	
	}
	
	// get all account 
	
	@GetMapping("/getall")
	public ResponseEntity<List<AccountDto>> allAccount(){
		
       List<AccountDto> accounts = accountService.getAllAccount();
       return ResponseEntity.ok(accounts);
	}
	
	// delete account by id	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAccount(Long id){
		accountService.deleteAccount(id);
		return ResponseEntity.ok("Account deleted successfully");
	}
	
	
	
	
}
