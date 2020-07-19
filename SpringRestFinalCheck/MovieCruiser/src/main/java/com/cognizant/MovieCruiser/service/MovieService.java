package com.cognizant.MovieCruiser.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.MovieCruiser.dao.MovieDao;
import com.cognizant.MovieCruiser.exception.MovieNotFoundException;
import com.cognizant.MovieCruiser.model.Movie;


@Service
public class MovieService {
	@Autowired
	private MovieDao movieDao;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieService.class);
	
	public List<Movie> getMovieListCustomer(){
		LOGGER.info("Start");
		return movieDao.getMovieListCustomer();
	}

	public void modifyMovie(Movie movie) throws MovieNotFoundException {
		LOGGER.info("Start");
		movieDao.modifyMovie(movie);
		LOGGER.info("End");
	}

	public Movie getMovie(long movieId) throws MovieNotFoundException {
		LOGGER.info("Start");
		return movieDao.getMovie(movieId);
	}
}
