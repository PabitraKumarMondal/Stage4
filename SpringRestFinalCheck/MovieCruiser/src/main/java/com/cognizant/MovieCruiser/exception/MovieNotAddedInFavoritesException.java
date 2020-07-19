package com.cognizant.MovieCruiser.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Movie not added in Favorites")
public class MovieNotAddedInFavoritesException extends Exception {

	public MovieNotAddedInFavoritesException() {
		super();
		// TODO Auto-generated constructor stub
	}	
}
