package com.bookmymovie.dao.api;

import java.util.List;

import com.bookmymovie.dao.entity.Feedbacks;

public interface FeedbacksDao{
	
	public boolean insert(Feedbacks feed);
	public List<Feedbacks> getAllFeedbacks();
	public boolean delete(long feedId);
}
