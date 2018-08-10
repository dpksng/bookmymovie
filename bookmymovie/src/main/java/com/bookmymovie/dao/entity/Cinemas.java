package com.bookmymovie.dao.entity;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="cinemas")
public class Cinemas{

	@Id
	@Column(name="CNM_ID")
	@NotNull
	private Long id;
		
	@Column(name="CNM_NAME")
	private String name;
	
	@Column(name="CNM_LOC")
	private String location;
	
	@Column(name="CNM_S_1")
	private String t1="09:10 AM";
	
	@Column(name="CNM_S_2")
	private String t2="12:15 PM";
	
	@Column(name="CNM_S_3")
	private String t3="03:30 PM";
	
	@Column(name="CNM_S_4")
	private String t4="06:10 PM";
	
	@Column(name="CNM_S_5")
	private String t5="11:15 PM";
	
	@Column(name="CNM_DTE")
	private String date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getT1() {
		return t1;
	}

	public void setT1(String t1) {
		this.t1 = t1;
	}

	public String getT2() {
		return t2;
	}

	public void setT2(String t2) {
		this.t2 = t2;
	}

	public String getT3() {
		return t3;
	}

	public void setT3(String t3) {
		this.t3 = t3;
	}

	public String getT4() {
		return t4;
	}

	public void setT4(String t4) {
		this.t4 = t4;
	}

	public String getT5() {
		return t5;
	}

	public void setT5(String t5) {
		this.t5 = t5;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
	
	