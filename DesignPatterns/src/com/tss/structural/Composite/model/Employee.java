package com.tss.structural.Composite.model;


import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private String position;
    private List<Employee> subordinates;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
        this.subordinates = new ArrayList<>();
    }

    public void addSubordinate(Employee e) {
        subordinates.add(e);
    }

    public void removeSubordinate(Employee e) {
        subordinates.remove(e);
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public void showDetails(String indent) {
        System.out.println(indent + position + ": " + name);
        for (Employee e : subordinates) {
            e.showDetails(indent + "  ");
        }
    }
}

