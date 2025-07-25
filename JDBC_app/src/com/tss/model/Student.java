package com.tss.model;

public class Student {
	public Student(int studentid, int rollnumber, String name, int age, double percentage) {
		super();
		this.studentid = studentid;
		this.rollnumber = rollnumber;
		this.name = name;
		this.age = age;
		this.percentage = percentage;
	}

	private int studentid;

	public int getStudentid() {
		return studentid;
	}

	public int getRollnumber() {
		return rollnumber;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public double getPercentage() {
		return percentage;
	}

	private int rollnumber;
	private String name;
	private int age;
	private double percentage;

}
