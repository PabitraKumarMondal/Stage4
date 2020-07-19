package com.cognizant.MovieCruiser.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cognizant.MovieCruiser.exception.FavoritesEmptyException;
import com.cognizant.MovieCruiser.exception.MovieNotAddedInFavoritesException;
import com.cognizant.MovieCruiser.exception.MovieNotFoundException;
import com.cognizant.MovieCruiser.model.Favorites;
import com.cognizant.MovieCruiser.model.Movie;

@Repository
public class FavoritesDaoImpl implements FavoritesDao {

	private static HashMap<String, Favorites> favoriteMovies;
	
	public FavoritesDaoImpl() {
		if(favoriteMovies == null)
			favoriteMovies = new HashMap<>();
	}

	@Override
	public void addFavoriteMovie(String userId, long movieId) throws MovieNotFoundException {
		MovieDao movieDao = new MovieDaoImpl();
		Movie movie = movieDao.getMovie(movieId);
		if(favoriteMovies.containsKey(userId)) {
			Favorites fav = favoriteMovies.get(userId);
			fav.getMovieList().add(movie);
			fav.setNoOfMovies(fav.getNoOfMovies() + 1);
		} else {
			Favorites fav = new Favorites(0, new ArrayList<Movie>());
			fav.getMovieList().add(movie);
			fav.setNoOfMovies(1);
			favoriteMovies.put(userId, fav);
		}
	}

	@Override
	public List<Movie> getAllFavoriteMovies(String userId) throws FavoritesEmptyException{
		if(favoriteMovies.containsKey(userId))
			return favoriteMovies.get(userId).getMovieList();
		throw new FavoritesEmptyException();
	}

	@Override
	public void removeFavoriteMovie(String userId, long movieId) throws FavoritesEmptyException, MovieNotAddedInFavoritesException {
		if (favoriteMovies.containsKey(userId)) {		
			List<Movie> movieList = favoriteMovies.get(userId).getMovieList();
			for (int i = 0; i < movieList.size(); i++) {
				if (movieList.get(i).getId() == movieId) {
					movieList.remove(i);
					return;
				}
			}
			throw new MovieNotAddedInFavoritesException();
		}
		throw new FavoritesEmptyException();
	}


	@Override
	public long getNoOfFavoites(String userId) {
		return favoriteMovies.get(userId).getNoOfMovies();
	}

}
