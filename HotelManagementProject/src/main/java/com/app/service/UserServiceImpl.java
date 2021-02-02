package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_excs.UserNotFoundException;
import com.app.dao.IUserDao;
import com.app.pojos.ApiResponse;
import com.app.pojos.User;
import com.app.pojos.loginData;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao dao;

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

//	@Override
//	public Optional<User> findByUsernameAndUserpassword(String username, String password) {
//		
//		return dao.findByUsernameAndUserpassword(username, password);
//		
//	}

	
	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return dao.findByUsername(username);
	}

	@Override
	public User RegisterNewUser(User transientPOJO) {
		// TODO Auto-generated method stub
		System.out.println(transientPOJO.getUserName()+"  "+transientPOJO.getUserPassword());
		return dao.save(transientPOJO);
	}

	@Override
	public User ForgotPassword(String username, User detachedPOJO) {
		    User user = dao.findByUsername(username);

			user.setUserPassword(detachedPOJO.getUserPassword());
			user.setUserName(detachedPOJO.getUserName());
			return user;

	}

	@Override
	public ApiResponse login(loginData loginDto) {
		System.out.println("in user login service"+loginDto);
		
		User user = dao.findByUsername(loginDto.getUsername());
        if(user == null) {
            throw new RuntimeException("User does not exist.");
        }
        if(!user.getUserPassword().equals(loginDto.getPassword())){
            throw new RuntimeException("Password mismatch.");
        }
        return new ApiResponse(200, "Login success", null) ;
		// TODO Auto-generated method stub
		
	}

	
}
