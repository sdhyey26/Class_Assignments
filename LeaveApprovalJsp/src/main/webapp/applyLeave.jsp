<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.tss.model.User" import="java.time.LocalDate"%>
<%
User user = (User) session.getAttribute("user");
if (user == null || !"EMPLOYEE".equals(user.getRole())) {
	response.sendRedirect("login.jsp");
	return;
}

String today = LocalDate.now().toString();
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Apply for Leave</title>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap')
	;

body {
	font-family: 'Poppins', sans-serif;
	background: linear-gradient(135deg, #0f0c29, #302b63, #24243e);
	margin: 0;
	padding: 0;
	min-height: 100vh;
	display: flex;
	align-items: center;
	justify-content: center;
	color: #ffffff;
}

.form-container {
	background-color: rgba(0, 0, 0, 0.85);
	padding: 40px 35px;
	border-radius: 15px;
	box-shadow: 0 0 25px rgba(255, 0, 200, 0.3);
	width: 420px;
	box-sizing: border-box;
}

h2 {
	text-align: center;
	margin-bottom: 30px;
	background: linear-gradient(45deg, #ff00cc, #3333ff);
	-webkit-background-clip: text;
	-webkit-text-fill-color: transparent;
	font-size: 26px;
}

label {
	display: block;
	margin-bottom: 6px;
	font-weight: 600;
}

input[type="date"], textarea {
	width: 100%;
	padding: 10px 12px;
	margin-bottom: 20px;
	border: none;
	border-radius: 8px;
	font-size: 14px;
	background-color: #1e1e2f;
	color: #fff;
	box-shadow: inset 0 0 5px rgba(255, 255, 255, 0.1);
}

input[type="date"]:focus, textarea:focus {
	outline: none;
	box-shadow: 0 0 8px #ff00cc;
	background-color: #2a2a3d;
}

textarea {
	resize: vertical;
}

input[type="submit"], a {
	display: inline-block;
	width: 100%;
	padding: 12px;
	margin-top: 10px;
	text-align: center;
	border: none;
	border-radius: 8px;
	font-size: 16px;
	font-weight: bold;
	cursor: pointer;
	text-decoration: none;
	background: linear-gradient(45deg, #ff00cc, #3333ff);
	color: white;
	transition: all 0.3s ease;
	box-sizing: border-box;
}

input[type="submit"]:hover, a:hover {
	box-shadow: 0 0 15px #ff00cc;
}
</style>
</head>
<body>
	<div class="form-container">
		<form method="post" action="ApplyLeaveServlet">
			<h2>Apply for Leave</h2>

			<label>Start Date:</label> <input type="date" name="start_date"
				required min="<%=today%>" /> <label>End Date:</label> <input
				type="date" name="end_date" required /> <label>Reason:</label>
			<textarea name="reason" rows="4" required></textarea>

			<input type="submit" value="Submit Request" /> <a
				href="employeeDashboard.jsp">Back to Dashboard</a>
		</form>
	</div>
</body>
</html>
