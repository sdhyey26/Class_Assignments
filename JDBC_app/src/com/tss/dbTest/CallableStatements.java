package com.tss.dbTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;

public class CallableStatements {
	 public static void main(String[] args) {
	        

	        Connection connection = null;
	        CallableStatement callableStmt = null;

	        try {
	        	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tss_students", "root",
						"Dhyey1212");
				System.out.println("Connection succesfull !!");

	            String sql = "{CALL insert_student(?, ?, ?, ?, ?)}";
	            callableStmt = connection.prepareCall(sql);

	            callableStmt.setInt(1, 52);                 
	            callableStmt.setInt(2, 101);                
	            callableStmt.setString(3, "Hey");      
	            callableStmt.setInt(4, 20);                 
	            callableStmt.setBigDecimal(5, new java.math.BigDecimal("85.75")); 

	            callableStmt.execute();

	            System.out.println("Student inserted successfully.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (callableStmt != null) callableStmt.close();
	                if (connection != null) connection.close();
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	        }
	    }
}
