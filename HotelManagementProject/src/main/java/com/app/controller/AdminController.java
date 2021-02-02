package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.app.service.IAdminService;
import com.app.service.IStaffService;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {
	@Autowired
	private IAdminService adminService;
	
	@Autowired
	private IStaffService staffService;
	
	@GetMapping
	public ResponseEntity<?> GetAllAdmins()
	{
		System.out.println("in getall users");
		List<Admin> admin=adminService.getAllAdmins();
		if(admin.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(admin,HttpStatus.OK);
		
	}
	
	@PostMapping("/register")
	public  ResponseEntity<?> RegisterAdmin(@RequestBody Admin newAdmin) {
		System.out.println("in admin reg");
		System.out.println("in new Registration " + newAdmin);
		try {
			Admin adm = adminService.RegisterAdmin(newAdmin);
			System.out.println(adm.toString());
			return new ResponseEntity<>(adm, HttpStatus.OK);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/{adminId}")
	public ResponseEntity<?> getCusomerDetails(@PathVariable int adminId)
	{
		Optional<Admin>ad=adminService.findByAdminId(adminId);
		if(ad.isPresent())
		{
			return new ResponseEntity<>(ad,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	
	@PostMapping(value="/addStaff",produces = "application/json")
	public  ResponseEntity<?> AddStaff(@RequestBody Staff newStaff) {
		System.out.println("in staff reg");
		System.out.println("in new Registration " + newStaff);
		try {
			Staff stf = staffService.registerNewStaff(newStaff);
			System.out.println(stf.toString());
			return new ResponseEntity<>(stf, HttpStatus.OK);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping("/login")
    public ApiResponse login(@RequestBody loginData loginDto){
        return adminService.login(loginDto);
    }

	
	@GetMapping("/{username}/{password}")
	public ResponseEntity<?> findByUserNameAndPassword(@PathVariable String username, @PathVariable String password) 
	{
		Optional<Admin>ad=adminService.findByUserNameAndPassword(username, password);
		if(ad.isPresent())
		{
			return new ResponseEntity<>(ad,HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/profile/{username}")
	public Admin  findByUsername(@PathVariable String username)
	{
		Admin ad=adminService.findByUsername(username);
		return ad;
		
	}
	
	
	@PutMapping
	public ResponseEntity<?> updateAdmin( @RequestBody Admin c) {
		System.out.println("in update " + c);
		try {
			//Admin updatedDetails = adminService.updateAdminDetails(adminId, c);
			return new ResponseEntity<>(adminService.updateAdminDetails(c), HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
}
