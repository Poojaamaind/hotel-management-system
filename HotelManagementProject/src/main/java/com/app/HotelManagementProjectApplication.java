package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.app.pojos"})
@EnableJpaRepositories(basePackages = {"com.app.dao"})
public class HotelManagementProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelManagementProjectApplication.class, args);
	}

}
