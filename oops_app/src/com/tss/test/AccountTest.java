package com.tss.test;

import java.util.Scanner;

import com.tss.model.AccounType;
import com.tss.model.Account;

public class AccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Account account1 = new Account();

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
				account1.setAccountId(sc.nextInt());
				System.out.print("Enter account number : ");
				account1.setAccountNumber(sc.nextInt());
				System.out.print("Enter account holder Name : ");
				account1.setName(sc.next());
				System.out.print("Enter Balance (minimum 500) : ");
				account1.setBalance(sc.nextInt());
				System.out.print("Enter account Type : 1.Savings 2.Current 3.FD ");
				int accountType = sc.nextInt();
				if(accountType == 1) {
					account1.setAccountType(AccounType.SAVINGS);
				}
				if(accountType == 2) {
					account1.setAccountType(AccounType.CURRENT);
				}
				if(accountType == 3) {
					account1.setAccountType(AccounType.FD);
				}
				else {
					System.out.println("enter valid choice");
				}
				
				System.out.println(account1);
			}
				break;

			case 2: {
				System.out.println("Your current balance is : " + account1.getBalance());
			}
				break;

			case 3: {
				System.out.println("Enter amount to be deposited : ");
				int amount = sc.nextInt();
				account1.deposit(amount);
			}
				break;

			case 4: {
				System.out.println("Enter amount to be withdrawn : ");
				int amount = sc.nextInt();
				account1.withdraw(amount);
			}
				break;

			case 5:
				condition = false;
				break;
			}
		}
	}
}
