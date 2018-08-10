package com.bookmymovie.service;

import java.sql.*;

import org.springframework.stereotype.Service;

import com.mysql.jdbc.Connection;


@Service
public class JConnect{

	public static final String URL="jdbc:mysql://localhost:3306/bookmymovie";
	public static final String USR="root";
	public static final String PWD="password";

	
	public static Connection getConnection(){
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=(Connection)DriverManager.getConnection(URL,USR,PWD);
		return con;
		}catch(Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}
	
	public static Statement getStatement() {
		try {
		return (Statement) getConnection().createStatement();
		}catch(SQLException exception){
			exception.printStackTrace();
			return null;
		}
		}
	
	public static PreparedStatement getPreparedStatement(String sql) {
		try {
			return (PreparedStatement) getConnection().prepareStatement(sql);
		}catch(SQLException exception) {
			exception.printStackTrace();
			return null;
		}
	}
	
}
