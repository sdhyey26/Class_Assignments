package com.tss.model.inhertitance.model;

import java.util.Scanner;

public class Paypal implements IBill {

    @Override
    public void payment(int amount) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter PayPal email: ");
        String email = sc.nextLine();

        if (!email.contains("@") || !email.contains(".")) {
            System.out.println("Invalid email format.");
            return;
        }

        System.out.print("Enter PayPal password: ");
        String password = sc.nextLine();

        if (password.length() < 6) {
            System.out.println("Password must be at least 6 characters long.");
            return;
        }

        System.out.println("Payment of ₹" + amount + " successful via PayPal.");
    }
}
