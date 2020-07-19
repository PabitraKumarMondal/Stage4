package com.cognizant.MovieCruiser.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.MovieCruiser.dao.FavoritesDao;
import com.cognizant.MovieCruiser.exception.FavoritesEmptyException;
import com.cognizant.MovieCruiser.exception.MovieNotAddedInFavoritesException;
import com.cognizant.MovieCruiser.exception.MovieNotFoundException;
import com.cognizant.MovieCruiser.model.Movie;

@Service
public class FavoritesService {
	@Autowired
	private FavoritesDao favoritesDao;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FavoritesService.class);
	
	public void addFavoriteMovie(String userId, long movieId) throws MovieNotFoundException{
		LOGGER.info("Start");
		favoritesDao.addFavoriteMovie(userId, movieId);
		LOGGER.info("End");
	}

	public List<Movie> getAllFavoriteMovies(String userId) throws FavoritesEmptyException{
		LOGGER.info("Start");
		return favoritesDao.getAllFavoriteMovies(userId);
	}

	public void removeFavoriteMovie(String userId, long movieId) throws FavoritesEmptyException, MovieNotAddedInFavoritesException{
		LOGGER.info("Start");
		favoritesDao.removeFavoriteMovie(userId, movieId);
		LOGGER.info("End");
	}

	public long getNoOfFavoites(String userId) {
		LOGGER.info("Start");
		return favoritesDao.getNoOfFavoites(userId);
	}
}
