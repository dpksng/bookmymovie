package com.bookmymovie.dao.api;

import java.util.List;

import com.bookmymovie.dao.entity.ShowTimings;

public interface ShowTimingsDao{

	public boolean insert(ShowTimings show);
	public List<ShowTimings> getAllShowTimings();
	public boolean delete(String showId);
	public boolean update(ShowTimings show);
	public ShowTimings getShowById(String showId);
	
}
