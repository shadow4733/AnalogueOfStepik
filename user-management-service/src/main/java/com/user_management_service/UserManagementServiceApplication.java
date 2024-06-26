package com.user_management_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScans({
	@ComponentScan("com.user_management_service.config"),
	@ComponentScan("com.user_management_service.security"),
	@ComponentScan("com.user_management_service.controller"),
	@ComponentScan("com.user_management_service.serviceImpl"),
	@ComponentScan("com.user_management_service.repository"),
})
public class UserManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagementServiceApplication.class, args);
	}

}
