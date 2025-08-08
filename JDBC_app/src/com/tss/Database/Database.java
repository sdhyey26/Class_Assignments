package com.tss.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tss.model.Student;

public class Database {

	private Connection connection = null;
	private Statement statement = null;

	public Database() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tss_students", "root",
						"Dhyey1212");
				System.out.println("Connection succesfull !!");

			} catch (Exception e) {
				System.out.println(e);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void readAllStudents() {
		try {
			statement = connection.createStatement();

			ResultSet result = statement.executeQuery("select * from student");
			
			System.out.println("studentid" + " " + "rollnumber" + " " + "name" + " " + "age" + " " + "percentage");
			while (result.next()) {
				
				
				System.out.println(result.getInt("studentid") + "\t" + result.getInt("rollnumber") + "\t"
						+ result.getString("name") + "\t" + result.getInt("age") + "\t"
						+ result.getDouble("percentage"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void insertRecord(Student student) {
		try {
			statement = connection.createStatement();
			
			String sql = "INSERT INTO student VALUES (" 
				    + student.getStudentid() + ", " 
				    + student.getRollnumber() + ", '" 
				    + student.getName() + "', " 
				    + student.getAge() + ", " 
				    + student.getPercentage() + ")";
			
			int updates = statement.executeUpdate(sql);
			
			if(updates > 0) {
				System.out.println("succesfully affected " + updates + " rows");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
