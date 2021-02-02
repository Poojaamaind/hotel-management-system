package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.ApiResponse;
import com.app.pojos.User;
import com.app.pojos.loginData;

public interface IUserService {
   	List<User> getAllUsers();
    ApiResponse login(loginData loginDto);
   	//Optional<User> findByUsernameAndUserpassword(String username, String password);
   	User findByUsername(String username);
   	User RegisterNewUser(User transientPOJO);

	// update existing product details
	User ForgotPassword(String username, User detachedPOJO);
	


   	
}
