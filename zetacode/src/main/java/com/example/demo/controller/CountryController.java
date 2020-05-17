package com.example.demo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Country;

@Controller

public class CountryController {
	@RequestMapping(value="/getCountry")
	public ResponseEntity<Country> getCountry()
	{
		
		
		Country c=new Country();
		
		c.setCountryName("india");
		c.setPopulation(978098);
		
		HttpHeaders h=new HttpHeaders();
		h.add("responded","CountryController");
		
		return ResponseEntity.accepted().headers(h).body(c);
		
	}

}
