package com.cognizant.MovieCruiser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.MovieCruiser.exception.MovieNotFoundException;
import com.cognizant.MovieCruiser.model.Movie;
import com.cognizant.MovieCruiser.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@GetMapping
	public List<Movie> getAllMovies(){
		return movieService.getMovieListCustomer();
	}
	@GetMapping("/{id}")
	public Movie getMovie(@PathVariable long id) throws MovieNotFoundException {
		return movieService.getMovie(id);
	}
	@PutMapping
	public void modifyMenuItem(@RequestBody Movie movie) throws MovieNotFoundException {
		movieService.modifyMovie(movie);
	}
}
