package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Admin;
import com.app.pojos.ApiResponse;
import com.app.pojos.Customers;
import com.app.pojos.loginData;
import com.app.service.ICustomerService;


@RestController
@RequestMapping("/customers")
@CrossOrigin
public class CustomerController {
	@Autowired
	private ICustomerService service;
	public  CustomerController() {
		System.out.println("in ctor of"+getClass().getName());
		// TODO Auto-generated constructor stub
	}

	@GetMapping
	public ResponseEntity<?> GetAllCustomers()
	{
		System.out.println("in getall customers");
		List<Customers> custos=service.getAllCustomers();
		if(custos.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(custos,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/profile/{username}")
	public Customers  findByUsername(@PathVariable String username)
	{
		Customers ad=service.findByUsername(username);
		return ad;
		
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> AddCustomerDetails(@RequestBody Customers newCustomer) {
		System.out.println("in new Registration " + newCustomer);
		try {
			Customers c = service.RegisterNewCustomer(newCustomer);
			System.out.println(c.toString());
			return new ResponseEntity<>(c, HttpStatus.OK);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping
	public ResponseEntity<?> updateCustomerDetails (@RequestBody Customers c) {
		System.out.println("in update hghdc" + " " + c);
		try {
			Customers updatedDetails = service.updateCustomersDetails(c);
			return new ResponseEntity<>(updatedDetails, HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<?> getCusomerDetails(@PathVariable int customerId)
	{
		Optional<Customers>cust=service.findByCustomerId(customerId);
		if(cust.isPresent())
		{
			return new ResponseEntity<>(cust,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping("/login")
    public ApiResponse login(@RequestBody loginData loginDto){
        return service.login(loginDto);
    }
	
	@DeleteMapping("/{customerId}")
	public void deleteProductDetails(@PathVariable int customerId) {
		System.out.println("in del product dtls " + customerId);
		try {
			service.deleteCustomerDetails(customerId);
			
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
		}
		
	}
	
}
