package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Admin;
import com.app.pojos.User;

public interface IAdminDao extends JpaRepository<Admin, Integer>{

	Admin findByUsername(String username);
	Optional<Admin> findByUsernameAndPassword(String username,String password);
	
}
