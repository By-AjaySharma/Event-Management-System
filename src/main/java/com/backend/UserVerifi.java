package com.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class UserVerifi {
	
	public static boolean validUser(String email,String passWord) {
		
		boolean flag=false;
		
		try {
			
			String url="jdbc:mysql://localhost:3366/user_info";
			String id="root";
			String pass="1234";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,id,pass);
			
			
		    PreparedStatement ps=con.prepareStatement("select * from user_detail where email=? and password=?");  
		    ps.setString(1,email);  
		    ps.setString(2,passWord);  
		    ResultSet rs=ps.executeQuery();  
		    flag=rs.next();
		    con.close();

		}
		catch(Exception e) {
			System.out.println(e);
			System.out.println(flag);
			}
		
		return flag;
	}

	
}
