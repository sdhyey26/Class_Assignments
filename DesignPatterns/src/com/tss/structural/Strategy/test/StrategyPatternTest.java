package com.tss.structural.Strategy.test;


import com.tss.structural.Strategy.model.*;

public class StrategyPatternTest {
    public static void main(String[] args) {
        Employee emp = new Employee(1, "Jitin", new Consultant());

        System.out.println("Role: " + emp.getDescription());
        System.out.println("Responsibility: " + emp.getResponsibility());

        System.out.println("\n-- Promoting to Senior Consultant --\n");
        emp.promote(new SeniorConsultant());

        System.out.println("Role: " + emp.getDescription());
        System.out.println("Responsibility: " + emp.getResponsibility());

        System.out.println("\n-- Promoting to Tech Lead --\n");
        emp.promote(new TechLead());

        System.out.println("Role: " + emp.getDescription());
        System.out.println("Responsibility: " + emp.getResponsibility());
    }
}
