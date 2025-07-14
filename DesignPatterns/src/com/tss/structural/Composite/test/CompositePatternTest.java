package com.tss.structural.Composite.test;

import com.tss.structural.Composite.model.Employee;

public class CompositePatternTest {
    public static void main(String[] args) {
        Employee ceo = new Employee("Alice", "CEO");
        Employee headSales = new Employee("Bob", "Head of Sales");
        Employee salesExec1 = new Employee("Charlie", "Sales Executive");
        Employee salesExec2 = new Employee("David", "Sales Executive");

        Employee headMarketing = new Employee("Eve", "Head of Marketing");
        Employee marketingExec = new Employee("Frank", "Marketing Executive");

        ceo.addSubordinate(headSales);
        ceo.addSubordinate(headMarketing);

        headSales.addSubordinate(salesExec1);
        headSales.addSubordinate(salesExec2);

        headMarketing.addSubordinate(marketingExec);

        ceo.showDetails("");
    }
}

