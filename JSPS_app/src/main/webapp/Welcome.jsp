<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = java.util.Date %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Hello welcome to the JSP</h1>

<%
int number1 = 10;
int number2 = 20;

Date date = new Date();
%>

<%=number1 + number2%>
<br></br>

<%=date %>
<br></br>

<%! double pi = 3.14; %>
<br></br>

<%=pi%>

<%@ include file="NewJsp.jsp" %>


</body>
</html>