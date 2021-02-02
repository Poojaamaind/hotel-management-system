package com.app.pojos;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="User")
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private Integer userId;
	
	
	@Column(unique = true)
	private String username;
	
	@Column(length = 10)
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(unique = false)
	private UserRole userRole;
	

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	



	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + username + ", password=" + password + ", userRole="
				+ userRole + "]";
	}
	

	
	
}
