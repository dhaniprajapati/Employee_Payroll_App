package com.bridgelabz.employeepayrollapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeePayrollApplication {
	public static final Logger logger= LoggerFactory.getLogger(EmployeePayrollApplication.class);
	public static void main(String[] args) {
		logger.info("Application starting...");
		SpringApplication.run(EmployeePayrollApplication.class, args);
		logger.info("Application started.");
	}
}
