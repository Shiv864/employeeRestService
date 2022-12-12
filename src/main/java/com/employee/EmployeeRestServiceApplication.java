package com.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
//
public class EmployeeRestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeRestServiceApplication.class, args);
	}

}
