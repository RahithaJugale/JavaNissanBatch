package com.nissan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProfessorMonitoringSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfessorMonitoringSystemApplication.class, args);
		System.out.println("My Professor monitorinf=g system is running fine...");
	}

}
