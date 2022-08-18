package com.example.carrentalsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication//(exclude = {SecurityAutoConfiguration.class})
public class CarRentalSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarRentalSystemApplication.class, args);
	}

}
