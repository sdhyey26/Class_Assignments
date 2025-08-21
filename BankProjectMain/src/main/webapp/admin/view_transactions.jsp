<%@ page import="java.util.*, com.tss.model.Transaction" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    List<Transaction> transactions = (List<Transaction>) request.getAttribute("transactions");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Customer Transactions</title>
    <style>
        body {
            margin: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f4f4;
            display: flex;
        }

        .sidebar {
            width: 220px;
            background-color: #2c3e50;
            color: white;
            height: 100vh;
            position: fixed;
            padding-top: 30px;
        }

        .sidebar h2 {
            text-align: center;
            font-size: 1.5rem;
            margin-bottom: 20px;
        }

        .sidebar ul {
            list-style: none;
            padding: 0;
            margin: 0;
        }

        .sidebar ul li {
            padding: 15px 20px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .sidebar ul li:hover,
        .sidebar ul li.active {
            background-color: #34495e;
        }

        .container {
            margin-left: 220px;
            padding: 30px;
            flex: 1;
        }

        h2 {
            margin-bottom: 25px;
            color: #2c3e50;
        }

        form {
            margin-bottom: 20px;
        }

        input[type="text"] {
            padding: 10px;
            font-size: 1rem;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-right: 10px;
        }

        button {
            padding: 10px 20px;
            font-size: 1rem;
            background-color: #3498db;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        button:hover {
            background-color: #2980b9;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background: #fff;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
        }

        th, td {
            border: 1px solid #ccc;
            padding: 12px 16px;
            text-align: center;
        }

        th {
            background-color: #3498db;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        .no-txn {
            text-align: center;
            padding: 20px;
            background-color: #fff3cd;
            color: #856404;
            font-weight: bold;
        }
    </style>
</head>
<body>

    <!-- Sidebar -->
    <div class="sidebar">
        <h2>Admin Panel</h2>
        <ul>
            <li onclick="location.href='AdminDashboardServlet'">Dashboard</li>
            <li onclick="location.href='ManageUsersServlet'">Manage Users</li>
            <li onclick="location.href='ManageAccountsServlet'">Manage Accounts</li>
            <li class="active">View Transactions</li>
            <li onclick="location.href='ManageCardRequestsServlet'">Card Requests</li>
            <li onclick="location.href='../logout.jsp'" style="margin-top: 20px;">Logout</li>
        </ul>
    </div>

    <!-- Main Container -->
    <div class="container">
        <h2>Customer Transaction History</h2>

        <form method="get" action="AdminTransactionServlet">
            <input type="text" name="accountNumber" placeholder="Filter by Account Number" />
            <button type="submit">Filter</button>
        </form>

        <table>
            <tr>
                <th>ID</th>
                <th>From</th>
                <th>To</th>
                <th>Type</th>
                <th>Amount</th>
                <th>Date</th>
            </tr>
            <%
                if (transactions != null && !transactions.isEmpty()) {
                    for (Transaction t : transactions) {
            %>
            <tr>
                <td><%= t.getId() %></td>
                <td><%= t.getFromAccount() %></td>
                <td><%= t.getToAccount() %></td>
                <td><%= t.getType() %></td>
                <td>₹<%= String.format("%.2f", t.getAmount()) %></td>
                <td><%= t.getTimestamp() %></td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr><td colspan="6" class="no-txn">No transactions found.</td></tr>
            <% } %>
        </table>
    </div>

</body>
</html>
