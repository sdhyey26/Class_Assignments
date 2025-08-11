<%@ page import="java.time.LocalDate" %>
<%
    String name = (String) session.getAttribute("user");
%>

<html>
<head>
    <title>Feedback Submitted</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f8ff;
            padding: 30px;
            text-align: center;
        }

        h3 {
            color: #333;
        }

        .btn {
            margin-top: 20px;
            padding: 10px 20px;
            background: linear-gradient(to right, #1e90ff, #00bfff); /* blue gradient */
            color: white;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
            transition: background 0.3s ease;
        }

        .btn:hover {
            background: linear-gradient(to right, #00bfff, #1e90ff);
            box-shadow: 0 0 10px rgba(30, 144, 255, 0.5);
        }
    </style>
</head>
<body>
    <h3>
        Name: <%= name %> |
        Your feedback is <span style="color: green">submitted successfully</span> on <%= LocalDate.now() %>
    </h3>

    <!-- Redirect button -->
    <form action="feedback.jsp" method="get">
        <button type="submit" class="btn">Give Another Feedback</button>
    </form>
</body>
</html>
