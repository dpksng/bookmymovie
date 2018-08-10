package com.bookmymovie.dao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="booking_details")
public class BookingDetails implements Serializable{

	private static final long serialVersionUID = 2748795974057284953L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="BOOK_ID")
	@NotNull
	private Long id;
	
	@Column(name="BOOK_DTE")
	private String date;
	
	@Column(name="BOOK_TME")
	private String time;
	
	@Column(name="BOOK_AMT")
	private String amount;
	
	@Column(name="BOOK_T_CNT")
	private String count;
	
	@Column(name="BOOK_S_DTE")
	private String showDate;
	
	@Column(name="BOOK_S_TME")
	private String showTime;
	
	@Column(name="MOVIE")
	private String movie;
	
	@Column(name="BOOK_S")
	private String status;
	
	@Column(name="SEATS")
	private String seats;
	
	@Column(name="USER")
	private String email;
	
	@Column(name="CINEMA")
	private String cinema;
	
	@Column(name="COMBO")
	private String combo;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getShowDate() {
		return showDate;
	}

	public void setShowDate(String showDate) {
		this.showDate = showDate;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSeats() {
		return seats;
	}

	public void setSeats(String seats) {
		this.seats = seats;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCinema() {
		return cinema;
	}

	public void setCinema(String cinema) {
		this.cinema = cinema;
	}

	public String getCombo() {
		return combo;
	}

	public void setCombo(String combo) {
		this.combo = combo;
	}
	
}
