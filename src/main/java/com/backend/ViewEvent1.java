package com.backend;


import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/viewEvent")
public class ViewEvent1 extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Event  Page</title>");
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
    		ResultSet rp=st.executeQuery("select * from event_detail");
                 
            
            out.println("<center><h1>Event Details</h1></center>");
            out.println("<br>");
            out.println("<div>");
                 
            out.println("<center>");

            while (rp.next()) 
            {  
                String n = rp.getString("eventId");  
                String nm = rp.getString("eventName");  
                String co = rp.getString("coordinatorName");
                String cono  = rp.getString("coordinatorNo");
                String f=rp.getString("fee");
                String v=rp.getString("venue");
                String d=rp.getString("date");
                
                out.println("<table  style=\" border: 1px solid white;\" width=75% height=50%>"
                		+ "<tr>"
                		+ "<td><b>Event No. <b></td> "
                		+ "<td>"+n +"</td>"
                		+ "</tr>"
                		+ "<tr>"
                		+ "<td><b> Event Name<b></td> "
                		+ "<td>"+ nm+"</td>"
                		+ "</tr>"
                		+ "<tr>"
                		+ "<td><b>Coordinator Name <b></td> "
                		+ "<td>"+ co+"</td>"
                		+ "</tr>"
                		+ "<tr>"
                		+ "<td><b>Coordiantor No. <b></td> "
                		+ "<td>"+cono +"</td>"
                		+ "</tr>"
                		+ "<tr>"
                		+ "<td><b> Fee<b></td> "
                		+ "<td>"+f +"</td>"
                		+ "</tr>"
                		+ "<tr>"
                		+ "<td><b>Venue <b></td> "
                		+ "<td>"+ v+"</td>"
                		+ "</tr>"
                		+ "<tr>"
                		+ "<td><b>Event Date<b></td> "
                		+ "<td>"+ d+"</td>"
                		+ "</tr>"
                		+ "</table>"
                		+ "<br><br>");  
                
            }  
            con.commit();
            con.close(); 
            out.println("</table>"); 
            out.println("</center>");
            out.print("</body>");
            out.print("</html>"); 
        } catch(Exception exe){System.out.println("Exception caught"+exe);}
    }
}
