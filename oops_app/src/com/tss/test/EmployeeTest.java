package com.tss.test;

import java.util.Scanner;

import com.tss.model.Employee;

public class EmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Employee employee1 = new Employee();
		Employee employee2 = new Employee();
		
		readValue(employee1 , sc);
		System.out.println();
		readValue(employee2 , sc);

		System.out.println();
		employee1.display();
		System.out.println();
		employee2.display();
		
	}
	
	public static void readValue(Employee a , Scanner b) {
		System.out.print("Enter Employee name : ");
		a.setName(b.nextLine());

		System.out.print("Enter Employee id : ");
		a.setEmpid(b.nextInt());
		b.nextLine();  

		System.out.print("Enter joining date : ");
		a.setJoiningDate(b.nextLine());  

		System.out.print("Enter salary of the employee : ");
		a.setSalary(b.nextInt());
		b.nextLine();  
	}

}
