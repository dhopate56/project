package com.conn;

import java.sql.*;


public class Dbconnect{
 private static Connection conn;
 
 public static Connection getconn() {
	 try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebook", "root", "Shubham@123");
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	return conn; 
 }
 
	
}
