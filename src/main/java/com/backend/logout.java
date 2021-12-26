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



@WebServlet("/logout")
public class logout extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

	      HttpSession session = request.getSession(false);
	      // session.setAttribute("user", null);
	      session.removeAttribute("user");
        
        out.println("<center><h3 style=\"color: green;\"> -- Successfully Logout--</h3></center>");
        RequestDispatcher rd=request.getRequestDispatcher("index.html");
        rd.include(request, response);

	}


}
