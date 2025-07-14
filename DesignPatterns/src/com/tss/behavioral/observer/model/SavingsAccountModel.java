package com.tss.behavioral.observer.model;

import com.tss.behavioral.observer.exception.MinimumBalanceException;
import com.tss.behavioral.observer.exception.NegativeBalanceException;

public class SavingsAccountModel extends AccountModel {
	private int minBalance;

	void SavingsAccountModel() {
		setMinBalance(minBalance);
	}

	public int getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(int minBalance) {
		if (minBalance < 0)
			throw new NegativeBalanceException(minBalance);
		this.minBalance = minBalance;
	}

	public void display() {
		System.out.println("Name : " + getName());
		System.out.println("Balance : " + getBalance());
		System.out.println("Account Number : " + getAccno());
	}

	@Override
	public void debit(int amount) {
		if (amount <= minBalance) {
			setMinBalance(minBalance - amount);
			System.out.println("amount debited successfully!!");
			System.out.println("Balance left : " + getBalance());
		} else {
			throw new MinimumBalanceException(getMinBalance());
		}
	}

	@Override
	public void credit(int amount) {
		setMinBalance(getBalance() + amount);
		System.out.println("Balance credit successfully !!");
		System.out.println("updated successfully : " + getBalance());
	}
}
