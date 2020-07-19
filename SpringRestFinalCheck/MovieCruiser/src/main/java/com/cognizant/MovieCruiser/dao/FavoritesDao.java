package com.cognizant.MovieCruiser.dao;

import java.util.List;

import com.cognizant.MovieCruiser.exception.FavoritesEmptyException;
import com.cognizant.MovieCruiser.exception.MovieNotAddedInFavoritesException;
import com.cognizant.MovieCruiser.exception.MovieNotFoundException;
import com.cognizant.MovieCruiser.model.Movie;

public interface FavoritesDao {
	void addFavoriteMovie(String userId, long movieId) throws MovieNotFoundException;

	List<Movie> getAllFavoriteMovies(String userId) throws FavoritesEmptyException;

	void removeFavoriteMovie(String userId, long movieId) throws FavoritesEmptyException, MovieNotAddedInFavoritesException;

	long getNoOfFavoites(String userId);
}
