package com.bookmymovie.dao.impl;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.bookmymovie.dao.api.ShowTimingsDao;
import com.bookmymovie.dao.entity.ShowTimings;
import com.bookmymovie.service.HConnect;
import com.bookmymovie.service.JConnect;


@Transactional
@Repository
@Service
public class ShowTimingsDaoImpl implements ShowTimingsDao {

	@Autowired
	private HConnect con;	
	
	public boolean insert(ShowTimings show) {
		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			session.save(show);
			t.commit();
			session.close();
			return true;
			
		} catch (Exception e) {
			
			System.out.println("Exception(ADD): " + e);
			return false;
		
		}
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<ShowTimings> getAllShowTimings() {
		List<ShowTimings> show= new ArrayList<ShowTimings>();
		
		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			show=session.createCriteria(ShowTimings.class).list();
			t.commit();
			session.close();
			return show;
			
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return show;
		}
	}

	public boolean delete(String showId) {
		try {
			
			Statement st=JConnect.getStatement();
			st.executeUpdate("delete from show_timing where TIME_ID='"+showId+"'");
			return true;
			
		}catch(Exception exception) {
			exception.printStackTrace();
			return false;
		}
	
	}

	public boolean update(ShowTimings show) {
		try {
		Session session = con.getSession();
		Transaction t = session.beginTransaction();
		session.update(show);
		t.commit();
		session.close();
		return true;
		
		}catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return false;
		}
	}

	public ShowTimings getShowById(String showId) {
		
		ShowTimings show=new ShowTimings();
		
		try {
				Statement st=JConnect.getStatement();
				ResultSet rs=st.executeQuery("select * from show_timing where TIME_ID='"+showId+"'");
				while(rs.next()){
					show.setId(rs.getLong("TIME_ID"));
					show.setTime(rs.getString("TIME"));
			}
				
				return show;
			
		}catch(Exception exception) {
			exception.printStackTrace();
			return show;
		}
	}

}
