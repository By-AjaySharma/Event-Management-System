package com.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class viewTransaction extends HttpServlet{
	    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Transaction Detail</title>");
	        out.println("<link rel=\"stylesheet\" href=\"total.css\">");
	        out.println("<link href=\"https://fonts.googleapis.com/css2?family=Balsamiq+Sans&display=swap\" rel=\"stylesheet\">");
	        out.println("</head>");
	        out.println("<body>");
	        try{
	  
				
				String url="jdbc:mysql://localhost:3366/user_info";
				String id="root";
				String pass="1234";
				
				Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection(url,id, pass);
	
	            response.setContentType("text/html");
	    		Statement st=con.createStatement();
	    		ResultSet rp=st.executeQuery("select * from user_info.register_user");
	                 
	            
	            out.println("<center><h1>Transaction Detail</h1></center>");
	            out.println("<br>");
	            out.println("<div>");
	                 
	            out.println("<center>");

	            while (rp.next()) 
	            {  
	                String eNo = rp.getString("eventId");  
	                String eName = rp.getString("eventName");  
	                String cExp = rp.getString("cardExp");
	                String cNo  = rp.getString("cardNo");

	                
	                out.println("<table  style=\" border: 1px solid white;\" width=75% height=30%>"
	                		+ "<tr>"
	                		+ "<td><b>Event Name <b></td> "
	                		+ "<td>"+eName+"</td>"
	                		+ "</tr>"
	                		+ "<tr>"
	                		+ "<td><b> Event No.<b></td> "
	                		+ "<td>"+ eNo+"</td>"
	                		+ "</tr>"
	                		+ "<tr>"
	                		+ "<td><b>Card No. <b></td> "
	                		+ "<td>"+ cNo+"</td>"
	                		+ "</tr>"
	                		+ "<tr>"
	                		+ "<td><b>Card Exp  <b></td> "
	                		+ "<td>"+cExp +"</td>"
	                		+ "</tr>"
	                		+ "</table>"
	                		+ "<br><br>");  
	                
	            }  
//	            con.commit();
	            con.close(); 
	            out.println("</table>"); 
	            out.println("</center>");
	            out.print("</body>");
	            out.print("</html>"); 
	        } catch(Exception exe){System.out.println("Exception caught "+exe);}
	    }
}