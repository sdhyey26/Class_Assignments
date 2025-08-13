<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap')
	;

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
	background: linear-gradient(45deg, #ff00cc, #3333ff);
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

input[type="text"], input[type="password"] {
	padding: 12px;
	border: none;
	border-radius: 8px;
	font-size: 14px;
	background-color: #1e1e2f;
	color: #fff;
	box-shadow: inset 0 0 5px rgba(255, 255, 255, 0.1);
	transition: 0.3s ease;
}

input[type="text"]:focus, input[type="password"]:focus {
	outline: none;
	box-shadow: 0 0 8px #ff00cc;
	background-color: #2a2a3d;
}

input[type="submit"] {
	background: linear-gradient(45deg, #ff00cc, #3333ff);
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
	box-shadow: 0 0 15px #ff00cc;
}

.error {
	color: #ff4d4d;
	margin-top: 15px;
	font-size: 14px;
}
</style>
</head>
<body>
	<div class="login-box">
		<h2>Login</h2>
		<form method="post" action="LoginServlet">
			<label for="username">Username:</label> <input type="text"
				name="username" id="username" required /> <label for="password">Password:</label>
			<input type="password" name="password" id="password" required /> <input
				type="submit" value="Login" /> <a href="register.jsp"
				style="margin-top: 15px; color: #00ffcc; font-weight: bold; text-decoration: none; display: inline-block;">
				Don't have an account? Register </a>
		</form>

		<div class="error">
			<%=request.getParameter("error") != null ? request.getParameter("error") : ""%>
		</div>
	</div>
</body>
</html>
