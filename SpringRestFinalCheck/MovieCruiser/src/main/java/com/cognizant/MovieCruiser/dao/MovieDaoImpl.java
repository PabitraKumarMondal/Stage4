package com.cognizant.MovieCruiser.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.MovieCruiser.exception.MovieNotFoundException;
import com.cognizant.MovieCruiser.model.Movie;

@Repository
public class MovieDaoImpl implements MovieDao{

	private static ArrayList<Movie> movieList;
	
	public MovieDaoImpl() {
		ApplicationContext context = new ClassPathXmlApplicationContext("movieCruiser.xml");
		movieList = (ArrayList<Movie>) context.getBean("movieList");
	}
	
	@Override
	public List<Movie> getMovieListCustomer() {
		return movieList;
	}

	@Override
	public void modifyMovie(Movie movie) throws MovieNotFoundException {
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).equals(movie)) {
				movieList.set(i, movie);
				return;
			}
		}
		throw new MovieNotFoundException();
	}

	@Override
	public Movie getMovie(long movieId) throws MovieNotFoundException {
		Movie movie = null;
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getId() == movieId) {
				movie = movieList.get(i);
				break;
			}
		}
		if(movie == null)
			throw new MovieNotFoundException();
		return movie;
	}

}
