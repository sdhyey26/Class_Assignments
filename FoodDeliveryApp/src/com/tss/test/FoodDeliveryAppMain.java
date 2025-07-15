package com.tss.test;

import java.util.ArrayList;
import java.util.Scanner;
import com.tss.model.Admin;
import com.tss.model.Customer;
import com.tss.model.DeliveryAgents;
import com.tss.model.IMenu;
import com.tss.model.IndianMenu;
import com.tss.model.ItalianMenu;
import com.tss.model.KoreanMenu;

public class FoodDeliveryAppMain {

	static ArrayList<IMenu> orderList = new ArrayList<>();
	static Admin admin = new Admin();
	static Customer customer = new Customer();
	static IndianMenu indianMenu = new IndianMenu();
	static ItalianMenu italianMenu = new ItalianMenu();
	static KoreanMenu koreanMenu = new KoreanMenu();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to food delivery App !! ");
		System.out.println("1. Admin Login / 2. normal login");
		Scanner sc = new Scanner(System.in);
		int choiceForAdmin = sc.nextInt();

		if (choiceForAdmin == 1) {
			adminPanel(sc, admin);
		} else if (choiceForAdmin == 2) {
			customerPanel(sc);
		} else {
			System.out.println("please enter valid choice !!");
		}
	}

	public static void adminPanel(Scanner sc, Admin admin) {

		System.out.println("Enter name : ");
		String name = sc.next();

		System.out.println("Enter password : ");
		String password = sc.next();

		if (name.equals(admin.getName()) && password.equals(admin.getPassword())) {
			System.out.println("Welcome " + admin.getName() + " !!");

			boolean isTrue = true;

			while (isTrue) {
				System.out.println("1. Set Menu ");
				System.out.println("2. Change admin password");
				System.out.println("3. Change Discount percentage");
				System.out.println("4. Add/change delivery agents");
				System.out.println("5. Exit");

				System.out.println("Enter your choice : ");
				int choice = sc.nextInt();
				sc.nextLine();

				switch (choice) {
				case 1: {

					boolean isSubTrue = true;
					while (isSubTrue) {
						System.out.println("1.Indian Menu");
						System.out.println("2.Italain Menu");
						System.out.println("3.Korean Menu");
						System.out.println("4.Exit");

						int menuChoice = sc.nextInt();

						switch (menuChoice) {

						case 1: {
							while (true) {
								System.out.println("Enter 1 to exit / 2 to continue : ");
								int doneContinue = sc.nextInt();
								sc.nextLine();
								if (doneContinue == 2) {
									System.out.println("Enter food name : ");
									String foodName = sc.nextLine();

									System.out.println("Enter food price : ");
									double foodPrice = sc.nextDouble();
									sc.nextLine();

									System.out.println("Enter food description : ");
									String foodDescription = sc.nextLine();

									admin.setIndianMenu(foodName, foodPrice, foodDescription);
								} else if (doneContinue == 1) {
									break;
								} else {
									System.out.println("invalid input !!");
								}
							}
						}
							break;

						case 2: {
							while (true) {
								System.out.println("Enter 1 or 2 to continue : ");
								int doneContinue = sc.nextInt();
								sc.nextLine();
								if (doneContinue == 2) {
									System.out.println("Enter food name : ");
									String foodName = sc.nextLine();

									System.out.println("Enter food price : ");
									double foodPrice = sc.nextDouble();
									sc.nextLine();

									System.out.println("Enter food description : ");
									String foodDescription = sc.nextLine();

									admin.setItalianMenu(foodName, foodPrice, foodDescription);
								} else if (doneContinue == 1) {
									break;
								} else {
									System.out.println("invalid input !!");
								}
							}
						}
							break;

						case 3: {
							while (true) {
								System.out.println("Enter 1 or 2 to continue : ");
								int doneContinue = sc.nextInt();
								sc.nextLine();

								if (doneContinue == 2) {
									System.out.println("Enter food name : ");
									String foodName = sc.nextLine();

									System.out.println("Enter food price : ");
									double foodPrice = sc.nextDouble();
									sc.nextLine();

									System.out.println("Enter food description : ");
									String foodDescription = sc.nextLine();

									admin.setKoreanMenu(foodName, foodPrice, foodDescription);
								} else if (doneContinue == 1) {
									break;
								} else {
									System.out.println("invalid choice !!");
								}
							}
						}
							break;

						case 4: {
							choice = 1;
							isSubTrue = false;
						}
						}
					}
				}
					break;

				case 2: {
					System.out.println("Enter the current password : ");
					String currentPassword = sc.nextLine();

					if (admin.getPassword().equals(currentPassword)) {
						System.out.println("Enter the password you want to change to : ");
						String changedPassword = sc.nextLine();

						admin.setPassword(changedPassword);

						System.out.println("Password changed successfully !!");
					} else {
						System.out.println("Enter correct password !!");
					}
				}
					break;

				case 3: {
					System.out.println("Enter the percentage you want to change to : ");
					int changedDiscount = sc.nextInt();
					sc.nextLine();

					admin.changeDiscountPercentage(changedDiscount);
				}
					break;

				case 4: {
					admin.setDeliveryAgent();
					ArrayList<DeliveryAgents> agentInfo = admin.getDeliveryAgent();

					for (DeliveryAgents agent : agentInfo) {
						System.out.println(agent.toString());
					}
				}
					break;

				case 5: {
					isTrue = false;
					System.out.println("Exiting admin panel.");
				}
					break;

				default: {
					System.out.println("Invalid choice. Please try again.");
				}
				}
			}
		} else {
			System.out.println("Wrong credentials !!");
		}
	}

	public static void customerPanel(Scanner sc) {
		sc.nextLine();

		System.out.println("Enter name : ");
		customer.setName(sc.nextLine());

		System.out.println("Enter password : ");
		customer.setPassword(sc.nextLine());

		System.out.println("Enter Address : ");
		customer.setAddress(sc.nextLine());

		System.out.println("Welcome " + customer.getName() + " !!");

		boolean isTrue = true;
		int total = 0;

		while (isTrue) {

			System.out.println("1. place order : ");
			System.out.println("2. display bill : ");
			System.out.println("3. Proceed to payment");
			System.out.println("4. Exit");

			System.out.println("Enter your choice : ");
			int choice = sc.nextInt();

			switch (choice) {

			case 1: {

				boolean isTrueForMenu = true;

				while (isTrueForMenu) {

					System.out.println(" 1. Indian cuisine ");
					System.out.println(" 2. Italian cuisine ");
					System.out.println(" 3. korean cuisine ");
					System.out.println(" 4. Exit ");

					System.out.println("Enter your choice : ");
					int getMenuChoice = sc.nextInt();

					switch (getMenuChoice) {

					case 1: {
						int i = 0;
						ArrayList<IndianMenu> indianMenuList = indianMenu.getMenu();

						for (IndianMenu item : indianMenuList) {
							System.out.println("[id : " + i++ + "] " + item.toString());
						}

						sc.nextLine();

						while (true) {
							System.out.println("Enter 1 to stop, 2 to continue order");
							String doneContinue = sc.nextLine();

							if (doneContinue.equals("2")) {
								System.out.println("Enter id to add to cart: ");
								int id = sc.nextInt();

								System.out.println("enter quantity to be added : ");
								int quantity = sc.nextInt();

								sc.nextLine();

								for (int in = 0; in < quantity; in++) {
									if (id >= 0 && id < indianMenuList.size()) {
										IndianMenu item = indianMenuList.get(id);
										orderList.add(item);
										total += item.getPrice();
										System.out.println(item.getFoodName() + " added to cart.");
									} else {
										System.out.println("Invalid id.");
									}
								}

							} else if (doneContinue.equals("1")) {
								System.out.println("Order added !!");
								break;
							} else {
								System.out.println("Invalid input.");
							}
						}
					}
						break;

					case 2: {
						int i = 0;
						ArrayList<ItalianMenu> italianMenuList = italianMenu.getMenu();
						for (ItalianMenu item : italianMenuList) {
							System.out.println("[id : " + i++ + "] " + item.toString());
						}

						sc.nextLine();

						while (true) {
							System.out.println("Enter 1 to stop, 2 to continue order");
							String doneContinue = sc.nextLine();

							if (doneContinue.equals("2")) {
								System.out.println("Enter id to add to cart: ");
								int id = sc.nextInt();

								System.out.println("enter quantity to be added : ");
								int quantity = sc.nextInt();

								sc.nextLine();

								for (int in = 0; in < quantity; in++) {
									if (id >= 0 && id < italianMenuList.size()) {
										ItalianMenu item = italianMenuList.get(id);
										orderList.add(item);
										total += item.getPrice();
										System.out.println(item.getFoodName() + " added to cart.");
									} else {
										System.out.println("Invalid id.");
									}
								}

							} else if (doneContinue.equals("1")) {
								System.out.println("Order added !!");
								break;
							} else {
								System.out.println("Invalid input.");
							}
						}
					}
						break;

					case 3: {
						int i = 0;
						ArrayList<KoreanMenu> koreanMenuList = koreanMenu.getMenu();

						for (KoreanMenu item : koreanMenuList) {
							System.out.println("[id : " + i++ + "] " + item.toString());
						}

						sc.nextLine();

						while (true) {
							System.out.println("Enter 1 to stop, 2 to continue order");
							String doneContinue = sc.nextLine();

							if (doneContinue.equals("2")) {
								System.out.println("Enter id to add to cart: ");
								int id = sc.nextInt();

								System.out.println("enter quantity to be added : ");
								int quantity = sc.nextInt();

								sc.nextLine();

								for (int in = 0; in < quantity; in++) {
									if (id >= 0 && id < koreanMenuList.size()) {
										KoreanMenu item = koreanMenuList.get(id);
										orderList.add(item);
										total += item.getPrice();
										System.out.println(item.getFoodName() + " added to cart.");
									} else {
										System.out.println("Invalid id.");
									}
								}

							} else if (doneContinue.equals("1")) {
								System.out.println("Order added !!");
								break;
							} else {
								System.out.println("Invalid input.");
							}
						}

					}
						break;

					case 4: {
						isTrueForMenu = false;
					}
						break;

					}
				}

			}
				break;

			case 2: {
				if (orderList.isEmpty()) {
					System.out.println("Add something to cart first !!");
				} else {
					for (IMenu item : orderList) {
						System.out.println(item.toString());
					}
					System.out.println();
				}
			}
				break;

			}
		}
	}
}
