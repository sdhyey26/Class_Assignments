package com.tss.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static String jdbcURL = "jdbc:mysql://localhost:3306/TSS_Students";
    public static String dbUser = "root";
    public static String dbPassword = "Dhyey1212";
    static Connection connection = null;
    public static Connection getConnection() {
        try {
        	connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
        	System.out.println("Connection DB successfull !!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
    }
}
