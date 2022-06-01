package com.mac.bankrestapi.service;

import java.util.List;

import com.mac.bankrestapi.entities.Account;

public interface AccountServiceInterfacae {
	
	Account createAccount(Account account);
	Account getAccountById(int id);
	List<Account> getAllAccounts();
	boolean removeAccountById(int id);
	boolean removeAllAccounts();
	Account updateAccount(Account account,int id);

}
