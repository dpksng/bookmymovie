package com.bookmymovie.dao.api;

import java.util.List;

import com.bookmymovie.dao.entity.User;

public interface UserDao {
	
	public boolean insert(User user);
	public List<User> getAllUser();
	public boolean delete(long userId);
	public boolean update(User user);
	public User getUserById(String userId);
	
}
