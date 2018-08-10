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

import com.bookmymovie.dao.api.CinemasDao;
import com.bookmymovie.dao.entity.Cinemas;
import com.bookmymovie.service.HConnect;
import com.bookmymovie.service.JConnect;

@Transactional
@Repository
@Service
public class CinemasDaoImpl implements CinemasDao {

	@Autowired
	private HConnect con;
	
	public boolean insert(Cinemas cinema) {
		
		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			session.save(cinema);
			t.commit();
			session.close();
			return true;
			
		} catch (Exception e) {
			
			System.out.println("Exception(ADD): " + e);
			return false;
		
		}
		
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Cinemas> getAllCinemas() {

		List<Cinemas> cinema= new ArrayList<Cinemas>();
		
		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			cinema=session.createCriteria(Cinemas.class).list();
			t.commit();
			session.close();
			return cinema;
			
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return cinema;
		}
		
	}

	public boolean delete(long cinemaId) {

		try {
			
			Statement st=JConnect.getStatement();
			st.executeUpdate("delete from cinemas where CNM_ID='"+cinemaId+"'");
			return true;
			
		}catch(Exception exception) {
			exception.printStackTrace();
			return false;
		}

	}

	public boolean update(Cinemas cinema) {

		try {
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			session.update(cinema);
			t.commit();
			session.close();
			return true;
			
			}catch (Exception e) {
				System.out.println("Exception(ADD): " + e);
				return false;
			}
		
	}

	public Cinemas getCinemaById(String cinemaId) {

		Cinemas cinema=new Cinemas();	
		
		try {
			Statement st=JConnect.getStatement();
			ResultSet rs=st.executeQuery("select * from cinemas where CNM_ID='"+cinemaId+"'");
			while(rs.next()){
				cinema.setId(rs.getLong("CNM_ID"));
				cinema.setName(rs.getString("CNM_NAME"));
				cinema.setLocation(rs.getString("CNM_LOC"));
				cinema.setDate(rs.getString("CNM_DTE"));
				cinema.setT1(rs.getString("CNM_S_1"));
				cinema.setT2(rs.getString("CNM_S_2"));
				cinema.setT3(rs.getString("CNM_S_3"));
				cinema.setT4(rs.getString("CNM_S_4"));
				cinema.setT5(rs.getString("CNM_S_5"));
				}
				
				return cinema;
			
		}catch(Exception exception) {
			exception.printStackTrace();
			return cinema;
		}
		
	}

}
