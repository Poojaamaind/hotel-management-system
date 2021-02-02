package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Admin;
import com.app.pojos.Customers;

public interface ICustomerDao extends JpaRepository<Customers, Integer> {

	Optional<Customers> findByCustomerFirstName(String fname);
	Optional<Customers> findByCustomerLastName(String lname);
	Optional<Customers> findByCustomerId(Integer Id);
	
	
	
	Customers findByUsername(String username);
	
	
	
}
