package com.mac.bankrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.mac.bankrestapi.entities.Account;
import com.mac.bankrestapi.entities.Customer;
import com.mac.bankrestapi.service.AccountService;
import com.mac.bankrestapi.service.CustomerService;
import com.mac.bankrestapi.util.CustomError;

@RestController
@RequestMapping("/bank")
public class Controller {
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/accounts")
	public ResponseEntity<?> createNewAccount(@RequestBody Account account) {
		Account accountCreated = accountService.createAccount(account);
		ResponseEntity<?> response = new ResponseEntity<>(new CustomError("Unable to create..!"),HttpStatus.CONFLICT);
		if(accountCreated!=null) {
			response = new ResponseEntity<>(accountCreated,HttpStatus.CREATED);
		}
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/accounts")
	public ResponseEntity<?> getAllAccount() {
		ResponseEntity<?> response = new ResponseEntity<>(new CustomError("Record not found..!"),HttpStatus.NOT_FOUND);
		List<Account> list = accountService.getAllAccounts();
		if(list!=null && !list.isEmpty()) {
			response = new ResponseEntity<>(list,HttpStatus.OK);
		}
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/accounts/{id}")
	public ResponseEntity<?> getAccountById(@PathVariable int id) {
		ResponseEntity<?> response = new ResponseEntity<>(new CustomError("Record not found..!"),HttpStatus.NOT_FOUND);
		Account account = accountService.getAccountById(id);
		if(account!=null) {
			response = new ResponseEntity<>(account,HttpStatus.OK);
		}
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/accounts/{id}")
	public ResponseEntity<?> deletedAccountById(@PathVariable int id) {
		ResponseEntity<?> response = new ResponseEntity<>(new CustomError("Record not found..!"),HttpStatus.NOT_FOUND);
		boolean b = accountService.removeAccountById(id);
		if(b!=false) {
			response = new ResponseEntity<>(b,HttpStatus.OK);
		}
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/accounts")
	public ResponseEntity<?> deleteAllAccounts() {
		ResponseEntity<?> response  = new ResponseEntity<>(new CustomError("Unable to delete..!"),HttpStatus.CONFLICT);
		boolean b = accountService.removeAllAccounts();
		if(b!=false){
			response = new ResponseEntity<>(b,HttpStatus.OK);
		}
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/accounts/{id}")
	public ResponseEntity<?> updateAccount(@RequestBody Account account,@PathVariable int id) {
		ResponseEntity<?> response = new ResponseEntity<>(new CustomError("Sorry, Can not update..!"),HttpStatus.CONFLICT);
		Account updateAccount = accountService.updateAccount(account, id);
		if(updateAccount!=null) {
			response = new ResponseEntity<>(updateAccount,HttpStatus.OK);
		}
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/customers")
	public ResponseEntity<?> createCustomer(@RequestBody Customer customer){
		Customer createCustomer = customerService.createCustomer(customer);
		ResponseEntity<?> response = new ResponseEntity<>(new CustomError("Unable to create customer..!"),HttpStatus.CONFLICT);
		if(createCustomer!=null) {
			response = new ResponseEntity<>(createCustomer,HttpStatus.OK);
		}
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/customers")
	public ResponseEntity<?> getAllCustomers(){
		ResponseEntity<?> response = new ResponseEntity<>(new CustomError("Record not found..!"),HttpStatus.NOT_FOUND);
		List<Customer> list = customerService.getAllCustomers();
		if(list!=null && !list.isEmpty()) {
			response = new ResponseEntity<>(list,HttpStatus.OK);
		}
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<?> getCustomerById(@PathVariable int id){
		ResponseEntity<?> response = new ResponseEntity<>(new CustomError("Record not found..!"),HttpStatus.NOT_FOUND);
		Customer customerById = customerService.getCustomerById(id);
		if(customerById!=null) {
			response = new ResponseEntity<>(customerById,HttpStatus.OK);
		}
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<?> deletedCustomerById(@PathVariable int id) {
		ResponseEntity<?> response = new ResponseEntity<>(new CustomError("Record not found..!"),HttpStatus.NOT_FOUND);
		boolean b = customerService.deleteCustomerById(id);
		if(b!=false) {
			response = new ResponseEntity<>(b,HttpStatus.OK);
		}
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/customers")
	public ResponseEntity<?> deleteAllCustomers() {
		ResponseEntity<?> response  = new ResponseEntity<>(new CustomError("Unable to delete..!"),HttpStatus.CONFLICT);
		boolean b = customerService.deleteAllCustomers();
		if(b!=false){
			response = new ResponseEntity<>(b,HttpStatus.OK);
		}
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/customers/{id}")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer customer,@PathVariable int id) {
		ResponseEntity<?> response = new ResponseEntity<>(new CustomError("Sorry, Can not update..!"),HttpStatus.CONFLICT);
		  Customer updateCustomer = customerService.updateCustomer(customer, id);
		if(updateCustomer!=null) {
			response = new ResponseEntity<>(updateCustomer,HttpStatus.OK);
		}
		return ResponseEntity.ok(response);
	}
	
	

}
