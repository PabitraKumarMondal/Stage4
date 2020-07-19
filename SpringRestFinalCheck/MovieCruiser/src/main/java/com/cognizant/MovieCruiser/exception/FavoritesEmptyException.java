package com.cognizant.MovieCruiser.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No movie in Favorites")
public class FavoritesEmptyException extends Exception {

	public FavoritesEmptyException() {
		super();
		// TODO Auto-generated constructor stub
	}
}
