package com.backend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ValidUser")
public class UserLogin extends HttpServlet {
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		
		res.setContentType("text/Html");
		PrintWriter out=res.getWriter();
		

		
		String userN=req.getParameter("userId");
		String pswd=req.getParameter("userPass");
		
		if(UserVerifi.validUser(userN,pswd)){
	         HttpSession session = req.getSession(true); // reuse existing
             // session if exist
             // or create one
			session.setAttribute("user", userN);
			res.sendRedirect("ParticipantEvent.jsp");

			
						
//			RequestDispatcher rd=req.getRequestDispatcher("ParticipantEvent.jsp");
//			rd.forward(req, res);
					
		}else {
			out.println("<center><h3 style=\"color: red;\">!! UserName & PassWord Incorrect !!</h3></center>");
			RequestDispatcher rd=req.getRequestDispatcher("UserLogin.html");
			rd.include(req, res);
		}
		
		
	}

}
