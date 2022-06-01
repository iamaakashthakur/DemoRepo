package com.mac.bankrestapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mac.bankrestapi.dao.CustomerDao;
import com.mac.bankrestapi.entities.Customer;

@Service
public class CustomerService implements CustomerServiceInterface{
	
	@Autowired
	CustomerDao repo;

	@Override
	public Customer createCustomer(Customer customer) {
		Customer custm = null;
		try {
			custm = repo.save(customer);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return custm;
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> list = null;
		try {
			list = repo.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Customer getCustomerById(int id) {
		Customer custm = null;
		try {
			custm = repo.findById(id).get();
		}catch(Exception e){
			e.printStackTrace();
		}
		return custm;
	}

	@Override
	public boolean deleteCustomerById(int id) {
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
	public boolean deleteAllCustomers() {
		boolean flag = false;
		try {
			repo.deleteAll();;
			flag=true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Customer updateCustomer(Customer customer, int id) {
		Customer cstm = null;
		try {
			customer.setId(id);
			cstm = repo.save(customer);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cstm;
	}

}
