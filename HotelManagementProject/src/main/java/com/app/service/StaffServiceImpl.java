package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_excs.AdminNotFoundException2;
import com.app.custom_excs.CustomerNotFoundException;
import com.app.custom_excs.StaffNotFoundException3;
import com.app.dao.IStaffDao;
import com.app.pojos.Admin;
import com.app.pojos.ApiResponse;
import com.app.pojos.Customers;
import com.app.pojos.Staff;
import com.app.pojos.loginData;

@Service
@Transactional
public class StaffServiceImpl implements IStaffService {
	
	@Autowired
	private IStaffDao dao;

	@Override
	public List<Staff> getAllStaffs() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<Staff> findByStaffFirstName(String fname) {
		// TODO Auto-generated method stub
		return dao.findByStaffFirstName(fname);
	}

	@Override
	public Optional<Staff> findByStaffLastName(String lname) {
		// TODO Auto-generated method stub
		return dao.findByStaffLastName(lname);
	}

	@Override
	public Optional<Staff> findByStaffId(Integer Id) {
		// TODO Auto-generated method stub
		return dao.findById(Id);
	}

	@Override
	public Staff registerNewStaff(Staff transientPOJO) {
		// TODO Auto-generated method stub
		return dao.save(transientPOJO);
	}

	@Override
	public Staff updateStaffDetails(Staff detachedPOJO) {
		
		
		Optional<Staff> optional = dao.findById(detachedPOJO.getStaffId());
		if (optional.isPresent())
			return dao.save(detachedPOJO); // update
		// if product is not found : throw custom exception
		 throw new StaffNotFoundException3("Staff Not Found ");
		//Optional<Staff> p = dao.findById(staffId);
//		if (p.isPresent()) {
//			Staff st = p.get();
//			st.setAdharNumber(detachedPOJO.getAdharNumber());
//			st.setAddress(detachedPOJO.getAddress());
//			st.setStaffFirstName(detachedPOJO.getStaffFirstName());
//			st.setStaffLastName(detachedPOJO.getStaffLastName());
//			st.setDateOfBirth(detachedPOJO.getDateOfBirth());
//			st.setGender(detachedPOJO.getGender());
//			st.setPhoneNumber(detachedPOJO.getPhoneNumber());
//			return st;
//		}
//		throw new CustomerNotFoundException("Invalid Staff ID");
	}

	@Override
	public ApiResponse login(loginData loginDto) {
		Staff staff = dao.findByUsername(loginDto.getUsername());
        if(staff == null) {
            throw new RuntimeException("Staff does not exist.");
        }
        if(!staff.getPassword().equals(loginDto.getPassword())){
            throw new RuntimeException("Password mismatch.");
        }
        return new ApiResponse(200, "Login success", null) ;
	}

	@Override
	public void deleteStaffDetails(int staffId) {
		Optional<Staff> optional = dao.findById(staffId);
		if (optional.isPresent())
			dao.deleteById(staffId);
		else
			// if product is not found : throw custom exception
			throw new StaffNotFoundException3("Staff Not Found : Invalid Staff id " + staffId);
		
	}

	@Override
	public Staff findByUsername(String username) {
		
		return dao.findByUsername(username);
	}

	

}
