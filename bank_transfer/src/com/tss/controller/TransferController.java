package com.tss.controller;

import com.tss.service.TransferService;

public class TransferController {
    private final TransferService service = new TransferService();

    public void initiateTransfer(int senderId, int receiverId, double amount) {
        try {
            String result = service.transfer(senderId, receiverId, amount);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Transfer failed: " + e.getMessage());
        }
    }
}
