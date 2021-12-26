package com.backend;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ValidateAdmin")  
public class validAdmin extends HttpServlet {
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		
		PrintWriter out=res.getWriter();
		
		res.setContentType("text/Html");
		
		String id=req.getParameter("adminId");  //fetch Admin id
		String pswd=req.getParameter("adminPass");//fetch admin password
		
		//set of admin id and password
		String I1="ajay";
		String P1="1234";
		
		String I2="harsh";
		String P2="5678";
		
		String I3="nihal";
		String P3="abcd";
		
		//if else ladder for checking the entery
		
		if(id.equals(I1)&& pswd.equals(P1)) {
			RequestDispatcher rd=req.getRequestDispatcher("AdminEvent.html");
			rd.forward(req, res);
		}
		else if(id.equals(I2)&& pswd.equals(P2)) {
			RequestDispatcher rd=req.getRequestDispatcher("AdminEvent.html");
			rd.forward(req, res);
		}
		else if(id.equals(I3)&& pswd.equals(P3)) {
			RequestDispatcher rd=req.getRequestDispatcher("AdminEvent.html");
			rd.forward(req, res);
		}
		else {
			out.println("<center><h1 style=\"color: red;\"> !! Please Enter Valid Id and Password !! </h1></center>");
			RequestDispatcher rd=req.getRequestDispatcher("AdminLogin.html");
			rd.include(req, res);
		}
		
		
		
		
		
	}

}
