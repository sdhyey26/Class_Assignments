package com.tss.model.inhertitance.model;

import java.util.Scanner;

public class DebitCard implements IBill {

    @Override
    public void payment(int amount) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter debit card number (16 digits): ");
        String cardNumber = sc.nextLine();

        if (cardNumber.length() != 16) {
            System.out.println("Invalid card number. Must be 16 digits.");
            return;
        }

        System.out.print("Enter PIN (4 digits): ");
        String pin = sc.nextLine();

        if (pin.length() != 4) {
            System.out.println("Invalid PIN. Must be 4 digits.");
            return;
        }

        System.out.println("Payment of ₹" + amount + " successful via Debit Card.");
    }
}
