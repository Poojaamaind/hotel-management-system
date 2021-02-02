package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_excs.AdminNotFoundException2;
import com.app.custom_excs.CustomerNotFoundException;
import com.app.dao.IAdminDao;
import com.app.pojos.Admin;
import com.app.pojos.ApiResponse;
import com.app.pojos.Staff;
import com.app.pojos.User;
import com.app.pojos.loginData;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService{
	
	@Autowired 
	private IAdminDao dao;

	@Override
	public Admin RegisterAdmin(Admin transientPOJO) {
		// TODO Auto-generated method stub
		return dao.save(transientPOJO);
	}

	@Override
	public ApiResponse login(loginData loginDto) {
		Admin admin = dao.findByUsername(loginDto.getUsername());
        if(admin == null) {
            throw new RuntimeException("User does not exist.");
        }
        if(!admin.getPassword().equals(loginDto.getPassword())){
            throw new RuntimeException("Password mismatch.");
        }
        return new ApiResponse(200, "Login success", null) ;
		// TODO Auto-generated method stub
	}

	@Override
	public List<Admin> getAllAdmins() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<Admin> findByUserNameAndPassword(String uname, String pass) {
		// TODO Auto-generated method stub
		return dao.findByUsernameAndPassword(uname, pass);
	}

	@Override
	public Optional<Admin> findByAdminId(Integer Id) {
		// TODO Auto-generated method stub
		return dao.findById(Id);
	}

	@Override
	public Admin findByUsername(String username) {
		// TODO Auto-generated method stub
		return dao.findByUsername(username);
	}

	@Override
	public Admin updateAdminDetails(Admin detachedPOJO) {
		
		Optional<Admin> optional = dao.findById(detachedPOJO.getAdminId());
		if (optional.isPresent())
			return dao.save(detachedPOJO); // update
		// if product is not found : throw custom exception
		 throw new AdminNotFoundException2("Admin Not Found ");

		
//		Optional<Admin> p = dao.findById(adminId);
//		if (p.isPresent()) {
//			Admin st = p.get();
//			st.setAdharNumber(detachedPOJO.getAdharNumber());
//			st.setAddress(detachedPOJO.getAddress());
//			st.setAdminFirstName(detachedPOJO.getAdminFirstName());
//			st.setAdminLastName(detachedPOJO.getAdminLastName());
//			st.setDateOfBirth(detachedPOJO.getDateOfBirth());
//			st.setGender(detachedPOJO.getGender());
//			st.setPhoneNumber(detachedPOJO.getPhoneNumber());
//			return st;
//		}
//		throw new CustomerNotFoundException("Invalid Admin ID");
	}
	
	

}
