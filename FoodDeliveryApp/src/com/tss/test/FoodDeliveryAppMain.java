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
import com.tss.model.PaymentMethods;
import com.tss.model.PaymentProceed;

public class FoodDeliveryAppMain {

	static ArrayList<IMenu> orderList = new ArrayList<>();
	static Admin admin = new Admin();
	static Customer customer = new Customer();
	static IndianMenu indianMenu = new IndianMenu();
	static ItalianMenu italianMenu = new ItalianMenu();
	static KoreanMenu koreanMenu = new KoreanMenu();
	static PaymentProceed payment = new PaymentProceed();
	static DeliveryAgents agents = new DeliveryAgents();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("\n====================================");
		System.out.println("   Welcome to Food Delivery App !!  ");
		System.out.println("====================================\n");

		System.out.println("Select Login Type:");
		System.out.println("1. Admin Login");
		System.out.println("2. Customer Login\n");

		Scanner sc = new Scanner(System.in);
		int choiceForAdmin = sc.nextInt();

		if (choiceForAdmin == 1) {
			adminPanel(sc, admin);
		} else if (choiceForAdmin == 2) {
			customerPanel(sc);
		} else {
			System.out.println("\nPlease enter a valid choice !!\n");
		}
	}

	public static void adminPanel(Scanner sc, Admin admin) {
		System.out.print("\nEnter name: ");
		String name = sc.next();

		System.out.print("Enter password: ");
		String password = sc.next();

		if (name.equals(admin.getName()) && password.equals(admin.getPassword())) {
			System.out.println("\nWelcome " + admin.getName() + " !!\n");

			boolean isTrue = true;

			while (isTrue) {
				System.out.println("\n=========== Admin Panel ===========");
				System.out.println("1. Set Menu");
				System.out.println("2. Change Admin Password");
				System.out.println("3. Change Discount Percentage");
				System.out.println("4. Add/Change Delivery Agents");
				System.out.println("5. Exit\n");
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

								if (doneContinue == 2) {
									System.out.print("Enter food name: ");
									String foodName = sc.nextLine();
									System.out.print("Enter food price: ");
									double foodPrice = sc.nextDouble();
									sc.nextLine();
									System.out.print("Enter food description: ");
									String foodDescription = sc.nextLine();
									admin.setIndianMenu(foodName, foodPrice, foodDescription);
								} else if (doneContinue == 2) {
									break;
								} else {
									System.out.println("Invalid input !!");
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
									admin.setItalianMenu(foodName, foodPrice, foodDescription);
								} else if (doneContinue == 2) {
									break;
								} else {
									System.out.println("Invalid input !!");
								}
							}
							break;
						}
						case 3: {
							while (true) {
								System.out.print("\nEnter 1 to continue, 2 to exit");
								int doneContinue = sc.nextInt();
								sc.nextLine();
								if (doneContinue == 2) {
									System.out.print("Enter food name: ");
									String foodName = sc.nextLine();
									System.out.print("Enter food price: ");
									double foodPrice = sc.nextDouble();
									sc.nextLine();
									System.out.print("Enter food description: ");
									String foodDescription = sc.nextLine();
									admin.setKoreanMenu(foodName, foodPrice, foodDescription);
								} else if (doneContinue == 1) {
									break;
								} else {
									System.out.println("Invalid input !!");
								}
							}
							break;
						}
						case 4: {

							isSubTrue = false;
							break;
						}
						default:
							System.out.println("Invalid menu choice.");
						}
					}
					break;
				}
				case 2: {
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
					break;
				}
				case 3: {
					System.out.print("\nEnter new discount percentage: ");
					int changedDiscount = sc.nextInt();
					sc.nextLine();
					admin.changeDiscountPercentage(changedDiscount);
					System.out.println("Discount percentage updated to: " + admin.getDiscountPercentage() + "%");
					break;
				}
				case 4: {
					admin.setDeliveryAgent();
					ArrayList<DeliveryAgents> agentInfo = admin.getDeliveryAgent();
					System.out.println("\nCurrent Delivery Agents:");
					for (DeliveryAgents agent : agentInfo) {
						System.out.println(agent.toString());
					}
					break;
				}
				case 5: {
					isTrue = false;
					System.out.println("\nExiting Admin Panel.\n");
					break;
				}
				default: {
					System.out.println("Invalid choice. Please try again.\n");
				}
				}
			}
		} else {
			System.out.println("\nWrong credentials !!\n");
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
					System.out.println(
							"buy of ₹ 500 or above to get " + admin.getDiscountPercentage() + "% of discount!!");
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
							System.out.println("Enter 1 to continue, 2 to stop ordering");
							String doneContinue = sc.nextLine();
							if (doneContinue.equals("1")) {
								System.out.println("Enter id to add to cart: ");
								int id = sc.nextInt();
								System.out.println("enter quantity to be added : ");
								int quantity = sc.nextInt();
								sc.nextLine();
								if (quantity <= 0) {
									System.out.println("Enter valid quantity !");
								} else {
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
								}
							} else if (doneContinue.equals("2")) {
								System.out.println("Exiting ordering !!");
								break;
							} else {
								System.out.println("Invalid input.");
							}
						}
						break;
					}
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
								if (quantity <= 0) {
									System.out.println("Enter valid quantity !");
								} else {
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
								}
							} else if (doneContinue.equals("1")) {
								System.out.println("Exiting Ordering !!");
								break;
							} else {
								System.out.println("Invalid input.");
							}
						}
						break;
					}
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
								if (quantity <= 0) {
									System.out.println("Enter valid quantity !");
								} else {
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
								}
							} else if (doneContinue.equals("1")) {
								System.out.println("Exiting ordering !!");
								break;
							} else {
								System.out.println("Invalid input.");
							}
						}
						break;
					}
					case 4: {
						isTrueForMenu = false;
						break;
					}
					}
				}
				break;
			}
			case 2: {
				if (orderList.isEmpty()) {
					System.out.println("Add something to cart first !!");
				} else {
					for (IMenu item : orderList) {
						System.out.println(item.toString());
					}
					System.out.println();
				}
				break;
			}
			case 3: {
				if (total > 500) {
					total = total - (total * admin.getDiscountPercentage() / 100);
					System.out.println("Discount applied of : " + admin.getDiscountPercentage());
				}
				for (IMenu order : orderList) {
					System.out.println(order.toString());
				}
				System.out.println("total : " + total);
				System.out.println("Please select the mode for payment : 1.UPI 2.Credit Card");
				int Paymentchoice = sc.nextInt();
				if (Paymentchoice == 1) {
					if (orderList.size() % 2 != 0) {
						agents.setName("Zomato");
						payment.setPayment(PaymentMethods.UPI, customer.getName(), agents, total);
						break;
					} else {
						agents.setName("Swiggy");
						payment.setPayment(PaymentMethods.UPI, customer.getName(), agents, total);
						break;
					}
				} else if (Paymentchoice == 2) {
					if (orderList.size() % 2 != 0) {
						agents.setName("Zomato");
						payment.setPayment(PaymentMethods.CREDIT_CARD, customer.getName(), agents, total);
						break;
					} else {
						agents.setName("Swiggy");
						payment.setPayment(PaymentMethods.CREDIT_CARD, customer.getName(), agents, total);
						break;
					}
				} else {
					System.out.println("Enter a valid choice !!");
					choice = 3;
				}
				break;
			}
			case 4: {
				System.out.println("Thank you for visiting our food app , visit again !!");
				break;
			}
			default: {
				System.out.println("Enter a valid choice !!");
				break;
			}
			}
		}
	}

}
