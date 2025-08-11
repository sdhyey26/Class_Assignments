<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%! 
    String studentName = "Dhyey Shiyal";
    String course = "Computer Engineering";
    int marks = 90;
    String grade; 
%>

<html>
<head>
    <title>Student Portal</title>
</head>
<body>
    <h1><%= "Welcome to Student Portal" %></h1>

    <p><strong>Current Date & Time:</strong> <%= new Date() %></p>

    <%
        if (marks >= 90) {
            grade = "A";
        } else if (marks >= 75) {
            grade = "B";
        } else if (marks >= 50) {
            grade = "C";
        } else {
            grade = "F";
        }
    %>

    <h2>Student Information</h2>
    <p><strong>Name:</strong> <%= studentName %></p>
    <p><strong>Course:</strong> <%= course %></p>
    <p><strong>Marks:</strong> <%= marks %></p>
    <p><strong>Grade:</strong> <%= grade %></p>
</body>
</html>
