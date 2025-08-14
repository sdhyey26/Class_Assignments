<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tss.model.User, com.tss.model.LeaveRequest, com.tss.service.LeaveService" %>
<%@ page import="java.util.List" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null || !"EMPLOYEE".equals(user.getRole())) {
        response.sendRedirect("login.jsp");
        return;
    }

    String statusFilter = request.getParameter("status");
    String startDate = request.getParameter("startDate");
    String endDate = request.getParameter("endDate");

    LeaveService service = new LeaveService();
    List<LeaveRequest> requests;

    if (statusFilter != null || startDate != null || endDate != null) {
        requests = service.getFilteredRequests(statusFilter, startDate, endDate);
    } else {
        requests = service.getAllRequests();
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Dashboard</title>
<style>
    @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap');
    body {
        font-family: 'Poppins', sans-serif;
        background: linear-gradient(135deg, #0f0c29, #302b63, #24243e);
        color: #fff;
        margin: 0;
        padding: 40px;
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    .dashboard {
        background-color: rgba(0, 0, 0, 0.85);
        padding: 40px;
        border-radius: 15px;
        box-shadow: 0 0 25px rgba(255, 0, 200, 0.3);
        text-align: center;
        width: 400px;
        margin-bottom: 30px;
    }
    h2 {
        font-size: 26px;
        background: linear-gradient(45deg, #ff00cc, #3333ff);
        -webkit-background-clip: text;
        -webkit-text-fill-color: transparent;
        margin-bottom: 15px;
    }
    a, input[type="submit"] {
        display: block;
        padding: 12px;
        margin: 10px 0;
        text-align: center;
        border: none;
        border-radius: 8px;
        font-size: 16px;
        font-weight: bold;
        cursor: pointer;
        text-decoration: none;
        background: linear-gradient(45deg, #ff00cc, #3333ff);
        color: white;
        transition: 0.3s ease;
    }
    a:hover, input[type="submit"]:hover {
        box-shadow: 0 0 15px #ff00cc;
    }
    table {
        width: 90%;
        border-collapse: collapse;
        background-color: rgba(0, 0, 0, 0.7);
        border-radius: 12px;
        box-shadow: 0 0 20px rgba(255, 0, 200, 0.2);
        overflow: hidden;
        margin-top: 20px;
    }
    th, td {
        padding: 14px 16px;
        text-align: center;
        color: #f1f1f1;
        border-bottom: 1px solid rgba(255, 255, 255, 0.1);
    }
    th {
        background: linear-gradient(45deg, #ff00cc, #3333ff);
        color: white;
    }
    tr:nth-child(even) {
        background-color: rgba(255, 255, 255, 0.05);
    }
    tr:hover {
        background-color: rgba(255, 255, 255, 0.08);
    }
    .filter-form {
        margin-top: 30px;
        display: flex;
        gap: 15px;
        flex-wrap: wrap;
        justify-content: center;
    }
    .filter-form label {
        font-weight: bold;
    }
    .filter-form input, .filter-form select {
        padding: 6px 10px;
        border-radius: 6px;
        border: none;
        outline: none;
        font-size: 14px;
    }
</style>
</head>
<body>
    <div class="dashboard">
        <h2>Welcome, <%= user.getUsername() %></h2>
        <p>Leave Balance: <%= user.getLeaveBalance() %> days</p>
        <a href="applyLeave.jsp">Apply for Leave</a>
        <a href="login.jsp">Logout</a>
    </div>

    <h2>My Leave Requests</h2>

    <form class="filter-form" method="get">
        <label>Status:
            <select name="status">
                <option value="">All</option>
                <option value="PENDING" <%= "PENDING".equals(statusFilter) ? "selected" : "" %>>PENDING</option>
                <option value="APPROVED" <%= "APPROVED".equals(statusFilter) ? "selected" : "" %>>APPROVED</option>
                <option value="REJECTED" <%= "REJECTED".equals(statusFilter) ? "selected" : "" %>>REJECTED</option>
            </select>
        </label>
        <label>From:
            <input type="date" name="startDate" value="<%= startDate != null ? startDate : "" %>">
        </label>
        <label>To:
            <input type="date" name="endDate" value="<%= endDate != null ? endDate : "" %>">
        </label>
        <input type="submit" value="Filter">
    </form>

    <table>
        <tr>
            <th>ID</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Reason</th>
            <th>Status</th>
            <th>Rejection Reason</th>
        </tr>
        <%
            for (LeaveRequest r : requests) {
                if (r.getUserId() != user.getId()) continue;
        %>
        <tr>
            <td><%= r.getId() %></td>
            <td><%= r.getStartDate() %></td>
            <td><%= r.getEndDate() %></td>
            <td><%= r.getReason() %></td>
            <td><%= r.getStatus() %></td>
            <td><%= "REJECTED".equals(r.getStatus()) ? r.getRejectionReason() : "-" %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
