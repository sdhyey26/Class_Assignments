package com.tss.app.service;

import com.tss.model.admin.Admin;
import com.tss.model.Menu.IMenu;
import com.tss.model.Menu.IndianMenu;
import com.tss.model.Menu.ItalianMenu;
import com.tss.model.Menu.KoreanMenu;
import com.tss.exceptions.InvalidInputException;
import com.tss.model.DeliveryAgents.*;
import com.tss.model.admin.menu.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminService {
	public static IndianMenu indianMenu = new IndianMenu();
	public static ItalianMenu italianMenu = new ItalianMenu();
	public static KoreanMenu koreanMenu = new KoreanMenu();
	
	
    private final Admin admin = new Admin();

    public boolean authenticate(String name, String pass) {
        return name.equals(admin.getName()) && pass.equals(admin.getPassword());
    }

    public void handleMenuSetup(Scanner sc) {
    	System.out.print("Enter your choice: ");
		int choice = sc.nextInt();
		sc.nextLine();

		switch (choice) {
		case 1: {
			boolean isSubTrue = true;
			while (isSubTrue) {
				System.out.println("\nSelect Cuisine to Modify:");
				System.out.println("1. Indian Menu");
				System.out.println("2. Italian Menu");
				System.out.println("3. Korean Menu");
				System.out.println("4. Exit\n");
				System.out.print("Enter your choice: ");
				int menuChoice = sc.nextInt();

				switch (menuChoice) {
				case 1: {
					while (true) {
						System.out.print("\nEnter 1 to continue, 2 to exit: ");
						int doneContinue = sc.nextInt();
						sc.nextLine();

						if (doneContinue == 1) {
							System.out.print("Enter food name: ");
							String foodName = sc.nextLine();
							System.out.print("Enter food price: ");
							double foodPrice = sc.nextDouble();
							sc.nextLine();
							System.out.print("Enter food description: ");
							String foodDescription = sc.nextLine();
							admin.addIndianMenu(foodName, foodPrice, foodDescription);
						} else if (doneContinue == 2) {
							break;
						} else {
							throw new InvalidInputException();
						}
					}
					break;
				}
				case 2: {
					while (true) {
						System.out.print("\nEnter 1 to continue , 2 to exit ");
						int doneContinue = sc.nextInt();
						sc.nextLine();
						if (doneContinue == 1) {
							System.out.print("Enter food name: ");
							String foodName = sc.nextLine();
							System.out.print("Enter food price: ");
							double foodPrice = sc.nextDouble();
							sc.nextLine();
							System.out.print("Enter food description: ");
							String foodDescription = sc.nextLine();
							admin.addItalianMenu(foodName, foodPrice, foodDescription);
						} else if (doneContinue == 2) {
							break;
						} else {
							throw new InvalidInputException();
						}
					}
					break;
				}
				case 3: {
					while (true) {
						System.out.print("\nEnter 1 to continue, 2 to exit");
						int doneContinue = sc.nextInt();
						sc.nextLine();
						if (doneContinue == 1) {
							System.out.print("Enter food name: ");
							String foodName = sc.nextLine();
							System.out.print("Enter food price: ");
							double foodPrice = sc.nextDouble();
							sc.nextLine();
							System.out.print("Enter food description: ");
							String foodDescription = sc.nextLine();
							admin.addKoreanMenu(foodName, foodPrice, foodDescription);
						} else if (doneContinue == 2) {
							break;
						} else {
							throw new InvalidInputException();
						}
					}
					break;
				}
				case 4: {

					isSubTrue = false;
					break;
				}
				default:
					throw new InvalidInputException();
				}
			}
		}
		}
    }

    public void changePassword(Scanner sc) {
    	
    	System.out.print("\nEnter current password: ");
		String currentPassword = sc.nextLine();

		if (admin.getPassword().equals(currentPassword)) {
			System.out.print("Enter new password: ");
			String changedPassword = sc.nextLine();
			admin.setPassword(changedPassword);
			System.out.println("Password changed successfully !!");
		} else {
			System.out.println("Incorrect password !!");
		}
		
    }

    public void changeDiscount(Scanner sc) {
    	
    	System.out.print("\nEnter new discount percentage: ");
		int changedDiscount = sc.nextInt();
		sc.nextLine();
		admin.changeDiscountPercentage(changedDiscount);
		System.out.println("Discount percentage updated to: " + admin.getDiscountPercentage() + "%");    
		
    }

    public void manageAgents(Scanner sc) {
        admin.addDeliveryAgents();
        ArrayList<DeliveryAgent> list = admin.getDeliveryAgents();
        list.forEach(System.out::println);
    }

    public int getDiscount() {
        return admin.getDiscountPercentage();
    }
}
