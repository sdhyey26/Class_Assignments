package com.tss.app.controller;

import com.tss.app.service.AdminService;
import com.tss.app.service.OrderService;

import java.util.Scanner;

public class CustomerController {
    private final Scanner sc;
    private final AdminService adminService;
    private final OrderService orderService;

    public CustomerController(Scanner sc) {
        this.sc = sc;
        this.adminService = new AdminService();
        this.orderService = new OrderService(adminService);
    }

    public void start() {
        System.out.println("Enter your name, password, address:");
        sc.nextLine();
        String name = sc.nextLine();
        String pass = sc.nextLine();
        String addr = sc.nextLine();
        
        orderService.initCustomer(name, pass, addr , sc);

        boolean cont = true;
        while (cont) {
            System.out.println("1. Place Order\n2. Display Bill\n3. Pay\n4. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> orderService.placeOrder(sc);
                case 2 -> orderService.displayCart();
                case 3 -> orderService.checkout(sc);
                case 4 -> { System.out.println("Thanks. Visit again!"); cont = false; }
                default -> System.out.println("Invalid input !!");
            }
        }
    }
}
