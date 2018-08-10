package com.bookmymovie.dao.api;

import java.util.List;

import com.bookmymovie.dao.entity.Movies;

public interface MoviesDao{
	
	public boolean insert(Movies movie);
	public List<Movies> getAllMovies();
	public List<Movies> getAllMoviesByCategory(String cat);
	public List<Movies> getAllMoviesByLanguage(String lang);
	public List<Movies> getAllMoviesByStatus(String stat);
	public List<Movies> getAllMoviesByTitle(String title);
	public List<Movies> getAllMoviesById(Long id);
	public boolean delete(long movieId);
	public boolean update(Movies movie);
	public Movies getMovieById(long movieId);
	
}
