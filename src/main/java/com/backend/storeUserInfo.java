package com.backend;


import java.io.IOException;
import java.io.PrintWriter;

import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/sendInfo")

public class storeUserInfo extends HttpServlet {
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		
		res.setContentType("text/Html");
		PrintWriter out=res.getWriter();
		
		
		String Name=req.getParameter("uName");//fetch name
		String uName=req.getParameter("userName");//fetch user name
		String uEmail=req.getParameter("userEmail");//fetch email
		String Pass=req.getParameter("pswd");//fetch password
		String Cpass=req.getParameter("Cpswd");//fetch Confirm password
		
		//fetching all data in database
		if(Pass.equals(Cpass)) //checking if password and Confirm password match
		{
			try {
				
				String url="jdbc:mysql://localhost:3366/user_info";
				String id="root";
				String pass="1234";

				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection(url,id,pass);
				Statement st=con.createStatement();
				st.executeUpdate("insert into user_detail value ('"+Name+"','"+uName+"','"+uEmail+"','"+ Pass+"')");
//				System.out.println("Record insert successfully");


				out.println("<center><h3 style=\"color: green;\"> -- Account Successfully Created Please Login--</h3></center>");
                RequestDispatcher rd=req.getRequestDispatcher("UserLogin.html");
                rd.forward(req, res);
                con.close();
                
				
				

		
				
			}catch(Exception e) {
				System.out.println(e);
				out.println("<center><h3 style=\"color: red;\"> !! Account  Creation Fail !!</h3></center>");
				RequestDispatcher rd=req.getRequestDispatcher("UserSignup.html");
				rd.include(req, res);
			}
			
			
		}else {
			out.println("<center><h3 style=\"color: red;\"> !! Account  Creation Fail !!</h3></center>");
			RequestDispatcher rd=req.getRequestDispatcher("UserSignup.html");
			rd.include(req, res);
			
		}
				
		

		out.close();
		
	}
	

}
