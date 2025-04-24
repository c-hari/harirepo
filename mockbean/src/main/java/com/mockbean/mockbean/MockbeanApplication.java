package com.mockbean.mockbean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MockbeanApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockbeanApplication.class, args);
		System.out.println("mockbean class started");
	}

}
