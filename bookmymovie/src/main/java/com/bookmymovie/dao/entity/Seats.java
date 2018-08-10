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
@Table(name="seats")
public class Seats implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="SEAT_ID")
	@NotNull
	private Long id;
	
	@Column(name="CNM_KEY")
	private long cinemaKey;
	
	@Column(name="TIME")
	private String time;
	
	@Column(name="SEAT_S")
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getCinemaKey() {
		return cinemaKey;
	}

	public void setCinemaKey(long cinemaKey) {
		this.cinemaKey = cinemaKey;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

}
