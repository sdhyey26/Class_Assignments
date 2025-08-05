package com.tss.dto;

public class AccountDto {
    private int id;
    private String name;
    private double balance;

    public AccountDto(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getBalance() { return balance; }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
