package com.tss.model;

public class EmployeeModel implements Comparable<EmployeeModel> {
	private String name;
	
	
	
	public EmployeeModel(String name, int employeeId, int salary) {
		super();
		this.name = name;
		this.employeeId = employeeId;
		this.salary = salary;
	}
	
	
	
	public EmployeeModel() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	private int employeeId;
	private int salary;
	@Override
	public int compareTo(EmployeeModel o) {
		if(this.employeeId > o.employeeId) {
			return 1;
		}
		if(this.employeeId < o.employeeId) {
			return -1;
		}
		return 0;
		
	}
}
