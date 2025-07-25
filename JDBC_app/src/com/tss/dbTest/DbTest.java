package com.tss.dbTest;

import java.util.Scanner;

import com.tss.Database.Database;
import com.tss.model.Student;

public class DbTest {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	Database connection = new Database();
	
//	connection.readAllStudents();
	System.out.println("Enter student id : ");
	int id = sc.nextInt();
	
	System.out.println("Enter student rollnum : ");
	int rollnumber = sc.nextInt();
	
	System.out.println("Enter student name : ");
	String name = sc.next();
	
	System.out.println("Enter age : ");
	int age = sc.nextInt();
	
	System.out.println("Enter student percentage : ");
	double percentage = sc.nextDouble();
	
	Student student = new Student(id , rollnumber , name , age , percentage);
	
	connection.insertRecord(student);
}
}
