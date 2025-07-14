package com.tss.behavioral.observer.test;

import java.util.ArrayList;
import java.util.Scanner;

import com.tss.behavioral.observer.exception.MinimumBalanceException;
import com.tss.behavioral.observer.model.SavingsAccountModel;
import com.tss.behavioral.observer.model.WhatsappNotifier;
import com.tss.behavioral.observer.model.AccountModel;
import com.tss.behavioral.observer.model.*;

public class AccountTest {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Inotifier whatsappNotifier = new WhatsappNotifier();
		Inotifier smsNotifier= new SmsNotifier();
		Inotifier emailNotifier= new EmailNotifier();
		
		
		Scanner sc = new Scanner(System.in);

		SavingsAccountModel savings = new SavingsAccountModel();

		System.out.println("Enter Name : ");
		String name = sc.next();
		savings.setName(name);
		System.out.println("Set Acc no : ");
		int accNo = sc.nextInt();
		savings.setAccno(accNo);
		System.out.println("enter minimum balance : ");
		int minBalance = sc.nextInt();
		savings.setMinBalance(minBalance);
		sc.nextLine();

		
		ArrayList<Inotifier> notifier = new ArrayList<>();
		

		System.out.println("1.display");
		System.out.println("2.credit");
		System.out.println("3.debit");
		System.out.println("4.Exit");
		System.out.println("5.remove all the notifiers!!");
		sc.nextLine();
		
		boolean isTrue = true;
		while (isTrue) {
			
			if(notifier.isEmpty()) {
				System.out.println("Enter the notifier 1.Whatsapp 2.Sms 3.Email 4.all");
				int choice = sc.nextInt();
				
				if(choice == 1) {
					notifier.add(whatsappNotifier);
				}
				else if(choice == 2) {
					notifier.add(smsNotifier);
				}
				else if(choice == 3) {
					notifier.add(emailNotifier);
				}
				else if(choice == 4) {
					notifier.add(emailNotifier);
					notifier.add(smsNotifier);
					notifier.add(whatsappNotifier);
				}
				else {
					System.out.println("Invalid choice");
				}
			}
			
			System.out.println("enter your choice : ");
			int choiceAgain = sc.nextInt();
			switch (choiceAgain) {
			case 1: {
				savings.display();
			}
				break;

			case 2: {

				System.out.println("enter amount : ");
				int amount = sc.nextInt();
				savings.credit(amount);
				for(Inotifier notify : notifier) {
					notify.sendNotification(savings.getBalance());
				}
			}
				break;

			case 3: {
				try {
					System.out.println("enter amount : ");
					int amount = sc.nextInt();
					savings.debit(amount);
					for(Inotifier notify : notifier) {
						notify.sendNotification(savings.getBalance());
					}
				}

				catch (MinimumBalanceException exception) {
					System.out.println(exception);
				}
			}break;
				

			case 4: {
				isTrue = false;
			}break;
			
			case 5 : {
				
				notifier.removeAll(notifier);
			}break;

			}
		}
	}

}
