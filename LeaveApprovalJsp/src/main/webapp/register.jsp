<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap');

        body {
            font-family: 'Poppins', sans-serif;
            background: linear-gradient(135deg, #0f0c29, #302b63, #24243e);
            margin: 0;
            padding: 0;
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            color: #ffffff;
        }

        .login-box {
            background-color: rgba(0, 0, 0, 0.85);
            padding: 40px 30px;
            border-radius: 15px;
            box-shadow: 0 0 20px rgba(58, 227, 116, 0.3);
            width: 360px;
            text-align: center;
        }

        h2 {
            background: linear-gradient(45deg, #00ffcc, #3366ff);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
            font-size: 26px;
            margin-bottom: 30px;
        }

        form {
            display: flex;
            flex-direction: column;
            align-items: stretch;
        }

        label {
            text-align: left;
            font-weight: 600;
            font-size: 14px;
            margin-bottom: 6px;
            margin-top: 10px;
        }

        input[type="text"],
        input[type="password"],
        select {
            padding: 12px;
            border: none;
            border-radius: 8px;
            font-size: 14px;
            background-color: #1e1e2f;
            color: #fff;
            box-shadow: inset 0 0 5px rgba(255, 255, 255, 0.1);
            transition: 0.3s ease;
        }

        input[type="text"]:focus,
        input[type="password"]:focus,
        select:focus {
            outline: none;
            box-shadow: 0 0 8px #00ffcc;
            background-color: #2a2a3d;
        }

        input[type="submit"] {
            background: linear-gradient(45deg, #00ffcc, #3366ff);
            color: white;
            border: none;
            padding: 12px;
            margin-top: 20px;
            font-size: 15px;
            border-radius: 8px;
            cursor: pointer;
            font-weight: bold;
            transition: 0.3s ease;
        }

        input[type="submit"]:hover {
            box-shadow: 0 0 15px #00ffcc;
        }

        .error {
            color: #ff4d4d;
            margin-top: 15px;
            font-size: 14px;
        }

        .success {
            color: #4dff4d;
            margin-top: 15px;
            font-size: 14px;
        }
    </style>
</head>
<body>
    <div class="login-box">
        <h2>Register</h2>
        <form method="post" action="RegisterServlet">
            <label for="username">Username:</label>
            <input type="text" name="username" id="username" required />

            <label for="password">Password:</label>
            <input type="password" name="password" id="password" required />

            <label for="role">Role:</label>
            <select name="role" id="role" required>
                <option value="">-- Select Role --</option>
                <option value="EMPLOYEE">Employee</option>
                <option value="ADMIN">Admin</option>
            </select>

            <input type="submit" value="Register" />
        </form>

        <%
            String msg = request.getParameter("msg");
            if (msg != null && msg.toLowerCase().contains("success")) {
        %>
            <div class="success"><%= msg %></div>
            <a href="login.jsp" style="margin-top: 15px; display: inline-block; background: linear-gradient(45deg, #00ffcc, #3366ff); padding: 10px 15px; border-radius: 8px; color: white; text-decoration: none; font-weight: bold;">Back to Login</a>
            
        <%
            } else if (msg != null) {
        %>
            <div class="error"><%= msg %></div>
        <%
            }
        %>
    </div>
</body>
</html>
