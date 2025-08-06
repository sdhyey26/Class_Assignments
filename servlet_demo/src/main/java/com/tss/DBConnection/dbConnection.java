package com.tss.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnection  {
	private static Connection connection = null;
	
	public static Connection connect() {
		try {
			if(connection == null) {
                Class.forName("com.mysql.cj.jdbc.Driver"); 
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "root",
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
