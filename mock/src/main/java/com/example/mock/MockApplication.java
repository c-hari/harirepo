package com.example.mock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MockApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockApplication.class, args);
		System.out.println("mock class started");
	}


}
