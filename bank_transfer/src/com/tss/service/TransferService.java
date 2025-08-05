package com.tss.service;

import com.tss.dao.AccountDao;
import com.tss.dto.AccountDto;

public class TransferService {
    private final AccountDao dao = new AccountDao();

    public String transfer(int senderId, int receiverId, double amount) throws Exception {
        AccountDto sender = dao.getAccountById(senderId);
        AccountDto receiver = dao.getAccountById(receiverId);

        if (sender == null || receiver == null) {
            throw new Exception("One or both accounts not found.");
        }

        if (sender.getBalance() < amount) {
            throw new Exception("Insufficient funds in sender's account.");
        }

        sender.setBalance(sender.getBalance() - amount);
        dao.updateBalance(sender.getId(), sender.getBalance());

        try {
            receiver.setBalance(receiver.getBalance() + amount);
            if (!dao.updateBalance(receiver.getId(), receiver.getBalance())) {
                throw new Exception("Credit to receiver failed.");
            }
        } catch (Exception e) {
            throw new Exception("Credit failed. Debit retained. Reason: " + e.getMessage());
        }

        return "Transfer successful!\n" +
               "Updated Balances:\n" +
               "Sender (" + sender.getName() + "): ₹" + sender.getBalance() + "\n" +
               "Receiver (" + receiver.getName() + "): ₹" + receiver.getBalance();
    }
}
