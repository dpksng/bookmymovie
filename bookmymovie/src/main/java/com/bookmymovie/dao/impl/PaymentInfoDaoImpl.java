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

import com.bookmymovie.dao.api.PaymentInfoDao;
import com.bookmymovie.dao.entity.PaymentInfo;
import com.bookmymovie.service.HConnect;
import com.bookmymovie.service.JConnect;

@Transactional
@Repository
@Service
public class PaymentInfoDaoImpl implements PaymentInfoDao {
	
	@Autowired
	private HConnect con;
	
	public boolean insert(PaymentInfo payment) {
		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			session.save(payment);
			t.commit();
			session.close();
			return true;
			
		} catch (Exception e) {
			
			System.out.println("Exception(ADD): " + e);
			return false;
		
		}
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<PaymentInfo> getAllPaymentInfo() {
		
		List<PaymentInfo> payment= new ArrayList<PaymentInfo>();
		
		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			payment=session.createCriteria(PaymentInfo.class).list();
			t.commit();
			session.close();
			return payment;
			
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return payment;
		}
	}

	public boolean delete(String paymentId) {
		try {
			
			Statement st=JConnect.getStatement();
			st.executeUpdate("delete from payment_info where PAY_ID='"+paymentId+"'");
			return true;
			
		}catch(Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	public boolean update(PaymentInfo payment) {
		try {
		Session session = con.getSession();
		Transaction t = session.beginTransaction();
		session.update(payment);
		t.commit();
		session.close();
		return true;
		
		}catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return false;
		}
	}

	public PaymentInfo getPaymentById(String paymentId) {
		
		PaymentInfo payment=new PaymentInfo();
		
		try {
				Statement st=JConnect.getStatement();
				ResultSet rs=st.executeQuery("select * from payment_info where PAY_ID='"+paymentId+"'");
				while(rs.next()){
					payment.setId(rs.getLong("PAY_ID"));
					payment.setDate(rs.getString("PAY_DTE"));
					payment.setTime(rs.getString("PAY_TME"));
					payment.setAmount(rs.getString("PAY_AMT"));
			}
				
				return payment;
			
		}catch(Exception exception) {
			exception.printStackTrace();
			return payment;
		}
	}

}
