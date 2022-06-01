package com.mac.bankrestapi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="account")
public class Account{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="account_num")
	private int accountNum;
	
	private String branch;
	
	@Column(name="account_Type")
	private String acccountType;
	private int balance;
	
	@ManyToOne()
	@JoinColumn(name="fk_customer_id")
	@JsonManagedReference
	private Customer customer;
	
	

	public int getAccountNum() {
		return accountNum;
	}



	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}



	public String getBranch() {
		return branch;
	}



	public void setBranch(String branch) {
		this.branch = branch;
	}



	public String getAcccountType() {
		return acccountType;
	}



	public void setAcccountType(String acccountType) {
		this.acccountType = acccountType;
	}



	public int getBalance() {
		return balance;
	}



	public void setBalance(int balance) {
		this.balance = balance;
	}



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Account(int accountNum, String branch, String acccountType, int balance, Customer customer) {
		super();
		this.accountNum = accountNum;
		this.branch = branch;
		this.acccountType = acccountType;
		this.balance = balance;
		this.customer = customer;
	}
	
	
	
	



	



	
	

	
	
	
	

}
