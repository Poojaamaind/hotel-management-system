package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Customers;
import com.app.pojos.Reservation;

public interface IReservationService {
	// List<Reservation> getAllCustomers();
	
	Optional<Reservation> findByReservationId(Integer Id);
	Reservation addRoom(Reservation transientPOJO);

}
