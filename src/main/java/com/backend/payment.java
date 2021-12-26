package com.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class payment extends HttpServlet {
	
	public void doPost(HttpServletRequest req,HttpServletResponse res){
		
		String eNa=req.getParameter("ename");
		String  eNo=req.getParameter("enum");
		String  cardNo=req.getParameter("cardno");
		String  expD=req.getParameter("edate");
		String  cvv=req.getParameter("cvv");
		String  cNa=req.getParameter("cname");
		
		String url="jdbc:mysql://localhost:3366/user_info";
		String id="root";
		String pass="1234";

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,id,pass);
			Statement st=con.createStatement();
			
			st.executeUpdate("insert into register_user value ('"+eNa+"','"+eNo+"','"+cardNo+"','"+expD +"','"+ cvv+"','"+ cNa+"')");
		
            RequestDispatcher rd=req.getRequestDispatcher("Payment.html");
            rd.forward(req, res);
            con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	

}
