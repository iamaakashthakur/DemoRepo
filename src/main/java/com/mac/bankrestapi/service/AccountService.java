package com.mac.bankrestapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mac.bankrestapi.dao.AccountDao;
import com.mac.bankrestapi.entities.Account;

@Service
public class AccountService implements AccountServiceInterfacae{
	
	@Autowired
	AccountDao repo;

	@Override
	public Account getAccountById(int id) {
		Account account = null;
		try {
			 account = repo.findById(id).get();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return account;
	}

	@Override
	public List<Account> getAllAccounts() {
		List<Account> list = null;
		try {
			 list = repo.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public boolean removeAccountById(int id) {
		boolean flag = false;
		try {
			repo.deleteById(id);
			flag=true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public boolean removeAllAccounts() {
		boolean flag = false;
		try {
			repo.deleteAll();
			flag=true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return flag;
		
	}

	@Override
	public Account createAccount(Account account) {
		Account save = null;
		try {
			 save = repo.save(account);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return save;
	}

	@Override
	public Account updateAccount(Account account,int id) {
		Account account1 = null;
		try {
			account.setAccountNum(id);
			account1 = repo.save(account);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return account1;
	}

}
