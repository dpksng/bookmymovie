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
@Table(name="movies")
public class Movies implements Serializable{
	
	private static final long serialVersionUID = 6090794084780581066L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="MOV_ID")
	@NotNull
	private Long id;
	
	@Column(name="MOV_TITLE")
	private String title;
	
	@Column(name="MOV_R_DTE")
	private String date;
	
	@Column(name="MOV_LEN")
	private String length;
	
	@Column(name="MOV_CAT")
	private String category;
	
	@Column(name="MOV_LANG")
	private String language;
	
	@Column(name="MOV_DSC")
	private String description;
	
	@Column(name="MOV_CAST")
	private String cast;
	
	@Column(name="MOV_IMAGE")
	private String image;
	
	@Column(name="MOV_S")
	private String status;
	
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCast() {
		return cast;
	}
	public void setCast(String cast) {
		this.cast = cast;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
