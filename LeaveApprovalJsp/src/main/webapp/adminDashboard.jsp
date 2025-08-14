<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tss.model.User, com.tss.model.LeaveRequest, com.tss.service.LeaveService"%>
<%@ page import="java.util.List, java.time.LocalDate, java.time.temporal.ChronoUnit"%>

<%
    User user = (User) session.getAttribute("user");
    if (user == null || !"ADMIN".equals(user.getRole())) {
        response.sendRedirect("login.jsp");
        return;
    }

    String statusFilter = request.getParameter("statusFilter");
    String dateFilter = request.getParameter("dateFilter");

    LeaveService service = new LeaveService();
    List<LeaveRequest> requests = service.getAllRequests();

    if (statusFilter != null && !statusFilter.isEmpty()) {
        requests.removeIf(r -> !statusFilter.equalsIgnoreCase(r.getStatus()));
    }
    if (dateFilter != null && !dateFilter.isEmpty()) {
        requests.removeIf(r -> !r.getStartDate().toString().equals(dateFilter));
    }
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
            padding: 40px;
        }

        h2, h3 {
            text-align: center;
        }

        form.filter-form {
            text-align: center;
            margin-bottom: 20px;
        }

        select, input[type="date"] {
            padding: 8px 12px;
            border-radius: 5px;
            border: none;
            margin: 0 10px;
            font-family: 'Poppins';
        }

        button.filter-btn {
            padding: 8px 14px;
            border: none;
            background: #00e676;
            color: black;
            font-weight: bold;
            border-radius: 5px;
            cursor: pointer;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background: rgba(255, 255, 255, 0.05);
            border-radius: 10px;
        }

        th, td {
            padding: 14px 16px;
            text-align: center;
            color: white;
            border-bottom: 1px solid rgba(255,255,255,0.1);
        }

        th {
            background: linear-gradient(45deg, #ff00cc, #3333ff);
        }

        tr:nth-child(even) {
            background-color: rgba(255, 255, 255, 0.03);
        }

        button {
            padding: 10px 16px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-weight: bold;
        }

        button[value="approve"] {
            background: linear-gradient(135deg, #00e676, #1de9b6);
            color: black;
        }

        .reject-btn {
            background: linear-gradient(135deg, #ff1744, #ff616f);
        }

        .confirm-reject {
            background: linear-gradient(135deg, #c51162, #f50057);
            margin-top: 6px;
        }

        textarea {
            width: 90%;
            margin-top: 10px;
            border-radius: 6px;
            padding: 6px;
            font-family: 'Poppins';
            resize: vertical;
        }

        .reject-section {
            display: none;
            margin-top: 8px;
        }

        .logout {
            display: block;
            margin: 30px auto;
            padding: 10px 20px;
            text-align: center;
            font-weight: bold;
            color: white;
            background: linear-gradient(45deg, #ff00cc, #3333ff);
            text-decoration: none;
            border-radius: 8px;
        }
    </style>
</head>
<body>
    <h2>Welcome, Admin</h2>
    <h3>Leave Requests</h3>

    <!-- Filter Form -->
    <form method="get" class="filter-form">
        <label>Status:
            <select name="statusFilter">
                <option value="">All</option>
                <option value="PENDING" <%= "PENDING".equals(statusFilter) ? "selected" : "" %>>Pending</option>
                <option value="APPROVED" <%= "APPROVED".equals(statusFilter) ? "selected" : "" %>>Approved</option>
                <option value="REJECTED" <%= "REJECTED".equals(statusFilter) ? "selected" : "" %>>Rejected</option>
            </select>
        </label>

        <label>Date:
            <input type="date" name="dateFilter" value="<%= dateFilter != null ? dateFilter : "" %>">
        </label>

        <button type="submit" class="filter-btn">Apply Filters</button>
    </form>

    <!-- Table -->
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

        <% for (LeaveRequest r : requests) {
            LocalDate start = LocalDate.parse(r.getStartDate().toString());
            LocalDate end = LocalDate.parse(r.getEndDate().toString());
            long days = ChronoUnit.DAYS.between(start, end) + 1;
        %>
        <tr>
            <td><%= r.getId() %></td>
            <td><%= r.getUserId() %></td>
            <td><%= r.getStartDate() %></td>
            <td><%= r.getEndDate() %></td>
            <td><%= r.getReason() %></td>
            <td><%= days %></td>
            <td><%= r.getStatus() %></td>
<td>
                <% if ("PENDING".equals(r.getStatus())) { %>
                <form method="post" action="AdminServlet">
                    <input type="hidden" name="request_id" value="<%= r.getId() %>" />
                    <input type="hidden" name="user_id" value="<%= r.getUserId() %>" />
                    <input type="hidden" name="days" value="<%= days %>" />

                    <button type="submit" name="action" value="approve" formnovalidate>Approve</button>
                    <button type="button" class="reject-btn" onclick="showRejection(this)">Reject</button>

                    <div class="reject-section">
                        <textarea name="rejection_reason" placeholder="Enter rejection reason" required></textarea>
                        <button type="submit" name="action" value="reject" class="confirm-reject">Confirm Reject</button>
                    </div>
                </form>
                <% } else { %>
                    N/A
                <% } %>
            </td>
        </tr>
        <% } %>
    </table>

    <a href="login.jsp" class="logout">Logout</a>

    <script>
        function showRejection(button) {
            const td = button.closest("td");
            const section = td.querySelector(".reject-section");
            button.style.display = "none";
            section.style.display = "block";

            const approveBtn = td.querySelector('button[value="approve"]');
            if (approveBtn) {
                approveBtn.style.display = "none";
            }
        }
    </script>
</body>
</html>
