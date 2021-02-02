
package com.app.pojos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Customers implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customerId")
	public Integer customerId;
	

	private String username;
	
	@Column(length = 10)
	private String password;
	
	public String customerFirstName;
	public String customerLastName;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Gender gender;

	@Temporal(TemporalType.DATE)
	@Column(name = "dob")
	private Date dateOfBirth;
	private String address;
	@Column( length = 11)
	private String phoneNumber;
	
	public String adharNumber;

	public Customers() {
		super();
		System.out.println("in default cotr");

		// TODO Auto-generated constructor stub
	}

	public Customers(Integer customerId, String customerFirstName, String customerLastName, Gender gender,
			Date dateOfBirth, String address, String phoneNumber, String adharNumber) {
		super();
		System.out.println("in parameterized cotr");
		this.customerId = customerId;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.adharNumber = adharNumber;

	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getUserPassword() {
		return password;
	}

	public void setUserPassword(String userPassword) {
		this.password = userPassword;
	}

	

}
