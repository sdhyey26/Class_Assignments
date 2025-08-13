<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.tss.model.User, com.tss.model.LeaveRequest, com.tss.service.LeaveService"%>
<%@ page import="java.util.List, java.time.LocalDate, java.time.temporal.ChronoUnit"%>
<%
	User user = (User) session.getAttribute("user");
	if (user == null || !"ADMIN".equals(user.getRole())) {
		response.sendRedirect("login.jsp");
		return;
	}

	LeaveService service = new LeaveService();
	List<LeaveRequest> requests = service.getAllRequests();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
<style>
	@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap');

	body {
		font-family: 'Poppins', sans-serif;
		background: linear-gradient(135deg, #0f0c29, #302b63, #24243e);
		color: #fff;
		margin: 0;
		padding: 40px;
	}

	h2 {
		font-size: 28px;
		background: linear-gradient(45deg, #ff00cc, #3333ff);
		-webkit-background-clip: text;
		-webkit-text-fill-color: transparent;
		text-align: center;
		margin-bottom: 10px;
	}

	h3 {
		text-align: center;
		color: #ccc;
		margin-bottom: 30px;
	}

	table {
		width: 100%;
		border-collapse: collapse;
		background-color: rgba(0, 0, 0, 0.7);
		box-shadow: 0 0 10px rgba(255, 0, 200, 0.2);
		border-radius: 10px;
		overflow: hidden;
	}

	th, td {
		padding: 14px 16px;
		text-align: center;
		border-bottom: 1px solid rgba(255, 255, 255, 0.1);
		color: #f1f1f1;
	}

	th {
		background: linear-gradient(45deg, #ff00cc, #3333ff);
		color: white;
	}

	tr:nth-child(even) {
		background-color: rgba(255, 255, 255, 0.05);
	}

	form {
		margin: 0;
	}

	button {
		padding: 10px 16px;
		border: none;
		border-radius: 6px;
		cursor: pointer;
		color: #fff;
		font-weight: bold;
		transition: all 0.3s ease;
		font-size: 14px;
		transform: scale(1);
	}

	button[value="approve"] {
		background: linear-gradient(135deg, #00e676, #1de9b6);
		box-shadow: 0 4px 10px rgba(0, 230, 118, 0.3);
	}

	button[value="reject"] {
		background: linear-gradient(135deg, #ff1744, #ff616f);
		box-shadow: 0 4px 10px rgba(255, 23, 68, 0.3);
	}

	button:hover {
		transform: scale(1.05);
		box-shadow: 0 6px 20px rgba(255, 0, 204, 0.4);
	}

	a {
		display: inline-block;
		margin-top: 30px;
		text-align: center;
		color: white;
		text-decoration: none;
		font-weight: bold;
		padding: 10px 20px;
		background: linear-gradient(45deg, #ff00cc, #3333ff);
		border-radius: 8px;
		transition: 0.3s ease;
	}

	a:hover {
		box-shadow: 0 0 10px #ff00cc;
	}
</style>
</head>
<body>
	<h2>Welcome, Admin</h2>
	<h3>Pending Leave Requests</h3>

	<table>
		<tr>
			<th>ID</th>
			<th>User ID</th>
			<th>Start Date</th>
			<th>End Date</th>
			<th>Reason</th>
			<th>Days</th>
			<th>Status</th>
			<th>Actions</th>
		</tr>
		<%
		for (LeaveRequest r : requests) {
			if (!"PENDING".equals(r.getStatus())) continue;

			LocalDate start = LocalDate.parse(r.getStartDate().toString());
			LocalDate end = LocalDate.parse(r.getEndDate().toString());
			long daysBetween = ChronoUnit.DAYS.between(start, end) + 1;
		%>
		<form method="post" action="AdminServlet">
			<tr>
				<td><%= r.getId() %></td>
				<td><%= r.getUserId() %></td>
				<td><%= r.getStartDate() %></td>
				<td><%= r.getEndDate() %></td>
				<td><%= r.getReason() %></td>
				<td><%= daysBetween %></td>
				<td><%= r.getStatus() %></td>
				<td>
					<input type="hidden" name="request_id" value="<%= r.getId() %>" />
					<input type="hidden" name="user_id" value="<%= r.getUserId() %>" />
					<input type="hidden" name="days" value="<%= daysBetween %>" />
					<button type="submit" name="action" value="approve">Approve</button>
					&nbsp;
					<button type="submit" name="action" value="reject">Reject</button>
				</td>
			</tr>
		</form>
		<% } %>
	</table>

	<div style="text-align: center;">
		<a href="login.jsp">Logout</a>
	</div>
</body>
</html>
