package com.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Admin;
import com.app.pojos.Reservation;
import com.app.service.IAdminService;
import com.app.service.IReservationService;

@RestController
@RequestMapping("/reservation")
@CrossOrigin
public class ReservationController {
	@Autowired
	private IReservationService Service;
	
	
	@PostMapping(produces = "application/json")
	public  ResponseEntity<?> RegisterAdmin(@RequestBody Reservation newAdmin) {
		System.out.println("in admin reg");
		System.out.println("in new Registration " + newAdmin);
		try {
			Reservation adm = Service.addRoom(newAdmin);
			System.out.println(adm.toString());
			return new ResponseEntity<>(adm, HttpStatus.OK);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@GetMapping("/{reservationId}")
	public ResponseEntity<?> getCusomerDetails(@PathVariable int adminId)
	{
		Optional<Reservation>ad=Service.findByReservationId(adminId);
		if(ad.isPresent())
		{
			return new ResponseEntity<>(ad,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}

}
