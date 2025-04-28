package com.example.mock.controller;

import com.example.mock.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/mock")
public class MockController {
	
	@Autowired
	RestTemplate restTemplate;
	
	/*  @GetMapping("/export/{name}")
	public ResponseEntity<String> getExport(@PathVariable String name) {
		String url = "http://mockbean/lending/preview/export/{name}";
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class, name);
		return ResponseEntity.ok(response.getBody());
	}*/

	@GetMapping("/export/{string}")
	public ResponseEntity<String> getFromRestApis(@PathVariable String string) {

		try {
			String url = "http://mockbean/lending/preview/export/{string}";
			ResponseEntity<String> response = restTemplate.getForEntity(url, String.class, string);

			return ResponseEntity.ok(response.getBody());
		} catch (ResourceAccessException E) {
			System.out.println("Failed to call mockbean: " + E.getMessage());
			return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body("Timeout occurred when calling mockbean");

		}

	}
	@GetMapping("/findById/{custId}")
	ResponseEntity<?> findById(@PathVariable Integer custId) {

		String url = "http://mockbean/customer/findById/{custId}";
		try {
			ResponseEntity<Customer> response = restTemplate.getForEntity(url, Customer.class, custId);
			return ResponseEntity.ok(response.getBody());
		} catch (ResourceAccessException ex) {
			// This happens when there are connection issues like timeout
			System.err.println("ResourceAccessException: " + ex.getMessage());
			return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT)
					.body("Unable to reach mockbean service. Please try again later.");
		} catch (HttpClientErrorException ex) {
			// 4xx client errors (e.g., 404 Not Found)
			System.err.println("HttpClientErrorException: " + ex.getMessage());
			return ResponseEntity.status(ex.getStatusCode())
					.body("Client error: " + ex.getStatusText());
		} catch (HttpServerErrorException ex) {
			// 5xx server errors
			System.err.println("HttpServerErrorException: " + ex.getMessage());
			return ResponseEntity.status(ex.getStatusCode())
					.body("Server error: " + ex.getStatusText());
		} catch (Exception ex) {
			// Catch-all for any other exceptions
			System.err.println("Exception: " + ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("An unexpected error occurred.");
		}


	}
	@PostMapping("/save")
	public ResponseEntity<?> save( @RequestBody Customer customer) {
		String url = "http://mockbean/customer/save";
		try{
			ResponseEntity<Customer> response=restTemplate.postForEntity(url,customer, Customer.class);
			return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
		}
		catch (ResourceAccessException ex) {
			System.err.println("Service unreachable: " + ex.getMessage());
			return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT)
					.body("Service unavailable. Try again later.");
		} catch (HttpClientErrorException | HttpServerErrorException ex) {
			System.err.println("HTTP error: " + ex.getMessage());
			return ResponseEntity.status(ex.getStatusCode())
					.body("Error during save: " + ex.getResponseBodyAsString());
		} catch (Exception ex) {
			System.err.println("Unexpected error: " + ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Unexpected error occurred.");
		}

	}
}
