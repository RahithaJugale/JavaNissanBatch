package com.nissan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerAndSalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerAndSalesApplication.class, args);
		System.out.println("My Spring boot App is running fine...");
	}

}
