package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.app.pojos.Staff;


public interface IStaffDao extends JpaRepository<Staff, Integer>{

	Staff findByUsername(String username);
	
	Optional<Staff> findByStaffFirstName(String fname);

	Optional<Staff> findByStaffLastName(String lname);

	Optional<Staff> findByStaffId(Integer Id);

//	Staff registerNewStaff(Staff transientPOJO);
//
//	Staff update(int staffId, Staff detachedPOJO);
	
	
}
