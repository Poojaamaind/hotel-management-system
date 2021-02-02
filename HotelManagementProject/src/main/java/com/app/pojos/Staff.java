package com.app.pojos;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table
public class Staff {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer staffId;
	
	
	private String username;
	
	@Column(length = 10)
	private String password;
	
	public String staffFirstName;
	public String staffLastName;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Gender gender;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private ServiceRole role;

	@Temporal(TemporalType.DATE)
	@Column(name = "dob")
	private Date dateOfBirth;
	private String address;
	@Column( length = 11)
	private String phoneNumber;
	
	public String adharNumber;
	public Integer getStaffId() {
		return staffId;
	}
	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}
	
	public String getStaffFirstName() {
		return staffFirstName;
	}
	public void setStaffFirstName(String staffFirstName) {
		this.staffFirstName = staffFirstName;
	}
	public String getStaffLastName() {
		return staffLastName;
	}
	public void setStaffLastName(String staffLastName) {
		this.staffLastName = staffLastName;
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
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ServiceRole getRole() {
		return role;
	}
	public void setRole(ServiceRole role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", username=" + username + ", password=" + password
				+ ", staffFirstName=" + staffFirstName + ", staffLastName=" + staffLastName + ", gender=" + gender
				+ ", dateOfBirth=" + dateOfBirth + ", address=" + address + ", phoneNumber=" + phoneNumber
				+ ", adharNumber=" + adharNumber + "]";
	}
	

}
