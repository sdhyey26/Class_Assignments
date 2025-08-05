package com.tss.main;

import java.util.Scanner;

import com.tss.controller.TransferController;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TransferController controller = new TransferController();

        System.out.print("Enter Sender ID: ");
        int senderId = scanner.nextInt();

        System.out.print("Enter Receiver ID: ");
        int receiverId = scanner.nextInt();

        System.out.print("Enter Amount to Transfer: ");
        double amount = scanner.nextDouble();

        controller.initiateTransfer(senderId, receiverId, amount);
    }
}
