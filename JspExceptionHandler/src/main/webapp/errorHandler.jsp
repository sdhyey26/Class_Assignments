<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
    <h2>Oops! An Error Occurred</h2>

    <p><strong>Error Type:</strong> <%= exception.getClass().getName() %></p>
    <p><strong>Message:</strong> <%= exception.getMessage() %></p>

    <p>Please check your input values and try again.</p>
</body>
</html>
