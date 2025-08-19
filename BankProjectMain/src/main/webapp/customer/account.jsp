<%@ page import="com.tss.model.User, com.tss.model.Account, java.util.List" %>
<%
    User user = (User) request.getAttribute("user");
    List<Account> accounts = (List<Account>) request.getAttribute("accounts");

    if (user == null || accounts == null) {
        response.sendRedirect("../login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Account Info</title>
    <style>
        body {
            background-color: #2d2f3a;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            color: #fff;
            margin: 0;
            display: flex;
        }

        .sidebar {
            width: 220px;
            height: 100vh;
            background-color: #1f2937;
            color: white;
            padding-top: 30px;
            position: fixed;
        }

        .sidebar h2 {
            text-align: center;
            font-size: 1.5rem;
            margin-bottom: 25px;
        }

        .sidebar ul {
            list-style: none;
            padding: 0;
            margin: 0;
        }

        .sidebar ul li {
            padding: 15px 20px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            border-left: 4px solid transparent;
        }

        .sidebar ul li:hover {
            background-color: #374151;
        }

        .sidebar ul li.active {
            background-color: #0ea5e9;
            font-weight: bold;
            border-left: 4px solid #0284c7;
        }

        .content {
            margin-left: 220px;
            padding: 40px;
            flex: 1;
        }

        h2 {
            margin-bottom: 25px;
        }

        .account-table {
            width: 70%;
            border-collapse: collapse;
            background-color: #3a3d4d;
            border-radius: 8px;
            overflow: hidden;
            margin-bottom: 40px;
        }

        .account-table td {
            padding: 12px 16px;
            border-bottom: 1px solid #555;
        }

        .account-table td:first-child {
            font-weight: bold;
            color: #ccc;
            width: 200px;
        }

        .account-table tr:last-child td {
            border-bottom: none;
        }

        .account-heading {
            margin-bottom: 10px;
            color: #38bdf8;
        }
    </style>
</head>
<body>

<div class="sidebar">
    <h2>Bank Panel</h2>
    <ul>
        <li onclick="location.href='CustomerDashboardServlet'">Dashboard</li>
        <li class="active">Account Info</li>
        <li onclick="location.href='TransferServlet'">Transfer Funds</li>
        <li onclick="location.href='passbook.jsp'">Passbook</li>
        <li onclick="location.href='apply_card.jsp'">Apply Card</li>
        <li onclick="location.href='card_status.jsp'">Card Status</li>
        <li onclick="location.href='../logout.jsp'" style="margin-top: 20px;">Logout</li>
    </ul>
</div>

<div class="content">
    <h2>Your Account Information</h2>

    <% for (Account acc : accounts) { %>
        <h3 class="account-heading"><%= acc.getAccountType() %> Account</h3>
        <table class="account-table">
            <tr><td>Full Name</td><td><%= user.getFullName() %></td></tr>
            <tr><td>Username</td><td><%= user.getUsername() %></td></tr>
            <tr><td>Email</td><td><%= user.getEmail() %></td></tr>
            <tr><td>Account Number</td><td><%= acc.getAccountNumber() %></td></tr>
            <tr><td>Account Type</td><td><%= acc.getAccountType() %></td></tr>
            <tr><td>Current Balance</td><td><%= acc.getBalance() %></td></tr>
        </table>
    <% } %>
</div>

</body>
</html>
