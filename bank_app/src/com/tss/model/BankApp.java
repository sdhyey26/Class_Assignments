package com.tss.model;

import java.util.Random;

public class BankApp {
	private int accountId;
	private String AccountNumber;
	private AccountType accountType;
	private String name;
	private int balance;

	@Override
	public String toString() {
		return "BankApp [accountId=" + accountId + ", AccountNumber=" + AccountNumber + ", accountType=" + accountType
				+ ", name=" + name + ", balance=" + balance + "]";
	}

	public BankApp() {
		super();
	}

	public BankApp(String name, int balance) {
		super();
		this.name = name;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {

		this.accountId = accountId + 1;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public String getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber() {
		String prefix = "AXIS1000";
		Random rand = new Random();
		int randomNumber = rand.nextInt(1_000_000);
		String formattedNumber = String.format("%06d", randomNumber);
		AccountNumber = prefix + formattedNumber;
	}

	public void deposit(int amount) {
		balance += amount;
		System.out.println("amount deposited : " + amount);
		System.out.println("updated balance : " + balance);
	}

	public void withdraw(int amount) {
		if (balance <= 500 || amount > balance) {
			System.out.println("insufficient balance !!");
		} else {
			balance -= amount;
			System.out.println("amount withdrawn : " + amount);
			System.out.println("updated balance : " + balance);
		}
	}

}
