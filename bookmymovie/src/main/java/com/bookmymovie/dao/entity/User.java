package com.bookmymovie.dao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="user_info")
public class User implements Serializable{

	private static final long serialVersionUID = 5195011099894740485L;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="USER_ID")
	@NotNull
	private long id;
		
	@Id
	@Column(name="USER_EMAIL")
	@NotNull
	private String email;
	
	@Column(name="USER_PWD")
	@Size(min = 8, max = 12, message = "Your password must contain between 6 and 12 letters")
	private String pwd;
	
	@Column(name="USER_CONF")
	private String conf;
	
	@Column(name="USER_NAME")
	private String name;
	
	@Column(name="USER_DOB")
	private String dob;
	
	@Column(name="USER_GENDER")
	private String gender;
	
	@Column(name="USER_RG_DTE")
	private String date;
	
	@Column(name="USER_RG_TME")
	private String time;
	
	@Column(name="USER_SQ_1")
	private String question1;
	
	@Column(name="USER_A_1")
	private String answer1;
	
	@Column(name="USER_SQ_2")
	private String question2;
	
	@Column(name="USER_A_2")
	private String answer2;
	
	@Column(name="enabled")
	private int enabled=1;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public String getPwd(){
		return pwd;
	}
	public void setPwd(String pwd){
		this.pwd = pwd;
	}
	public String getConf(){
		return conf;
	}
	public void setConf(String conf){
		this.conf = conf;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getDob(){
		return dob;
	}
	public void setDob(String dob){
		this.dob = dob;
	}
	public String getGender(){
		return gender;
	}
	public void setGender(String gender){
		this.gender = gender;
	}
	public String getDate(){
		return date;
	}
	public void setDate(String date){
		this.date = date;
	}
	public String getTime(){
		return time;
	}
	public void setTime(String time){
		this.time = time;
	}
	public String getQuestion1(){
		return question1;
	}
	public void setQuestion1(String question1) {
		this.question1 = question1;
	}
	public String getAnswer1(){
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public String getQuestion2(){
		return question2;
	}
	public void setQuestion2(String question2) {
		this.question2 = question2;
	}
	public String getAnswer2(){
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	
}
