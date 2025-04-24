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
		 return new ResponseEntity<String>( service.getData(s),HttpStatusCode.valueOf(200));
		
		
	}

}
