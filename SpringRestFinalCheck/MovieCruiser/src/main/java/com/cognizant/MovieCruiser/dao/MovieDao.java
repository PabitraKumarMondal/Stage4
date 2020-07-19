package com.cognizant.MovieCruiser.dao;

import java.util.List;

import com.cognizant.MovieCruiser.exception.MovieNotFoundException;
import com.cognizant.MovieCruiser.model.Movie;

public interface MovieDao {
	public List<Movie> getMovieListCustomer();

	public void modifyMovie(Movie movie) throws MovieNotFoundException;

	public Movie getMovie(long movieId) throws MovieNotFoundException;
}
