package com.ourcampfire.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity
public class OurCampfireUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OurCampfireUserServiceApplication.class, args);
	}

}
