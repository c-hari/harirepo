package com.mockbean.mockbean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MockbeanApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockbeanApplication.class, args);
		System.out.println("mockbean class started");
	}

}
