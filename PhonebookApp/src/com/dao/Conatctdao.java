package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import com.entity.*;

import com.entity.User;

public class Conatctdao {
	private Connection conn;

	
	public Conatctdao(Connection conn) {
		super();
		this.conn = conn;
	}


	public boolean addcontact(Contact c) {
	boolean f= false;	
	try {
		String sql="insert into contact(name,email,about,userid,phoneno) values(?,?,?,?,?)";
		PreparedStatement ps= conn.prepareStatement(sql);
		ps.setString(1,c.getName() );
		ps.setString(2,c.getEmail() );
		ps.setString(3,c.getAbout() );
		ps.setInt(4,c.getUserid() );
		ps.setString(5,c.getPhoneno() );

		
		int i=ps.executeUpdate();
		if(i==1) {
			f=true;
		}

	}catch(Exception e) {
		e.printStackTrace();
	}

	return f;
	}
	
	public List<Contact> getallcontact(int uid){
		List<Contact> list=new ArrayList<Contact>();
		Contact c=null;
		try {
			String sql="select *from contact where userid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				c=new Contact();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setAbout(rs.getString(4));
			    c.setPhoneno(rs.getString(6));
				list.add(c);
			}
			
			}catch(Exception e) {
				e.printStackTrace();
		}
		return list;
	}
	public Contact editc(int cid) {
		Contact c= null;
		try {
			String sql="select * from contact where id= ?";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,cid );
			
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				c=new Contact();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setAbout(rs.getString(4));
				c.setUserid(rs.getInt(5));
				c.setPhoneno(rs.getString(6));

		
			}
			
			}catch(Exception e) {
				e.printStackTrace();
			}

			return c;	
			
	}
	
	public boolean updatecontact(Contact c) {
		boolean f= false;	
		try {
			String sql="update contact set name=?, email=?, phoneno=?, about=? where id=?";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1,c.getName() );
			ps.setString(2,c.getEmail() );
			ps.setString(3,c.getPhoneno() );
			ps.setString(4,c.getAbout() );
			ps.setInt(5,c.getId() );


			
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}

		}catch(Exception e) {
			e.printStackTrace();
		}

		return f;
		}
	public boolean deletecontact(int cid) {
		boolean f= false;	
		try {
			String sql="delete from contact where id=?";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,cid );
			

			
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}

		}catch(Exception e) {
			e.printStackTrace();
		}

		return f;
		}
}

