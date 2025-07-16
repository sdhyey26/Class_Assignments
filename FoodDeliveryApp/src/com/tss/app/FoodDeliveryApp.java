package com.tss.app;

import com.tss.app.controller.AdminController;
import com.tss.app.controller.CustomerController;

import java.util.Scanner;

public class FoodDeliveryApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Food Delivery App !!");
        System.out.println("1. Admin Login");
        System.out.println("2. Customer Login");

        int c = sc.nextInt();
        if (c == 1) new AdminController(sc).start();
        else if (c == 2) new CustomerController(sc).start();
        else System.out.println("Please enter a valid choice !!");

        sc.close();
    }
}
