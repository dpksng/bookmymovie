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

import com.bookmymovie.dao.api.UserDao;
import com.bookmymovie.dao.entity.User;
import com.bookmymovie.service.HConnect;
import com.bookmymovie.service.JConnect;

@Transactional
@Repository
@Service
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private HConnect con;
	
	public boolean insert(User user){
		
		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			session.save(user);
			t.commit();
			session.close();
			return true;
			
		} catch (Exception e) {
			
			System.out.println("Exception(ADD): " + e);
			return false;
		
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<User> getAllUser(){
		
		List<User> user= new ArrayList<User>();
		
		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			user=session.createCriteria(User.class).list();
			t.commit();
			session.close();
			return user;
			
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return user;
		}
	}
	
	public boolean delete(long userId){
		
		try {
			
			Statement st=JConnect.getStatement();
			st.executeUpdate("delete from user_info where USER_ID='"+userId+"'");
			return true;
			
		}catch(Exception exception) {
			exception.printStackTrace();
			return false;
		}
		
	}

	public boolean update(User user){
			
		try {
		Session session = con.getSession();
		Transaction t = session.beginTransaction();
		session.update(user);
		t.commit();
		session.close();
		return true;
		
		}catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return false;
		}
	}

	public User getUserById(String userId){
	
		User user=new User();
		
		try {
				Statement st=JConnect.getStatement();
				ResultSet rs=st.executeQuery("select * from user_info where USER_EMAIL='"+userId+"'");
				while(rs.next()){
					user.setId(rs.getLong("USER_ID"));
					user.setEmail(rs.getString("USER_EMAIL"));
					user.setName(rs.getString("USER_NAME"));
					user.setDob(rs.getString("USER_DOB"));
					user.setGender(rs.getString("USER_GENDER"));
					user.setPwd(rs.getString("USER_PWD"));
					user.setQuestion1(rs.getString("USER_SQ_1"));
					user.setAnswer1(rs.getString("USER_A_1"));
					user.setQuestion2(rs.getString("USER_SQ_2"));
					user.setAnswer2(rs.getString("USER_A_2"));
					user.setDate(rs.getString("USER_RG_DTE"));
					user.setTime(rs.getString("USER_RG_TME"));
					user.setConf(rs.getString("USER_CONF"));
				}
				
				return user;
			
		}catch(Exception exception) {
			exception.printStackTrace();
			return user;
		}
		
	}
		
		
}
