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
@Table(name="feedback")
public class Feedbacks implements Serializable{

	private static final long serialVersionUID = 6345190045637522241L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="FEED_ID")
	@NotNull
	private Long id;
	
	@Column(name="FEED_EMAIL")
	private String email;
	
	@Column(name="FEED_DTE")
	private String date;
	
	@Column(name="FEEDBACK")
	private String feedback;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	
}
