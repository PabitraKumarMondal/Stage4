package com.cognizant.MovieCruiser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.MovieCruiser.exception.FavoritesEmptyException;
import com.cognizant.MovieCruiser.exception.MovieNotAddedInFavoritesException;
import com.cognizant.MovieCruiser.exception.MovieNotFoundException;
import com.cognizant.MovieCruiser.model.Movie;
import com.cognizant.MovieCruiser.service.FavoritesService;


@RestController
@RequestMapping("/favorites")
public class FavoritesController {

	@Autowired
	private FavoritesService favoritesService;

	@PostMapping("/{userId}/{menuItemId}")
	public void addFavoriteMovie(@PathVariable String userId, @PathVariable long id) throws MovieNotFoundException {
		favoritesService.addFavoriteMovie(userId, id);
	}
	
	@GetMapping("/{userId}")
	public List<Movie> getAllFavoriteMovies(@PathVariable String userId) throws FavoritesEmptyException {
		return favoritesService.getAllFavoriteMovies(userId);
	}
	
	@DeleteMapping("/{userId}/{menuItemId}")
	public void deleteFavoriteMovie(@PathVariable String userId, @PathVariable long id) throws FavoritesEmptyException, MovieNotAddedInFavoritesException {
		favoritesService.removeFavoriteMovie(userId, id);
	}
}
