package com.tss.model;

public class StudentModel {
	public StudentModel(String name, int rollNo, int marks) {
		super();
		this.name = name;
		this.rollNo = rollNo;
		this.marks = marks;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}
	private String name;
	private int rollNo;
	private int marks;
	
	@Override
	public String toString() {
		return "StudentModel [name=" + name + ", rollNo=" + rollNo + ", marks=" + marks + "]";
	}
	
	
}
