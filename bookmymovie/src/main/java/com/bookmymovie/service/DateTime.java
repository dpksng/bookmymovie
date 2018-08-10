package com.bookmymovie.service;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class DateTime{
	
	public String date(){
		
		Date date = new Date();
		DateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(date);
		
	}
	
	public String shortDate(){
		
		Date date = new Date();
		Format formatter = new SimpleDateFormat("MMM"); 
	    String s1= formatter.format(new Date());
		DateFormat sdf=new SimpleDateFormat("dd");
		String s2=sdf.format(date);
		String dt=s2+" "+s1; 
		return dt;
		
	}

	public String time(){
		
		Date date=new Date();
		DateFormat sdf=new SimpleDateFormat("HH:mm:ss");
		return sdf.format(date);
		
	}
	
}