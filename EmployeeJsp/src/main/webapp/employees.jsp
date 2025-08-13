<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Employee List</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid #333;
            padding: 8px;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<h2>Employee Details</h2>

<c:if test="${empty employeeList}">
    <p style="color:red;">⚠ No data received!</p>
</c:if>

<c:if test="${not empty employeeList}">
    <p style="color:green;">✅ Employee list received</p>
</c:if>

<table>
    <tr>
        <th>Emp No</th>
        <th>Name</th>
        <th>Job</th>
        <th>Manager</th>
        <th>Hire Date</th>
        <th>Salary</th>
        <th>Commission</th>
        <th>Dept No</th>
    </tr>

    <c:forEach var="emp" items="${employeeList}">
        <tr>
            <td>${emp.empNo}</td>
            <td>${emp.eName}</td>
            <td>${emp.job}</td>
            <td>${emp.mgr}</td>
            <td>${emp.hireDate}</td>
            <td>${emp.sal}</td>
            <td>${emp.comm}</td>
            <td>${emp.deptNo}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
