<%@ page import="java.util.*, com.tss.model.Transaction" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    List<Transaction> transactions = (List<Transaction>) request.getAttribute("transactions");
    String filterType = request.getParameter("type");
    String fromDate = request.getParameter("from");
    String toDate = request.getParameter("to");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Passbook</title>
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
            margin-bottom: 20px;
            color: #2c3e50;
        }

        form.filter-form {
            margin-bottom: 20px;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 6px rgba(0,0,0,0.1);
        }

        .filter-form input, .filter-form select {
            padding: 8px 12px;
            margin-right: 10px;
            border-radius: 4px;
            border: 1px solid #ccc;
            font-size: 0.95rem;
        }

        .filter-form button {
            padding: 8px 16px;
            background-color: #3498db;
            border: none;
            border-radius: 4px;
            color: white;
            cursor: pointer;
            font-weight: bold;
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

    <div class="sidebar">
        <h2>Bank Panel</h2>
        <ul>
            <li onclick="location.href='${pageContext.request.contextPath}/CustomerDashboardServlet'">Dashboard</li>
            <li onclick="location.href='${pageContext.request.contextPath}/AccountInfoServlet'">Account Info</li>
            <li onclick="location.href='${pageContext.request.contextPath}/TransferServlet'">Transfer Funds</li>
            <li class="active">Passbook</li>
            <li onclick="location.href='${pageContext.request.contextPath}/CardApplicationServlet'">Apply Card</li>
            <li onclick="location.href='${pageContext.request.contextPath}/CardStatusServlet'">Card Status</li>
            <li onclick="location.href='${pageContext.request.contextPath}/logout.jsp'" style="margin-top: 20px;">Logout</li>
        </ul>
    </div>

    <div class="container">
        <h2>Transaction History</h2>

        <form class="filter-form" method="get" action="PassbookServlet">
            <label>From: <input type="date" name="from" value="<%= fromDate != null ? fromDate : "" %>"></label>
            <label>To: <input type="date" name="to" value="<%= toDate != null ? toDate : "" %>"></label>
            <label>Type: 
                <select name="type">
                    <option value="">All</option>
                    <option value="credit" <%= "credit".equals(filterType) ? "selected" : "" %>>Credit</option>
                    <option value="debit" <%= "debit".equals(filterType) ? "selected" : "" %>>Debit</option>
                </select>
            </label>
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
            <tr>
                <td colspan="6" class="no-txn">No transactions found.</td>
            </tr>
            <% } %>
        </table>
    </div>

</body>
</html>
