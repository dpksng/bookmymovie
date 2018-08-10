package com.bookmymovie.dao.api;

import java.util.List;

import com.bookmymovie.dao.entity.Seats;

public interface SeatsDao {
	
	public boolean insert(Seats seat);
	public List<Seats> getAllSeats();
	public boolean update(Seats seat);
	public Seats getSeatById(String seatId);

}
