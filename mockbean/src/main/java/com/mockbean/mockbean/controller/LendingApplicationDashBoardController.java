package com.mockbean.mockbean.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mockbean.mockbean.service.LendingApplicationServiceImpl;

@RestController
@RequestMapping("/lending/preview")
public class LendingApplicationDashBoardController {
	
	
	@Autowired
	LendingApplicationServiceImpl service;
	
	@GetMapping("/export/{s}")
	public ResponseEntity<String> getExport(@PathVariable String s) {
		System.out.println("Received request for " + s);
		String data = service.getData(s);
		System.out.println("Sending response for " + data);
		return ResponseEntity.ok(data);
		
		
	}

}
