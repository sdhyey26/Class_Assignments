package com.tss.model;

public class AccountFromUser {
	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
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

	public AccounType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccounType accountType) {
		this.accountType = accountType;
	}

	int accountId;

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountNumber=" + accountNumber + ", name=" + name + ", balance="
				+ balance + ", accountType=" + accountType + "]";
	}

	int accountNumber;
	String name;
	int balance;
	AccounType accountType;

	public void deposit(int amount) {
		balance += amount;
		System.out.println("amount deposited : " + balance);
	}

	public void withdraw(int amount) {
		if (balance <= 500 || amount > balance) {
			System.out.println("insufficient balance !!");
		} else {
			balance -= amount;
			System.out.println("amount withdrawn : " + balance);
		}
	}
}
