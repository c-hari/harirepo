package com.example.mock.controller;

import com.example.mock.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/mock")
public class MockController {
	
	@Autowired
	RestTemplate restTemplate;
	
	/*@GetMapping("/export")
	public ResponseEntity<String> getFromRestApi(@RequestParam String string) 
	
	{
		String url="http://localhost:8080/lending/preview/export?s="+string;
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class) ;
		
		return ResponseEntity.ok(response.getBody());		
	}*/

	@GetMapping("/export/{string}")
	public ResponseEntity<String> getFromRestApis(@PathVariable String string)

	{
		String url="http://localhost:8080/lending/preview/export/{string}";
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class,string) ;

		return ResponseEntity.ok(response.getBody());
	}

	@GetMapping("/findById/{custId}")
	ResponseEntity<Customer> findById(@PathVariable Integer custId) {

		{
			String url ="http://localhost:8080/customer/findById/{custId}";
			ResponseEntity<Customer> response = restTemplate.getForEntity(url, Customer.class,custId);

			return ResponseEntity.ok(response.getBody());
		}

	}}
