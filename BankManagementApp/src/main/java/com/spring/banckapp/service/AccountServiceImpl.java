package com.spring.banckapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.banckapp.AccountRepository;
import com.spring.banckapp.entity.Account;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepository accountRepository;

	@Override
	public Account createAccount(Account account) {
		Account account_saved=accountRepository.save(account);
		return account_saved;
	}

	@Override
	public Account getAccountDetailsByAccountNumber(Long accountNumber) {
	 Optional<Account> account=	accountRepository.findById(accountNumber);
	 if(account.isEmpty())
	 {
		 throw new RuntimeException("Account is not present in our database");
	 }
	Account account_found = account.get();
		return account_found;
	}

	@Override
	public List<Account> getAllAccountDetails() {
		
		List<Account> ListOfAccounts=accountRepository.findAll();
		return ListOfAccounts;
	}

	@Override
	public Account depositAmount(Long accountNumber, Double amount) {
		
		Optional<Account> account = accountRepository.findById(accountNumber);
		if(account.isEmpty())
		{
			throw new RuntimeException("Account number is not present in the DATABASE");
		}
		Account accountPresent = account.get();
		
		Double totalBalance= accountPresent.getAccount_balance()+amount;
		accountPresent.setAccount_balance(totalBalance);
		accountRepository.save(accountPresent);
		return accountPresent;
	}

	@Override
	public Account withdrwaAmount(Long accountNumber, Double amount) {
		
		Optional<Account> account = accountRepository.findById(accountNumber);
		if(account.isEmpty())
		{
			throw new RuntimeException("Account number is not present in the DATABASE");
		}
		Account accountPresent = account.get();
		Double accountBalance = accountPresent.getAccount_balance()-amount;
		accountPresent.setAccount_balance(accountBalance);
		accountRepository.save(accountPresent);
		return accountPresent;
	}

	@Override
	public void closeAccount(Long accountNumber) {
		getAccountDetailsByAccountNumber(accountNumber);
		accountRepository.deleteById(accountNumber);
		
		
	}

	
}