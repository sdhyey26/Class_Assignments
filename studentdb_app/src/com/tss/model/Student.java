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

	public Student() {
		super();
		// TODO Auto-generated constructor stub
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

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public void setRollnumber(int rollnumber) {
		this.rollnumber = rollnumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	private int rollnumber;
	private String name;
	private int age;
	private double percentage;

}

