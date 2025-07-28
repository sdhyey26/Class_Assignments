package com.tss.controller;

import java.util.List;
import java.util.Scanner;

import com.tss.model.Student;
import com.tss.service.StudentService;

public class StudentController {

	public StudentService studentService;
	public Scanner sc = new Scanner(System.in);

	public StudentController() {
		super();
		this.studentService = new StudentService();
	}

	public void readAllRecords() {
		List<Student> students = studentService.readAllStudent();

		for (Student student : students) {
			System.out.println("Student ID: " + student.getStudentid() + " | " + "Name: " + student.getName() + " | "
					+ "Age: " + student.getAge() + " | " + "Percentage: " + student.getPercentage() + " | "
					+ "Roll No: " + student.getRollnumber());
		}
	}

	public void addNewStudent(Scanner sc) {
		System.out.print("Enter student id: ");
		int id = sc.nextInt();

		System.out.print("Enter student roll number: ");
		int rollNumber = sc.nextInt();

		sc.nextLine();

		System.out.print("Enter student name: ");
		String name = sc.nextLine();

		System.out.print("Enter age: ");
		int age = sc.nextInt();

		System.out.print("Enter student percentage: ");
		double percentage = sc.nextDouble();

		Student student = new Student(id, rollNumber, name, age, percentage);

		StudentService studentService = new StudentService();
		studentService.addNewStudent(student);
	}

	public void readStudentById(int id) {
		Student student = studentService.readStudentById(id);
		if (student != null) {
			System.out.println("Student Found:");
			System.out.println("ID: " + student.getStudentid());
			System.out.println("Name: " + student.getName());
			System.out.println("Age: " + student.getAge());
			System.out.println("Percentage: " + student.getPercentage());
			System.out.println("Roll Number: " + student.getRollnumber());
		} else {
			System.out.println("Student with ID " + id + " not found.");
		}
	}

	public void updatePercentageById(int id, double newPercentage) {
		boolean updated = studentService.updatePercentageById(id, newPercentage);
		if (updated) {
			System.out.println("Percentage updated successfully.");
		} else {
			System.out.println("Update failed. Student with ID " + id + " may not exist.");
		}
	}

	public void deleteStudentById(int id) {
		boolean deleted = studentService.deleteStudentById(id);
		if (deleted) {
			System.out.println("Student deleted successfully.");
		} else {
			System.out.println("Deletion failed. Student with ID " + id + " may not exist.");
		}
	}
}