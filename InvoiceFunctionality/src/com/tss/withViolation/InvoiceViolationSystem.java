package com.tss.withViolation;

import java.util.Scanner;

public class InvoiceViolationSystem {

    static int id;
    static String description;
    static double cost;
    static double discountPercent;
    static final double tax = 10.0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ID: ");
        id = sc.nextInt();

        System.out.print("Enter Description: ");
        description = sc.next();

        System.out.print("Enter Cost: ");
        cost = sc.nextDouble();

        System.out.print("Enter Discount Percentage: ");
        discountPercent = sc.nextDouble();

        System.out.printf("Tax Amount: %.2f\n", calculateTax());
        System.out.printf("Discount Amount: %.2f\n", calculateDiscount());
        System.out.printf("Final Price: %.2f\n", calculateFinalCost());

        printBill();
    }

    public static double calculateTax() {
        return (cost * tax) / 100;
    }

    public static double calculateDiscount() {
        return (cost * discountPercent) / 100;
    }

    public static double calculateFinalCost() {
        return cost - calculateDiscount() + calculateTax();
    }

    public static void printBill() {
        double discountAmount = calculateDiscount();
        double taxAmount = calculateTax();
        double finalAmount = calculateFinalCost();

        System.out.println("\n===== INVOICE =====");
        System.out.println("ID: " + id);
        System.out.println("Description: " + description);
        System.out.printf("Base Cost: %.2f\n", cost);
        System.out.printf("Discount (%.1f%%): -%.2f\n", discountPercent, discountAmount);
        System.out.printf("Tax (%.1f%%): +%.2f\n", tax, taxAmount);
        System.out.println("---------------------------");
        System.out.printf("Final Amount: %.2f\n", finalAmount);
        System.out.println("=====================");
    }
}
