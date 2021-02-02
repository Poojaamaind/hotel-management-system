package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.app.pojos.Admin;
import com.app.pojos.ApiResponse;
import com.app.pojos.Customers;
import com.app.pojos.User;
import com.app.pojos.loginData;


public interface ICustomerService {
	
	List<Customers> getAllCustomers();

	Optional<Customers> findByCustomerFirstName(String fname);

	Optional<Customers> findByCustomerLastName(String lname);

	Optional<Customers> findByCustomerId(Integer Id);
	
	 void deleteCustomerDetails(int customerId);

	Customers RegisterNewCustomer(Customers transientPOJO);

	Customers updateCustomersDetails(Customers detachedPOJO);
	
	ApiResponse login(loginData loginDto);
	
	Customers findByUsername(String username);
}
