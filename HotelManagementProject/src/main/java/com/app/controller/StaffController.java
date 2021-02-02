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
import com.app.pojos.Staff;
import com.app.pojos.loginData;
import com.app.service.IStaffService;

@RestController
@RequestMapping(value="/staff")
@CrossOrigin
public class StaffController {
	@Autowired
	private IStaffService service;
	
	@GetMapping
	public ResponseEntity<?> GetAllStaffs()
	{
		System.out.println("in getall users");
		List<Staff> staffs=service.getAllStaffs();
		if(staffs.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(staffs,HttpStatus.OK);
		
	}
	
	@PostMapping("/login")
    public ApiResponse login(@RequestBody loginData loginDto){
        return service.login(loginDto);
    }
	
	@GetMapping("/profile/{username}")
	public Staff  findByUsername(@PathVariable String username)
	{
		Staff ad=service.findByUsername(username);
		return ad;
		
	}
	
	@PutMapping
	public ResponseEntity<?> updateStaffDetails( @RequestBody Staff s) {
		System.out.println("in update " + " " + s);
		try {
			Staff updatedDetails = service.updateStaffDetails(s);
			return new ResponseEntity<>(updatedDetails, HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{staffId}")
	public void deleteProductDetails(@PathVariable int staffId) {
		System.out.println("in del product dtls " + staffId);
		try {
			service.deleteStaffDetails(staffId);
			
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
		}
		
	}
	
	
	@GetMapping("/{staffId}")
	public ResponseEntity<?> getAdminDetails(@PathVariable int staffId)
	{
		Optional<Staff>ad=service.findByStaffId(staffId);
		if(ad.isPresent())
		{
			return new ResponseEntity<>(ad,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}

	
	@PostMapping
	public  ResponseEntity<?> RegisterAdmin(@RequestBody Staff newAdmin) {
		System.out.println("in admin reg");
		System.out.println("in new Registration " + newAdmin);
		try {
			Staff adm = service.registerNewStaff(newAdmin);
			System.out.println(adm.toString());
			return new ResponseEntity<>(adm, HttpStatus.OK);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
