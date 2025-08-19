<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register - Bank Management</title>
    <link rel="stylesheet" href="css/styles.css">
    <style>
        .register-container {
            width: 100%;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: var(--primary-bg);
        }

        .register-box {
            background-color: #3e3f52;
            padding: 2.5rem;
            border-radius: var(--card-radius);
            width: 450px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
        }

        .register-box h2 {
            text-align: center;
            margin-bottom: 2rem;
            color: var(--primary-text);
        }

        .register-box label {
            color: var(--secondary-text);
            font-weight: 600;
        }
    </style>
</head>
<body>
    <div class="register-container">
        <form class="register-box" action="RegisterServlet" method="post">
            <h2>Create Account</h2>

            <label>Username</label>
            <input type="text" name="username" required>

            <label>Password</label>
            <input type="password" name="password" required>

            <label>Full Name</label>
            <input type="text" name="name" required>

            <label>Mobile</label>
            <input type="text" name="mobile" required>

            <label>Email</label>
            <input type="email" name="email" required>

            <label>Aadhar Number</label>
            <input type="text" name="aadhar" required>

            <label>Account Type</label>
            <select name="accountType" required>
                <option value="Savings">Savings</option>
                <option value="Current">Current</option>
            </select>

            <label>Initial Deposit</label>
            <input type="number" name="initialDeposit" min="0" required>

            <button class="button" type="submit">Register</button>
        </form>
    </div>
</body>
</html>
