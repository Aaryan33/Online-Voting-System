<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Party and Candidate Details</title>
</head>
<body>
    <!-- Display party and candidate details here -->
    <h2>Welcome, <%= session.getAttribute("username") %></h2>
    <!-- Add code to display party and candidate information -->
    <!-- Example: -->
    <form action="VoteServlet" method="post">
    
    <p><b>Party:Samajvadi Party</b></p>
    <p><b>Candidate:</b> Modi</p>
    <p><b>Goal:</b>Reducing total projected carbon emissions by one billion tonnes starting now till 2030</p>
    <input type="submit" value="Vote">
    
    <p><b>Party:Janta Party</b></p>
    <p><b>Candidate:</b> Rahul</p>
    <p><b>Goal:</b>Reducing carbon intensity by 45% by 2030</p>
    <input type="submit" value="Vote">
    
    <p><b>Party:Vicharvadi Party</b></p>
    <p><b>Candidate:</b>Amit shah</p>
    <p><b>Goal:</b>bIncreasing renewable energy component to 50% of our total energy requirements by 2030</p>
    <input type="submit" value="Vote">
    
    </form>
    <p><a href="logout.jsp">Logout</a></p>
</body>
</html>