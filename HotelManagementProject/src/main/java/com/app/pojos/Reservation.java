package com.app.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer reservationId;
	  public Integer customerId;
	  public String FirstName; 
	  public String LastName;
	  @Temporal(TemporalType.DATE)
	  public Date dateOfBooking;
	  @Column(length = 11)
	 // public Integer phoneNumber;
	  public Integer noOfDays;
	  public String roomType;
	  public String userName;
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public Date getDateOfBooking() {
		return dateOfBooking;
	}
	public void setDateOfBooking(Date dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}
//	public Integer getPhoneNumber() {
//		return phoneNumber;
//	}
//	public void setPhoneNumber(Integer phoneNumber) {
//		this.phoneNumber = phoneNumber;
//	}
	public Integer getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(Integer noOfDays) {
		this.noOfDays = noOfDays;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	  
	  

}
