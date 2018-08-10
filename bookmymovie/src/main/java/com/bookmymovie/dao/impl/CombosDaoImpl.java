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

import com.bookmymovie.dao.api.CombosDao;
import com.bookmymovie.dao.entity.Combos;
import com.bookmymovie.service.HConnect;
import com.bookmymovie.service.JConnect;

@Transactional
@Repository
@Service
public class CombosDaoImpl implements CombosDao {
	
	@Autowired
	private HConnect con;

	public boolean insert(Combos combo) {

		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			session.save(combo);
			t.commit();
			session.close();
			return true;
			
		} catch (Exception e) {
			
			System.out.println("Exception(ADD): " + e);
			return false;
		
		}
		
		
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Combos> getAllCombos() {

		List<Combos> combo= new ArrayList<Combos>();
		
		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			combo=session.createCriteria(Combos.class).list();
			t.commit();
			session.close();
			return combo;
			
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return combo;
		}
		
	}

	public boolean delete(long comboId) {

		try {
			
			Statement st=JConnect.getStatement();
			st.executeUpdate("delete from combos where CMB_ID='"+comboId+"'");
			return true;
			
		}catch(Exception exception) {
			exception.printStackTrace();
			return false;
		}
		
	}

	public boolean update(Combos combo) {
		
		try {
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			session.update(combo);
			t.commit();
			session.close();
			return true;
			
		}catch (Exception e) {
				System.out.println("Exception(ADD): " + e);
				return false;
		}
		
	}

	public Combos getComboById(long comboId) {
		
		Combos combo=new Combos();	
		
		try {
			Statement st=JConnect.getStatement();
			ResultSet rs=st.executeQuery("select * from combos where CMB_ID='"+comboId+"'");
			while(rs.next()){
				combo.setId(rs.getLong("CMB_ID"));
				combo.setTitle(rs.getString("CMB_TITLE"));
				combo.setDescription(rs.getString("CMB_DSC"));
				combo.setAmount(rs.getString("CMB_AMT"));
				}
				
				return combo;
			
		}catch(Exception exception) {
			exception.printStackTrace();
			return combo;
		}
		
	}

}
