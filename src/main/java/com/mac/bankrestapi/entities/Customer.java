package com.mac.bankrestapi.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String mobile;
	private String email;
	private String pancard;
	private String address;
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonBackReference
	List<Account> account;
	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPancard() {
		return pancard;
	}



	public void setPancard(String pancard) {
		this.pancard = pancard;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public List<Account> getAccount() {
		return account;
	}



	public void setAccount(List<Account> account) {
		this.account = account;
	}



	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Customer(int id, String name, String mobile, String email, String pancard, String address,
			List<Account> account) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.pancard = pancard;
		this.address = address;
		this.account = account;
	}


	
	
	
	



	

}
