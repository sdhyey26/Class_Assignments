package com.tss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.tss.database.DBConnection;
import com.tss.model.Student;

public class StudentDao {

	private Connection connection = null;
	private Statement statement = null;
	
	public StudentDao() {
		this.connection = DBConnection.connect();
	}


	public List<Student> readAllStudents()
	{
		List<Student> students = new ArrayList<Student>();
		try {
			statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from student");
			
			while(result.next())
			{
				Student student = new Student();
				student.setStudentid(result.getInt("studentid"));
				student.setAge(result.getInt("age"));
				student.setPercentage(result.getDouble("percentage"));
				student.setName(result.getString("name"));;
				student.setRollnumber(result.getInt("rollnumber"));
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return students;
	}
	
	
	public void addNewStudent(Student student) {
	    try {
	        PreparedStatement preparedStatement = connection.prepareStatement(
	            "insert into student values(?,?,?,?,?)"
	        );
	        preparedStatement.setInt(1, student.getStudentid());
	        preparedStatement.setInt(2, student.getRollnumber());
	        preparedStatement.setString(3, student.getName());
	        preparedStatement.setInt(4, student.getAge());
	        preparedStatement.setDouble(5, student.getPercentage());
	        

	        int updates = preparedStatement.executeUpdate();
	        if (updates > 0) {
	            System.out.println("Student Record Added Successfully");
	        }
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	}
	
	public Student readStudentById(int id) {
	    Student student = null;
	    try {
	        PreparedStatement preparedStatement = connection.prepareStatement(
	            "SELECT * FROM student WHERE studentId = ?"
	        );
	        preparedStatement.setInt(1, id);
	        ResultSet resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) {
	            int studentId = resultSet.getInt("studentId");
	            String name = resultSet.getString("name");
	            int age = resultSet.getInt("age");
	            double percentage = resultSet.getDouble("percentage");
	            int rollNumber = resultSet.getInt("rollNumber");

	            student = new Student(studentId, rollNumber, name, age, percentage);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return student;
	}

	public boolean updatePercentageById(int id, double newPercentage) {
	    try {
	        PreparedStatement preparedStatement = connection.prepareStatement(
	            "UPDATE student SET percentage = ? WHERE studentid = ?"
	        );
	        preparedStatement.setDouble(1, newPercentage);
	        preparedStatement.setInt(2, id);

	        int rowsAffected = preparedStatement.executeUpdate();
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	public boolean deleteStudentById(int id) {
	    try {
	        PreparedStatement preparedStatement = connection.prepareStatement(
	            "DELETE FROM student WHERE studentId = ?"
	        );
	        preparedStatement.setInt(1, id);

	        int rowsAffected = preparedStatement.executeUpdate();
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}



}