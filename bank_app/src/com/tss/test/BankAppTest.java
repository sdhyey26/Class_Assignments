package com.tss.test;

import java.util.Scanner;

import com.tss.model.AccountType;
import com.tss.model.BankApp;

public class BankAppTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of Accounts to be created : ");
		int number = sc.nextInt();
		System.out.println();

		BankApp account[] = new BankApp[number];

		for (int i = 0; i < number; i++) {
			account[i] = new BankApp();
			readValues(account[i], i, sc);
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < number; i++) {
			for (int j = i + 1; j < number; j++) {
				if (account[i].getAccountNumber() == account[j].getAccountNumber()) {
					account[i].setAccountNumber();
				}
			}
		}

		for (int i = 0; i < number; i++) {
			System.out.println(account[i].toString());
		}
		System.out.println();

		System.out.println("Please choose from the options below : ");
		System.out.println("1.Display Balance :");
		System.out.println("2.Deposit :");
		System.out.println("3.withdraw : ");
		System.out.println("4.Transfer : ");
		System.out.println("5.Display accounts : ");
		System.out.println("6. Exit");
		System.out.println();

		boolean isTrue = true;

		while (isTrue) {
			System.out.print("please enter your choice : ");
			int choice = sc.nextInt();
			int accountID;
			int amount;

			switch (choice) {
			case 1:
				System.out.print("Enter your AccountID : ");
				accountID = sc.nextInt();
				for (int i = 0; i < number; i++) {
					if (account[i].getAccountId() == accountID) {
						System.out.println("The balance in your account is : " + account[i].getBalance());
					}
				}
				break;

			case 2:
				System.out.print("Enter your AccountID : ");
				accountID = sc.nextInt();
				System.out.print("Enter amount to be deposited : ");
				amount = sc.nextInt();

				for (int i = 0; i < number; i++) {
					if (account[i].getAccountId() == accountID) {
						account[i].deposit(amount);
					}
				}
				break;

			case 3:
				System.out.print("Enter your AccountID : ");
				accountID = sc.nextInt();
				System.out.print("Enter amount to be withdrawn : ");
				amount = sc.nextInt();

				for (int i = 0; i < number; i++) {
					if (account[i].getAccountId() == accountID) {
						account[i].withdraw(amount);
					}
				}
				break;

			case 4:

				System.out.println("Enter the accountIDs of both the accounts you want to transfer funds !! ");
				boolean fundsAvailable = true;
				while (fundsAvailable) {
					System.out.print("Enter the accountId from you want to transfer : ");
					int first = sc.nextInt();
					System.out.print("Enter the accountId to you want to receive : ");
					int second = sc.nextInt();
					System.out.print("Enter the amount to be transferred : ");
					amount = sc.nextInt();
					boolean isFound = true;

					for (int i = 0; i < number; i++) {
						if (account[i].getAccountId() == first) {
							for (int j = 0; j < number; j++) {
								if (account[j].getAccountId() == second) {
									if (account[i].getBalance() > 500 && account[i].getBalance() > amount && account[i].getBalance() - amount >=500) {
										account[i].setBalance(account[i].getBalance() - amount);
										account[j].setBalance(account[j].getBalance() + amount);
										System.out.println("Funds transferred succesfully!!");
										System.out.println("updated balance of accounts : " + account[i].getBalance()
												+ " , " + account[j].getBalance());
										fundsAvailable = false;
									} else {
										System.out.println("funds not available!!");
										fundsAvailable = false;
									}
								}
							}
						}
					}
				}
				break;

			case 5:
				for (int i = 0; i < number; i++) {
					System.out.println(account[i].toString());
				}
				break;

			case 6:
				isTrue = false;
			}
			System.out.println();

		}
	}

	public static void readValues(BankApp account, int i, Scanner sc) {
		System.out.print("Enter your name : ");
		account.setName(sc.next());
		boolean valid = false;

		while (valid == false) {
			System.out.print("Enter the Account Type : 1.SAVINGS 2.CURRENT 3.FD : ");
			int choice = sc.nextInt();

			if (choice == 1) {
				account.setAccountType(AccountType.SAVINGS);
				valid = true;
			} else if (choice == 2) {
				account.setAccountType(AccountType.CURRENT);
				valid = true;
			} else if (choice == 3) {
				account.setAccountType(AccountType.CURRENT);
				valid = true;
			} else {
				System.out.println("please enter a valid choice");
			}
		}

		System.out.print("Enter account balance (Minimum 500 required) : ");
		int balance = sc.nextInt();
		account.setBalance(balance);

		account.setAccountId(i);
		account.setAccountNumber();
	}
}
