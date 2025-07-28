package com.tss.database;

import java.sql.DriverManager;

import java.sql.Connection;

public class DBConnection {
	public static Connection connection = null;

	private DBConnection() {
		
	}
	
	public static Connection connect() {
		try {
			if(connection == null) {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tss_students", "root",
						"Dhyey1212");
			}
			System.out.println("Connection successfull");
		}
		catch(Exception e ) {
			e.printStackTrace();
		}
		return connection;
	}
	
}
