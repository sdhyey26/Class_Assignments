package com.tss.test;

import java.util.Scanner;

import com.tss.model.ChristmasInterest;
import com.tss.model.DiwaliInterest;
import com.tss.model.HoliInterest;
import com.tss.model.IFestivalInterest;
import com.tss.model.NormalInterest;
import com.tss.model.FixedDeposit;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Account Number: ");
        int accNo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Principal Amount: ");
        double principal = scanner.nextDouble();

        System.out.print("Enter Duration (in years): ");
        int duration = scanner.nextInt();

        System.out.println("Select Festival:");
        System.out.println("1. Diwali");
        System.out.println("2. Holi");
        System.out.println("3. Christmas");
        System.out.println("4. Normal");

        int choice = scanner.nextInt();
        IFestivalInterest interest = null;

        switch (choice) {
            case 1:
                interest = new DiwaliInterest();
                break;
            case 2:
                interest = new HoliInterest();
                break;
            case 3:
                interest = new ChristmasInterest();
                break;
            case 4:
                interest = new NormalInterest();
                break;
            default:
                System.out.println("Invalid festival choice. Using Normal Interest.");
                interest = new NormalInterest();
                break;
        }

        FixedDeposit fd = new FixedDeposit(accNo, name, principal, duration, interest);

        System.out.println("Simple Interest = " + fd.calculateSimpleInterest());

        scanner.close();
    }
}
