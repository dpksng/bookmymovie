package com.bookmymovie.dao.api;

import java.util.List;

import com.bookmymovie.dao.entity.PaymentInfo;

public interface PaymentInfoDao{
	
	public boolean insert(PaymentInfo payment);
	public List<PaymentInfo> getAllPaymentInfo();
	public boolean delete(String paymentId);
	public boolean update(PaymentInfo payment);
	public PaymentInfo getPaymentById(String paymentId);

}
