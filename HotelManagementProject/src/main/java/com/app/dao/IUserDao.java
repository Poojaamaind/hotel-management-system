package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.User;

public interface IUserDao extends JpaRepository<User, Integer>{

//	@Query("select u from u where u.userName=:name AND u.userPassword=:id")
//	Optional<User> findByUsernameAndUserpassword(@Param("name")String username, @Param("id")String password);
	
     User findByUsername(String username);
}
