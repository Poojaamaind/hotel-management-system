package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Admin;
import com.app.pojos.ApiResponse;
import com.app.pojos.Customers;
import com.app.pojos.Staff;
import com.app.pojos.loginData;


public interface IAdminService {
	List<Admin> getAllAdmins();
	Admin RegisterAdmin(Admin transientPOJO);
	ApiResponse login(loginData loginDto);
	Optional<Admin> findByUserNameAndPassword(String uname,String pass);
	Optional<Admin> findByAdminId(Integer Id);
	Admin findByUsername(String username);

	//Admin updateAdminDetails(int adminId, Admin detachedPOJO);
	Admin updateAdminDetails(Admin p);
}
