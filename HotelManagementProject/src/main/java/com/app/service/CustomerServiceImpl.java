package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_excs.AdminNotFoundException2;
import com.app.custom_excs.CustomerNotFoundException;
import com.app.custom_excs.StaffNotFoundException3;
import com.app.dao.ICustomerDao;
import com.app.pojos.Admin;
import com.app.pojos.ApiResponse;
import com.app.pojos.Customers;
import com.app.pojos.Gender;
import com.app.pojos.User;
import com.app.pojos.loginData;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDao dao;

	@Override
	public List<Customers> getAllCustomers() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<Customers> findByCustomerFirstName(String fname) {
		// TODO Auto-generated method stub
		return dao.findByCustomerFirstName(fname);
	}

	@Override
	public Optional<Customers> findByCustomerLastName(String lname) {
		// TODO Auto-generated method stub
		return dao.findByCustomerLastName(lname);
	}

	@Override
	public Optional<Customers> findByCustomerId(Integer id) {
		// TODO Auto-generated method stub
		return dao.findByCustomerId(id);
	}

	@Override
	public Customers RegisterNewCustomer(Customers transientPOJO) {
		// TODO Auto-generated method stub
		System.out.println("in customer service"+ transientPOJO);
		return dao.save(transientPOJO);
	}

	@Override
	public Customers updateCustomersDetails(Customers detachedPOJO) {
		System.out.println("in update Customer");
		
		Optional<Customers> optional = dao.findById(detachedPOJO.getCustomerId());
		if (optional.isPresent())
			return dao.save(detachedPOJO); // update
		// if product is not found : throw custom exception
		 throw new StaffNotFoundException3("Admin Not Found ");
//		//Optional<Customers> p = dao.findById(customerId);
//		if (p.isPresent()) {
//			Customers cust = p.get();
//			cust.setAdharNumber(detachedPOJO.getAdharNumber());
//			cust.setAddress(detachedPOJO.getAddress());
//			cust.setCustomerFirstName(detachedPOJO.getCustomerFirstName());
//			cust.setCustomerLastName(detachedPOJO.getCustomerLastName());
//			cust.setDateOfBirth(detachedPOJO.getDateOfBirth());
//			cust.setGender(detachedPOJO.getGender());
//			cust.setPhoneNumber(detachedPOJO.getPhoneNumber());
//			return cust;
//		}
//		throw new CustomerNotFoundException("Invalid Product ID");

	}

	@Override
	public ApiResponse login(loginData loginDto) {
     System.out.println("in customer login service"+loginDto);
		
		Customers user = dao.findByUsername(loginDto.getUsername());
        if(user == null) {
            throw new RuntimeException("User does not exist.");
        }
        if(!user.getUserPassword().equals(loginDto.getPassword())){
            throw new RuntimeException("Password mismatch.");
        }
        return new ApiResponse(200, "Login success", null) ;
	}

	@Override
	public void deleteCustomerDetails(int customerId) {
		Optional<Customers> optional = dao.findById(customerId);
		if (optional.isPresent())
			dao.deleteById(customerId);
		else
			// if product is not found : throw custom exception
			throw new CustomerNotFoundException("Customer Not Found : Invalid Product id " + customerId);


		
	}

	@Override
	public Customers findByUsername(String username) {
		// TODO Auto-generated method stub
		return dao.findByUsername(username);
	}

	

}
