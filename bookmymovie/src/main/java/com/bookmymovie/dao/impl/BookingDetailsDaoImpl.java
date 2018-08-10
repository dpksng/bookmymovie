package com.bookmymovie.dao.impl;

import java.sql.ResultSet;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.bookmymovie.dao.api.BookingDetailsDao;
import com.bookmymovie.dao.entity.BookingDetails;
import com.bookmymovie.service.HConnect;
import com.bookmymovie.service.JConnect;

@Transactional
@Repository
@Service
public class BookingDetailsDaoImpl implements BookingDetailsDao {

	@Autowired
	private HConnect con;
	
	public boolean insert(BookingDetails bd) {

		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			session.save(bd);
			t.commit();
			session.close();
			return true;
			
		} catch (Exception e) {
			
			System.out.println("Exception(ADD): " + e);
			return false;
		
		}

	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<BookingDetails> getAllBookingDetails() {

		List<BookingDetails> bd= new ArrayList<BookingDetails>();
		
		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			bd=session.createCriteria(BookingDetails.class).list();
			t.commit();
			session.close();
			return bd;
			
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return bd;
		}
		
	}

	public boolean delete(long bookingDetailId) {

		try {
			
			Statement st=JConnect.getStatement();
			st.executeUpdate("delete from booking_details where BOOK_ID='"+bookingDetailId+"'");
			return true;
			
		}catch(Exception exception) {
			exception.printStackTrace();
			return false;
		}
		
	}

	public boolean update(BookingDetails bd) {

		try {
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			session.update(bd);
			t.commit();
			session.close();
			return true;
			
		}catch (Exception e) {
				System.out.println("Exception(ADD): " + e);
				return false;
		}
		
	}

	public BookingDetails getBookingDetailById(String bookingDetailId) {

		BookingDetails bd=new BookingDetails();
		
		try {
				Statement st=JConnect.getStatement();
				ResultSet rs=st.executeQuery("select * from booking_details where SEATS='"+bookingDetailId+"'");
				while(rs.next()){
					bd.setId(rs.getLong("BOOK_ID"));
					bd.setDate(rs.getString("BOOK_DTE"));
					bd.setTime(rs.getString("BOOK_TME"));
					bd.setAmount(rs.getString("BOOK_AMT"));
					bd.setCount(rs.getString("BOOK_T_CNT"));
					bd.setShowDate(rs.getString("BOOK_S_DTE"));
					bd.setShowTime(rs.getString("BOOK_S_TME"));
					bd.setMovie(rs.getString("MOVIE"));
					bd.setStatus(rs.getString("BOOK_S"));
					bd.setEmail(rs.getString("USER"));
					bd.setCinema(rs.getString("CINEMA"));
					bd.setCombo(rs.getString("COMBO"));
					bd.setSeats(rs.getString("SEATS"));
				}
				
				return bd;
			
		}catch(Exception exception) {
			exception.printStackTrace();
			return bd;
		}
		
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<BookingDetails> getAllBookingByUser(String email) {
		
		List<BookingDetails> bd= new ArrayList<BookingDetails>();
		
		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			Criteria cr=session.createCriteria(BookingDetails.class);
			cr.add(Restrictions.eq("email", email));
			bd=cr.list();
			t.commit();
			session.close();
			return bd;
			
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return bd;
		}
	}

}
