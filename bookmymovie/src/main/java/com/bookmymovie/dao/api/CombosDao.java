package com.bookmymovie.dao.api;

import java.util.List;

import com.bookmymovie.dao.entity.Combos;

public interface CombosDao {
		
	public boolean insert(Combos combo);
	public List<Combos> getAllCombos();
	public boolean delete(long comboId);
	public boolean update(Combos combo);
	public Combos getComboById(long comboId);
		
}
