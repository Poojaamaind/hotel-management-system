package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.ApiResponse;
import com.app.pojos.User;
import com.app.pojos.loginData;
import com.app.service.IUserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private IUserService service;
	public  UserController() {
		System.out.println("in ctor of"+getClass().getName());
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping
	public ResponseEntity<?> GetAllUsers()
	{
		System.out.println("in getall users");
		List<User> users=service.getAllUsers();
		if(users.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(users,HttpStatus.OK);
		
	}
	
	
	 @PostMapping("/login")
	    public ApiResponse login(@RequestBody loginData loginDto){
		 System.out.println("in login"+loginDto);
	        return service.login(loginDto);
	    }


	@PostMapping("/register")
	public ResponseEntity<?> RegisterNewUser(@RequestBody User newUser) {
		System.out.println("in new Registration " + newUser);
		try {
			User newRegister = service.RegisterNewUser(newUser);
			return new ResponseEntity<>(newRegister, HttpStatus.OK);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PutMapping("/{userName}")
	public ResponseEntity<?> ForgotPassword(@PathVariable String userName, @RequestBody User updateUser) {
		System.out.println("in update " + userName + " " + updateUser);
		try {
			User updatedDetails = service.ForgotPassword(userName, updateUser);
			return new ResponseEntity<>(updatedDetails, HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	

}
