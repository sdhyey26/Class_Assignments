package com.tss.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tss.model.Employee;

public class EmployeeTest {

	public static void main(String[] args) {

		// int id, String name, double salary, String dept
		Employee employees1 = new Employee(1, "dhyey", 500, "comp");
		Employee employees2 = new Employee(2, "deep", 300, "comp");
		Employee employees3 = new Employee(3, "harshad", 400, "IT");
		Employee employees4 = new Employee(4, "rishit", 300, "IT");
		Employee employees5 = new Employee(4, "Mahek", 700, "AI");
		Employee employees6 = new Employee(4, "hemanshi", 500, "AI");

		List<Employee> employees = new ArrayList<>();

		employees.add(employees1);
		employees.add(employees2);
		employees.add(employees3);
		employees.add(employees4);
		employees.add(employees5);
		employees.add(employees6);

		// TODO Auto-generated method stub
		List<Employee> sorted = employees.stream()
				.sorted(Comparator.comparingDouble(Employee::getSalary).reversed().thenComparing(Employee::getName))
				.collect(Collectors.toList());

		sorted.forEach(e -> System.out.println("ID: " + e.getId() + ", Name: " + e.getName() + ", Salary: "
				+ e.getSalary() + ", Dept: " + e.getDept()));

		Map<String, Employee> highestPaidByDept = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDept, Collectors.collectingAndThen(
						Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)), Optional::get)));

		highestPaidByDept.forEach((dept, emp) -> System.out
				.println("Dept: " + dept + " -> " + emp.getName() + " (" + emp.getSalary() + ")"));
	}

}
