package com.tss.app.service;

import com.tss.model.admin.Admin;
import com.tss.model.Menu.IMenu;
import com.tss.model.Menu.IndianMenu;
import com.tss.model.Menu.ItalianMenu;
import com.tss.model.Menu.KoreanMenu;
import com.tss.exceptions.InvalidInputException;
import com.tss.model.DeliveryAgents.*;
import com.tss.model.admin.menu.*;
import com.tss.model.admin.storage.FileStorage;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminService {
	public static IndianMenu indianMenu = new IndianMenu();
	public static ItalianMenu italianMenu = new ItalianMenu();
	public static KoreanMenu koreanMenu = new KoreanMenu();

	private static final Admin admin = new Admin();
	public static ArrayList<DeliveryAgent> list = admin.getDeliveryAgents();

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

						for (IndianMenu menuManager : IndianMenuManager.list) {
							System.out.println(menuManager.toString());
						}

						if (doneContinue == 1) {

							System.out.println("1.add");
							System.out.println("2.remove");
							int indianMenuChoice = sc.nextInt();

							if (indianMenuChoice == 1) {
								System.out.print("Enter food name: ");
								String foodName = sc.nextLine();
								sc.nextLine();
								System.out.print("Enter food price: ");
								double foodPrice = sc.nextDouble();
								sc.nextLine();
								System.out.print("Enter food description: ");
								String foodDescription = sc.nextLine();
								admin.addIndianMenu(foodName, foodPrice, foodDescription);

							} else if (indianMenuChoice == 2) {
								int k = 0;
								for (IndianMenu menuManager : IndianMenuManager.list) {
									
									System.out.println(k + " " + menuManager.toString());
									k++;
								}

								System.out.println("Enter the index to remove : ");
								int index = sc.nextInt();

								if (!IndianMenuManager.list.isEmpty()) {
									IndianMenuManager.list.remove(index);
									FileStorage.saveListToFile(IndianMenuManager.list, "IndianMenuList.ser");

									for (IndianMenu menuManager : IndianMenuManager.list) {
										int i = 0;
										System.out.println(i + " " + menuManager.toString());
										i++;
									}
								} else {
									System.out.println("The list is empty !!");
								}
							} else {
								throw new InvalidInputException();
							}
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

						System.out.print("\nEnter 1 to continue, 2 to exit: ");
						int doneContinue = sc.nextInt();
						sc.nextLine();

						for (ItalianMenu menuManager : ItalianMenuManager.list) {
							System.out.println(menuManager.toString());
						}

						System.out.print("\nEnter 1 to continue , 2 to exit ");
						doneContinue = sc.nextInt();
						sc.nextLine();

						if (doneContinue == 1) {
							System.out.println("1.add");
							System.out.println("2.remove");
							int italianMenuChoice = sc.nextInt();

							if (italianMenuChoice == 1) {
								System.out.print("Enter food name: ");
								String foodName = sc.nextLine();
								sc.nextLine();

								System.out.print("Enter food price: ");
								double foodPrice = sc.nextDouble();
								sc.nextLine();
								System.out.print("Enter food description: ");
								String foodDescription = sc.nextLine();
								admin.addItalianMenu(foodName, foodPrice, foodDescription);
							} 
							else if (italianMenuChoice == 2) {
								int j = 0;
								for (ItalianMenu menuManager : ItalianMenuManager.list) {
									
									System.out.println(j + " " + menuManager.toString());
									j++;
								}

								System.out.println("Enter the index to remove : ");
								int index = sc.nextInt();

								if (!ItalianMenuManager.list.isEmpty()) {
									ItalianMenuManager.list.remove(index);
									FileStorage.saveListToFile(ItalianMenuManager.list, "ItalianMenuList.ser");

									for (ItalianMenu menuManager : ItalianMenuManager.list) {
										int i = 0;
										System.out.println(i + " " + menuManager.toString());
										i++;
									}
								} else {
									throw new InvalidInputException();
								}
							}
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
						
						for (KoreanMenu menuManager : KoreanMenuManager.list) {
							System.out.println(menuManager.toString());
						}
						
						sc.nextLine();
						if (doneContinue == 1) {
							System.out.println("1.add");
							System.out.println("2.remove");
							int KoreanMenuChoice = sc.nextInt();
							
							if(KoreanMenuChoice == 1) {
								System.out.print("Enter food name: ");
								String foodName = sc.nextLine();
								sc.nextLine();
								System.out.print("Enter food price: ");
								double foodPrice = sc.nextDouble();
								sc.nextLine();
								System.out.print("Enter food description: ");
								String foodDescription = sc.nextLine();
								admin.addKoreanMenu(foodName, foodPrice, foodDescription);
							}
							else if(KoreanMenuChoice == 2) {
								int k = 0;
								for (KoreanMenu menuManager : KoreanMenuManager.list) {
									
									System.out.println(k + " " + menuManager.toString());
									k++;
								}

								System.out.println("Enter the index to remove : ");
								int index = sc.nextInt();

								if (!KoreanMenuManager.list.isEmpty()) {
									KoreanMenuManager.list.remove(index);
									FileStorage.saveListToFile(KoreanMenuManager.list, "KoreanMenuList.ser");

									for (KoreanMenu menuManager : KoreanMenuManager.list) {
										int i = 0;
										System.out.println(i + " " + menuManager.toString());
										i++;
									}
								} else {
									throw new InvalidInputException();
								}
							}
							else {
								System.out.println("Enter valid choice !!");
							}
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
		list.forEach(System.out::println);
		admin.addDeliveryAgents();
		list.forEach(System.out::println);
	}

	public int getDiscount() {
		return admin.getDiscountPercentage();
	}
}
