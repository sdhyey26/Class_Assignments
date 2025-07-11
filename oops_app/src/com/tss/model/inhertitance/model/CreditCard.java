package com.tss.model.inhertitance.model;

import java.util.Scanner;

public class CreditCard implements IBill {

    @Override
    public void payment(int amount) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter credit card number (16 digits): ");
        String cardNumber = sc.nextLine();

        if (cardNumber.length() != 16) {
            System.out.println("Invalid card number. Must be 16 digits.");
            return;
        }

        System.out.print("Enter CVV (3 digits): ");
        String cvv = sc.nextLine();

        if (cvv.length() != 3) {
            System.out.println("Invalid CVV. Must be 3 digits.");
            return;
        }

        System.out.print("Enter cardholder name: ");
        String name = sc.nextLine();

        if (name.trim().isEmpty()) {
            System.out.println("Cardholder name cannot be empty.");
            return;
        }

        System.out.println("Payment of ₹" + amount + " successful via Credit Card.");
    }
}
