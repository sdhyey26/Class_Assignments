package com.tss.test;

import java.util.Scanner;

import com.tss.model.AccounType;
import com.tss.model.AccountFromUser;

public class AccountFromUserTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of objects to be created : ");
		int number = sc.nextInt();
		
		AccountFromUser account[] = new AccountFromUser[number];
		
		for(int i = 0 ; i < number ; i++) {
			account[i] = new AccountFromUser();
			readValue(account , sc , i);
		}
		
		for(int i = 0 ; i < number ; i++) {
			System.out.println(account[i]);
		}
		
	}
	
	public static void readValue(AccountFromUser account[] , Scanner sc ,int i) {
		System.out.println("Please choose from the options below : ");
		System.out.println("1.Create Account :");
		System.out.println("2.Display Balance :");
		System.out.println("3.Deposit : ");
		System.out.println("4.withdraw : ");
		System.out.println("5.Exit : ");
		boolean condition = true;
		int choice;

		while (condition) {
			System.out.println("enter your choice : ");
			choice = sc.nextInt();

			switch (choice) {

			case 1: {
				System.out.print("Enter account ID : ");
				account[i].setAccountId(sc.nextInt());
				System.out.print("Enter account number : ");
				account[i].setAccountNumber(sc.nextInt());
				System.out.print("Enter account holder Name : ");
				account[i].setName(sc.next());
				System.out.print("Enter Balance (minimum 500) : ");
				account[i].setBalance(sc.nextInt());
				System.out.print("Enter account Type : 1.Savings 2.Current 3.FD ");
				int accountType = sc.nextInt();
				if(accountType == 1) {
					account[i].setAccountType(AccounType.SAVINGS);
				}
				if(accountType == 2) {
					account[i].setAccountType(AccounType.CURRENT);
				}
				if(accountType == 3) {
					account[i].setAccountType(AccounType.FD);
				}
				else {
					System.out.println("enter valid choice");
				}
				
				System.out.println(account[i]);
			}
				break;

			case 2: {
				System.out.println("Choose the account : ");
				int ch = sc.nextInt();
				System.out.println("Your current balance is : " + account[ch].getBalance());
			}
				break;

			case 3: {
				System.out.println("Choose the account : ");
				int ch = sc.nextInt();
				System.out.println("Enter amount to be deposited : ");
				int amount = sc.nextInt();
				account[ch].deposit(amount);
			}
				break;

			case 4: {
				System.out.println("Choose the account : ");
				int ch = sc.nextInt();
				System.out.println("Enter amount to be withdrawn : ");
				int amount = sc.nextInt();
				account[ch].withdraw(amount);
			}
				break;

			case 5:
				condition = false;
				break;
			}
		}

	}
}
