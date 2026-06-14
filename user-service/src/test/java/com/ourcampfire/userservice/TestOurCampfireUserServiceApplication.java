package com.ourcampfire.userservice;

import org.springframework.boot.SpringApplication;

public class TestOurCampfireUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(OurCampfireUserServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
