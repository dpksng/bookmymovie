package com.bookmymovie.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="admin_info")
public class Admin{
	
	@Id
	@Column(name="ADMIN_ID")
	@NotNull
	private String id;
	
	@Column(name="ADMIN_NAME")
	private String name;
	
	@Column(name="ADMIN_GENDER")
	private String gender;
	
	@Column(name="ADMIN_PWD")
	private String pwd;
	
	@Column(name="enabled")
	private int enabled=1;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
