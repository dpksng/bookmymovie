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
@Table(name="show_timing")
public class ShowTimings implements Serializable{

	private static final long serialVersionUID = 4401856235139639080L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="TIME_ID")
	@NotNull
	private Long id;
	
	@Column(name="TIME")
	private String time;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
}
