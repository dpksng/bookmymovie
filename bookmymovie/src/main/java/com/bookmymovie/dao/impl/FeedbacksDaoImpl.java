package com.bookmymovie.dao.impl;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.bookmymovie.dao.api.FeedbacksDao;
import com.bookmymovie.dao.entity.Feedbacks;
import com.bookmymovie.service.HConnect;
import com.bookmymovie.service.JConnect;

@Transactional
@Repository
@Service
public class FeedbacksDaoImpl implements FeedbacksDao {
	
	@Autowired
	private HConnect con;
	
	public boolean insert(Feedbacks feed) {

		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			session.save(feed);
			t.commit();
			session.close();
			return true;
			
		} catch (Exception e) {
			
			System.out.println("Exception(ADD): " + e);
			return false;
		
		}
		
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Feedbacks> getAllFeedbacks() {

		List<Feedbacks> feed= new ArrayList<Feedbacks>();
		
		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			feed=session.createCriteria(Feedbacks.class).list();
			t.commit();
			session.close();
			return feed;
			
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return feed;
		}
		
	}

	public boolean delete(long feedId) {
		
		try {
			
			Statement st=JConnect.getStatement();
			st.executeUpdate("delete from feedback where FEED_ID='"+feedId+"'");
			return true;
			
		}catch(Exception exception) {
			exception.printStackTrace();
			return false;
		}
		
	}

}
