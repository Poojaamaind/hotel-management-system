package com.app.pojos;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer adminId;
	public String adminFirstName;
	public String adminLastName;


	private String username;
	
	@Column(length = 10)
	private String password;
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Gender gender;

	@Temporal(TemporalType.DATE)
	@Column(name = "dob")
	private Date dateOfBirth;
	
	@Column(length = 11)
	private String phoneNumber;
	
	public String adharNumber;
	
	private String address;

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminFirstName() {
		return adminFirstName;
	}

	public void setAdminFirstName(String adminFirstName) {
		this.adminFirstName = adminFirstName;
	}

	public String getAdminLastName() {
		return adminLastName;
	}

	public void setAdminLastName(String adminLastName) {
		this.adminLastName = adminLastName;
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

	public String getPassword() {
		return password;
	}

	public void setUserPassword(String userPassword) {
		this.password = userPassword;
	}

	
}
