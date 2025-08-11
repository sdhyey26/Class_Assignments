<%@ page errorPage="errorHandler.jsp" %>
<html>
<head>
    <title>Division Example</title>
</head>
<body>
    <h2>Division Operation</h2>

    <%
        int num1 = 10;
        int num2 = 0; 
        int result = num1 / num2;  
    %>

    <p>Result: <%= result %></p>
</body>
</html>
