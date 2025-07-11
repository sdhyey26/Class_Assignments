package com.tss.creational.singleton.model;

public class DbConnection {
	
	private static DbConnection connection = null;
	
	private DbConnection() {
		
	}
	
	public static DbConnection DbConnection() {
		if(connection == null) {
			return connection = new DbConnection();
		}
		
		return connection;
		
	}
}
