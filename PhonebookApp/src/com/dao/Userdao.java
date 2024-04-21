package com.dao;
import java.sql.*;
import com.entity.User;
public class Userdao {
private Connection conn;

public Userdao(Connection conn) {
	super();
	this.conn = conn;
}

public boolean userregister(User u) {
boolean f= false;	
try {
	String sql="insert into user(name,email,password) values(?,?,?)";
	PreparedStatement ps= conn.prepareStatement(sql);
	ps.setString(1,u.getName() );
	ps.setString(2,u.getEmail() );
	ps.setString(3,u.getPassword() );
	
	int i=ps.executeUpdate();
	if(i==1) {
		f=true;
	}



}catch(Exception e) {
	e.printStackTrace();
}

return f;
}

public User login(String email, String password) {
	User u= null;
	try {
		String sql="select * from user where email = ? and password= ?";
		PreparedStatement ps= conn.prepareStatement(sql);
		ps.setString(1,email );
		ps.setString(2,password );
		ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			u=new User();
			u.setId(rs.getInt(1));
			u.setName(rs.getString(2));
			u.setEmail(rs.getString(3));
			u.setPassword(rs.getString(4));

	
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}

		return u;
	
	
}

}
