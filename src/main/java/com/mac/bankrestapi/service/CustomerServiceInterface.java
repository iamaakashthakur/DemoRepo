package com.mac.bankrestapi.service;

import java.util.List;

import com.mac.bankrestapi.entities.Customer;

public interface CustomerServiceInterface {
	
	Customer createCustomer(Customer customer);
	List<Customer> getAllCustomers();
	Customer getCustomerById(int id);
	boolean deleteCustomerById(int id);
	boolean deleteAllCustomers();
	Customer updateCustomer(Customer customer,int id);

}
