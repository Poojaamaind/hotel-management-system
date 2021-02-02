package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Admin;
import com.app.pojos.ApiResponse;
import com.app.pojos.Staff;
import com.app.pojos.loginData;

public interface IStaffService {
	
	List<Staff> getAllStaffs();

	Optional<Staff> findByStaffFirstName(String fname);

	Optional<Staff> findByStaffLastName(String lname);

	Optional<Staff> findByStaffId(Integer Id);

	Staff registerNewStaff(Staff transientPOJO);

	Staff updateStaffDetails( Staff detachedPOJO);
	
	ApiResponse login(loginData loginDto);
	
	void deleteStaffDetails(int staffId);
	
	Staff findByUsername(String username);

}
