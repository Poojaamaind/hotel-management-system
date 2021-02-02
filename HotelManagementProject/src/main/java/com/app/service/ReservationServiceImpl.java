package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICustomerDao;
import com.app.dao.IReservationDao;
import com.app.pojos.Customers;
import com.app.pojos.Reservation;
@Service
@Transactional
public class ReservationServiceImpl implements IReservationService {

	@Autowired
	private IReservationDao dao;
	@Override
	public Optional<Reservation> findByReservationId(Integer Id) {
		// TODO Auto-generated method stub
		return dao.findById(Id);
	}

	@Override
	public Reservation addRoom(Reservation transientPOJO) {
		// TODO Auto-generated method stub
		return dao.save(transientPOJO);
	}

}
