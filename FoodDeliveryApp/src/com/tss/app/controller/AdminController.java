package com.tss.app.controller;

import com.tss.app.service.AdminService;

import java.util.Scanner;

public class AdminController {
    private final AdminService service;
    private final Scanner sc;

    public AdminController(Scanner sc) {
        this.service = new AdminService();
        this.sc = sc;
    }

    public void start() {
        System.out.print("Enter name: ");
        String name = sc.next();
        System.out.print("Enter password: ");
        String pass = sc.next();

        if (!service.authenticate(name, pass)) {
            System.out.println("Wrong credentials !!");
            return;
        }
        System.out.println("Welcome " + name + " !!");

        boolean inPanel = true;
        while (inPanel) {
            System.out.println("\n--- Admin Panel ---");
            System.out.println("1. Set Menu\n2. Change Password\n3. Change Discount\n4. Add Agents\n5. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> service.handleMenuSetup(sc);
                case 2 -> service.changePassword(sc);
                case 3 -> service.changeDiscount(sc);
                case 4 -> service.manageAgents(sc);
                case 5 -> inPanel = false;
                default -> System.out.println("Invalid choice.");
            }
        }
        System.out.println("Exiting Admin Panel.\n");
    }
}
