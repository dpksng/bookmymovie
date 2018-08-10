package com.bookmymovie.dao.api;

import java.util.List;

import com.bookmymovie.dao.entity.Cinemas;

public interface CinemasDao{
	
	public boolean insert(Cinemas cinema);
	public List<Cinemas> getAllCinemas();
	public boolean delete(long cinemaId);
	public boolean update(Cinemas cinema);
	public Cinemas getCinemaById(String cinemaId);
}
