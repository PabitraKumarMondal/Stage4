package com.cognizant.MovieCruiser.model;

import java.util.List;

import com.cognizant.MovieCruiser.model.Movie;

public class Favorites {
	private long noOfMovies;
	private List<Movie> movieList;
	
	public Favorites() {
		
	}

	public Favorites(long noOfMovies, List<Movie> movieList) {
		this.noOfMovies = noOfMovies;
		this.movieList = movieList;
	}

	public long getNoOfMovies() {
		return noOfMovies;
	}
	
	public void setNoOfMovies(long noOfMovies) {
		this.noOfMovies = noOfMovies;
	}
	
	public List<Movie> getMovieList() {
		return movieList;
	}
	
	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	@Override
	public String toString() {
		return "Favorites [noOfMovies=" + noOfMovies + ", movieList=" + movieList + "]";
	}
	
}
