package com.tss.creational.singleton.test;

import com.tss.creational.singleton.model.DbConnection;

public class DbconnectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DbConnection connection1 = DbConnection.DbConnection();
		DbConnection connection2 = DbConnection.DbConnection();
		DbConnection connection3 = DbConnection.DbConnection();
		
		System.out.println(connection1.hashCode());
		System.out.println(connection2.hashCode());
		System.out.println(connection3.hashCode());
		
	}

}
