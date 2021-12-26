package com.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddEvent")

public class storeEventInfo extends HttpServlet {
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		
		res.setContentType("Text/Html");
		PrintWriter out=res.getWriter();
		
		String eventNo=req.getParameter("EventNo");
		String eventN=req.getParameter("EventName");
		String cooN=req.getParameter("coordinatorName");
		String cooNo=req.getParameter("coordinatorNo");
		String fee=req.getParameter("fee");
		String venue=req.getParameter("venue");
		String date=req.getParameter("date");
		
		if(eventNo.equals("") || eventN.equals("") || cooN.equals("") || cooNo.equals("") || fee.equals("") || venue.equals("") || date.equals("")) {
			out.println("<center><h3 style=\"color: red;\"> !! Some Containet are Empty !!</h3></center>");
			RequestDispatcher rd=req.getRequestDispatcher("CreateE.html");
			rd.include(req, res);
		}else {
			



			try {
				
				String url="jdbc:mysql://localhost:3366/user_info";
				String id="root";
				String pass="1234";
				
				Connection con=DriverManager.getConnection(url,id,pass);
				


				Statement st=con.createStatement();
				st.executeUpdate("insert into event_detail (eventId,eventName,coordinatorName,coordinatorNo,fee,venue,date) values('"+eventNo+"','"+eventN+"','"+cooN+"','"+cooNo+"','"+fee+"','"+venue+"','"+date+"')");
				    
				out.println("<center><h3 style=\"color: green;\"> !! Event has Successfuly Entry !! </h3></center>");
				RequestDispatcher rd=req.getRequestDispatcher("CreateE.html");
				rd.include(req, res);
			    
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e);
				out.println("<center><h3 style=\"color: red;\"> !! Fail to event Entry !!</h3></center>");
				RequestDispatcher rd=req.getRequestDispatcher("CreateE.html");
				rd.include(req, res);
			}
	
		}
				
	}
	

}
