package com.tss.DAO;

import com.tss.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/organization";
    private static final String USER = "root";
    private static final String PASSWORD = "Dhyey1212";

    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
            return list; // return empty list if driver is not found
        }

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {

            if (conn != null) {
                System.out.println("✅ Database connection successful!");
            } else {
                System.out.println("❌ Failed to establish database connection!");
                return list; // exit early if connection is not valid
            }

            String query = "SELECT * FROM emp";
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {

                while (rs.next()) {
                    Employee emp = new Employee();
                    emp.setEmpNo(rs.getInt("EMPNO"));
                    emp.setEName(rs.getString("ENAME"));
                    emp.setJob(rs.getString("JOB"));
                    emp.setMgr(rs.getInt("MGR"));
                    emp.setHireDate(rs.getDate("HIREDATE"));
                    emp.setSal(rs.getBigDecimal("SAL"));
                    emp.setComm(rs.getBigDecimal("COMM"));
                    emp.setDeptNo(rs.getInt("DEPTNO"));
                    list.add(emp);
                }
            }

        } catch (SQLException e) {
            System.out.println("❌ SQL Error while connecting or fetching data:");
            e.printStackTrace();
        }

        return list;
    }
}
