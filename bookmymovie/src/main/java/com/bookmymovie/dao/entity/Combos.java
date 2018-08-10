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
@Table(name="combos")
public class Combos implements Serializable{

	private static final long serialVersionUID = -425092308664012108L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="CMB_ID")
	@NotNull
	private Long id;
	
	@Column(name="CMB_TITLE")
	private String title;
	
	@Column(name="CMB_DSC")
	private String description;
	
	@Column(name="CMB_AMT")
	private String amount;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
}
