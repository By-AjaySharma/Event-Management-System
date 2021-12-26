<!-- Participants events:- -->
<!DOCTYPE html>

<%

if (session != null) {
    if (session.getAttribute("user") != null) {
       String name = (String) session.getAttribute("user");

       
    } else {
       response.sendRedirect("UserLogin.html");
    }
 }
%>
<html><br>
    <head>
      <link rel="stylesheet" href="total.css">
      <link href="https://fonts.googleapis.com/css2?family=Balsamiq+Sans&display=swap" rel="stylesheet">
        <title>Page For Event Registration </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <h2 id="common" style="text-align:center">!! Welcome All Participants !! </h1>
    </head>
    <body>
       
     <span style="float:right">
    <a href="index.html"><button>Logout</button></a>
      
    </span><br><br><p></p><br>
    <br> <br>
    <center>
    
            <h3 style="color: White"> View Events & Register for event </h3>
            <form method="get" action="viewEvent">
            <h3> 1.View Events </h3>
            <input type="submit" id="sub" value="View Event">
        <br><br>
        </form>
        <br><br>
        <h3> 2.Register For Event</h3>
        <a href="Registration.html"> <button type="button" id="button">Register For Event </button></a>
        <br><br>
    </center>
</body>
</html>
