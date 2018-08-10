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

import com.bookmymovie.dao.api.SeatsDao;
import com.bookmymovie.dao.entity.Seats;
import com.bookmymovie.service.HConnect;
import com.bookmymovie.service.JConnect;

@Transactional
@Repository
@Service
public class SeatsDaoImpl implements SeatsDao {
	
	@Autowired
	private HConnect con;
	
	public boolean insert(Seats seat){
		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			session.save(seat);
			t.commit();
			session.close();
			return true;
			
		} catch (Exception e) {
			
			System.out.println("Exception(ADD): " + e);
			return false;
		
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Seats> getAllSeats(){
		
		List<Seats> seat= new ArrayList<Seats>();
		
		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			seat=session.createCriteria(Seats.class).list();
			t.commit();
			session.close();
			return seat;
			
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return seat;
		}
	}

	public boolean update(Seats seat) {
		try {
		Session session = con.getSession();
		Transaction t = session.beginTransaction();
		session.update(seat);
		t.commit();
		session.close();
		return true;
		
		}catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return false;
		}
	}

	public Seats getSeatById(String seatId) {
		Seats seat=new Seats();
		
		try {
				Statement st=JConnect.getStatement();
				ResultSet rs=st.executeQuery("select * from seats where SEAT_ID='"+seatId+"'");
				while(rs.next()){
					seat.setId(rs.getLong("SEAT_ID"));
					seat.setCinemaKey(rs.getLong("CNM_KEY"));
					seat.setTime(rs.getString("TIME"));
					seat.setStatus(rs.getString("SEAT_S"));
			}
				
				return seat;
			
		}catch(Exception exception) {
			exception.printStackTrace();
			return seat;
		}
	}
	
}
