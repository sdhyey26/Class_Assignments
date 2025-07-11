package com.tss.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.tss.model.EmployeeModel;
import com.tss.model.EmployeeNameComparator;

public class EmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<EmployeeModel> employees = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		
		readEmployee( employees ,  sc);
		
	}
	
	public static void readEmployee(List<EmployeeModel> employees , Scanner sc) {
		System.out.println("Enter the number of employees you want to add : ");
		int employeeCount = sc.nextInt();
		
		
		for(int i = 0 ; i < employeeCount ; i++) {
			EmployeeModel employee = new EmployeeModel() ;
			
			 employee = new EmployeeModel();
			 
			 System.out.println("Enter employee name : ");
			 employee.setName(sc.next());
			 
			 System.out.println("Enter employee ID : ");
			 employee.setEmployeeId(sc.nextInt());
			 
			 System.out.println("Enter employee salary : ");
			 employee.setSalary(sc.nextInt());
			 
			 employees.add(employee);
			 
		}
		printList(employees);
		
		Collections.sort(employees);
		
		printList(employees);
		
		Collections.sort(employees ,new EmployeeNameComparator());
		
		printList(employees);

		
	}
	
	public static void printList(List<EmployeeModel> employees) {
		for(EmployeeModel employee : employees) {
			System.out.println(employee);
		}
	}

}
