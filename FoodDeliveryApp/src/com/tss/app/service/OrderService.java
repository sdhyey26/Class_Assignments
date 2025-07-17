package com.tss.app.service;

import com.tss.exceptions.InvalidInputException;
import com.tss.exceptions.NoSuchMenuFound;
import com.tss.exceptions.OrderListEmptyException;
import com.tss.model.DeliveryAgents.DeliveryAgent;
import com.tss.model.Menu.IMenu;
import com.tss.model.Menu.IndianMenu;
import com.tss.model.Menu.ItalianMenu;
import com.tss.model.Menu.KoreanMenu;
import com.tss.model.customer.Customer;
import com.tss.model.payment.PaymentProceed;
import com.tss.model.payment.PaymentMethods;
import com.tss.model.admin.*;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderService {
	private final AdminService adminService;
	private final PaymentProceed payment = new PaymentProceed();
	private final Customer customer = new Customer();
	private final DeliveryAgent agent = new DeliveryAgent();
	private final Admin admin = new Admin();
	private final IndianMenu indianMenu = new IndianMenu();
	public ArrayList<IMenu> orderList = new ArrayList<>();
	public ItalianMenu italianMenu = new ItalianMenu();
	public KoreanMenu koreanMenu = new KoreanMenu();
	public ArrayList<DeliveryAgent> agents = admin.getDeliveryAgents();
	public String agentName = "";


	public int total = 0;

	public OrderService(AdminService adminService) {
		this.adminService = adminService;
	}

	public void initCustomer(String name, String pass, String addr) {
		customer.setName(name);
		customer.setPassword(pass);
		customer.setAddress(addr);
	}

	public void placeOrder(Scanner sc) {
		boolean isTrueForMenu = true;
		while (isTrueForMenu) {
			System.out.println(" 1. Indian cuisine ");
			System.out.println(" 2. Italian cuisine ");
			System.out.println(" 3. korean cuisine ");
			System.out.println(" 4. Exit ");
			System.out.println("buy of ₹ 500 or above to get " + admin.getDiscountPercentage() + "% of discount!!");
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
									throw new NoSuchMenuFound();
								}
							}
						}
					} else if (doneContinue.equals("2")) {
						System.out.println("Exiting ordering !!");
						break;
					} else {
						throw new InvalidInputException();
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
									throw new NoSuchMenuFound();
								}
							}
						}
					} else if (doneContinue.equals("1")) {
						System.out.println("Exiting Ordering !!");
						break;
					} else {
						throw new InvalidInputException();
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
									throw new NoSuchMenuFound();
								}
							}
						}
					} else if (doneContinue.equals("1")) {
						System.out.println("Exiting ordering !!");
						break;
					} else {
						throw new InvalidInputException();
					}
				}
				break;
			}
			case 4: {
				isTrueForMenu = false;
				break;
			}

			default: {
				throw new InvalidInputException();
			}
			}
		}
	}

	public void displayCart() {
		if(!orderList.isEmpty()) {
			orderList.forEach(item -> System.out.println(item.toString()));
		}
		else {
			throw new OrderListEmptyException();
		}
	}

	public void checkout(Scanner sc) {
		if (total > 500)
			total -= total * adminService.getDiscount() / 100;
		displayCart();
		System.out.println("Total: " + total);
		System.out.println("1.UPI 2.CC");
		int mode = sc.nextInt();
		
		if(orderList.size() % 2 == 0) {
			agentName = agents.get(0).getName();
		}
		else {
			agentName = agents.get(1).getName();
		}
		
		payment.setPayment((mode == 1) ? PaymentMethods.UPI : PaymentMethods.CREDIT_CARD, customer.getName(), agentName , 
				total);
	}
}
