package com.tss.model.inhertitance.model;

import java.util.Scanner;

public class UpiMethod implements IBill {

    @Override
    public void payment(int amount) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter UPI ID (e.g., name@bank): ");
        String upiId = sc.nextLine();

        if (!upiId.matches("^[\\w.-]+@[\\w.-]+$")) {
            System.out.println("Invalid UPI ID format.");
            return;
        }

        System.out.print("Enter UPI PIN (4 or 6 digits): ");
        String upiPin = sc.nextLine();

        if (!upiPin.matches("\\d{4}|\\d{6}")) {
            System.out.println("Invalid UPI PIN. Must be 4 or 6 digits.");
            return;
        }

        System.out.println("Payment of ₹" + amount + " successful via UPI.");
    }
}
