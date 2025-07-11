package com.tss.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee {
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJoiningDate() {
		return joiningDate;
	}
	
	public void setJoiningDate(String joiningDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		try {
            LocalDate date = LocalDate.parse(joiningDate, formatter);

            String formattedDate = date.format(formatter);
            
            this.joiningDate = formattedDate  ;
            
        } catch (Exception e) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy.");
        }
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	private int empid;
	private String name ; 
	private String joiningDate; 
	private int salary;
	
	public void display() {
	    System.out.println("--------------------------------------------------");
	    System.out.println("| Field               | Value                    |");
	    System.out.println("--------------------------------------------------");
	    System.out.println("| Employee name       | " + getName());
	    System.out.println("| Employee id         | " + getEmpid());
	    System.out.println("| joining date		  | " + getJoiningDate());
	    System.out.println("| Employee salary     | " + getSalary());
	    System.out.println("| Employee Bonus      | " + bonus());
	    System.out.println("--------------------------------------------------");
	}
	
	public int bonus() {
		int bonus = salary / 2 ;
		return bonus;
	};
}
