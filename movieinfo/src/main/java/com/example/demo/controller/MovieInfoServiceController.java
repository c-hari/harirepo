package com.example.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Movie;

@RestController
@RequestMapping("/movie")
public class MovieInfoServiceController {

	@RequestMapping("/{movieId}")
	public Movie getDetails(@PathVariable ("movieId") String movieId)
	{
		//Movie movie=new Movie(movieId, "transformers");
		return new Movie(movieId, "Krish3") ;
		
	}
}
