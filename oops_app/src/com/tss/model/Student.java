package com.tss.model;

public class Student {
	
	private int rollNumber;
	private String Name;
	private int age;
	private int marksSub1;
	private int markSub2;
	private int markSub3;
	
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getMarksSub1() {
		return marksSub1;
	}
	public void setMarksSub1(int marksSub1) {
		this.marksSub1 = marksSub1;
	}
	public int getMarkSub2() {
		return markSub2;
	}
	public void setMarkSub2(int markSub2) {
		this.markSub2 = markSub2;
	}
	public int getMarkSub3() {
		return markSub3;
	}
	public void setMarkSub3(int markSub3) {
		this.markSub3 = markSub3;
	}
	
	public int average() {
		int average = 0;
		average = (marksSub1 + markSub2 + markSub3)/3;
		return average;
	}
	
	public void display() {
		System.out.println("student rollNumber : " + rollNumber);
		System.out.println("student Name : " + Name);
		System.out.println("student age : " + age);
		System.out.println("student marks of sub1 : " + marksSub1);
		System.out.println("student marks of sub2 : " + markSub2);
		System.out.println("student marks of sub3 : " + markSub3);
	}
}
