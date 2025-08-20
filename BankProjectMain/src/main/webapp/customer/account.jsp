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
            background-color: #f4f4f4;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            color: #333;
            margin: 0;
            display: flex;
        }

        .sidebar {
            width: 220px;
            height: 100vh;
            background-color: #2c3e50;
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
        }

        .sidebar ul li:hover,
        .sidebar ul li.active {
            background-color: #34495e;
        }

        .content {
            margin-left: 220px;
            padding: 40px;
            flex: 1;
        }

        h2 {
            margin-bottom: 30px;
            color: #2c3e50;
        }

        .account-heading {
            margin: 30px 0 10px 0;
            color: #3498db;
            font-size: 1.2rem;
        }

        .account-table {
            width: 80%;
            border-collapse: collapse;
            background-color: #fff;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
            margin-bottom: 40px;
        }

        .account-table td {
            padding: 14px 20px;
            border-bottom: 1px solid #ddd;
        }

        .account-table td:first-child {
            font-weight: bold;
            color: #555;
            width: 200px;
        }

        .account-table tr:last-child td {
            border-bottom: none;
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
        <li onclick="location.href='PassbookServlet'">Passbook</li>
        <li onclick="location.href='CardApplicationServlet'">Apply Card</li>
        <li onclick="location.href='CardStatusServlet'">Card Status</li>
        <li onclick="location.href='logout.jsp'" style="margin-top: 20px;">Logout</li>
    </ul>
</div>

<div class="content">
    <h2>Your Account Information</h2>

    <% for (Account acc : accounts) { %>
        <div class="account-heading"><%= acc.getAccountType() %> Account</div>
        <table class="account-table">
            <tr><td>Full Name</td><td><%= user.getFullName() %></td></tr>
            <tr><td>Username</td><td><%= user.getUsername() %></td></tr>
            <tr><td>Email</td><td><%= user.getEmail() %></td></tr>
            <tr><td>Account Number</td><td><%= acc.getAccountNumber() %></td></tr>
            <tr><td>Account Type</td><td><%= acc.getAccountType() %></td></tr>
            <tr><td>Current Balance</td><td><%= String.format("%.2f", acc.getBalance()) %></td></tr>
        </table>
    <% } %>
</div>

</body>
</html>
