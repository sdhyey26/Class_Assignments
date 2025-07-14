package com.tss.test;

import java.util.ArrayList;
import java.util.Scanner;
import com.tss.model.Admin;
import com.tss.model.Customer;
import com.tss.model.DeliveryAgents;
import com.tss.model.Menu;

public class FoodDeliveryAppMain {
	
	static Admin admin = new Admin();
	static Customer customer = new Customer();
	static Menu menu = new Menu();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to food delivery App !! ");
		System.out.println("1. Admin Login / 2. normal login");
		Scanner sc = new Scanner(System.in);
		int choiceForAdmin = sc.nextInt();

		if (choiceForAdmin == 1) {
			adminPanel(sc , admin);
		}
		else if(choiceForAdmin == 2) {
			customerPanel(sc);
		}
		else {
			System.out.println("please enter valid choice !!");
		}
	}

	public static void adminPanel(Scanner sc , Admin admin) {

	    System.out.println("Enter name : ");
	    String name = sc.next();

	    System.out.println("Enter password : ");
	    String password = sc.next();

	    if (name.equals(admin.getName()) && password.equals(admin.getPassword())) {
	        System.out.println("Welcome " + admin.getName() + " !!");

	        System.out.println("1. Set Menu ");
	        System.out.println("2. Change admin password");
	        System.out.println("3. Change Discount percentage");
	        System.out.println("4. Add/change delivery agents");
	        System.out.println("5. Exit");
	        boolean isTrue = true;

	        while (isTrue) {
	            System.out.println("Enter your choice : ");
	            int choice = sc.nextInt();
	            sc.nextLine(); 

	            switch (choice) {
	                case 1: {
	                    while (true) {
	                        System.out.println("Enter 1 to stop or 2 to continue : ");
	                        String doneContinue = sc.nextLine();

	                        if (doneContinue.equals("2")) {
	                            System.out.println("Enter food name : ");
	                            String foodName = sc.nextLine();

	                            System.out.println("Enter food price : ");
	                            double foodPrice = sc.nextDouble();
	                            sc.nextLine(); 

	                            System.out.println("Enter food description : ");
	                            String foodDescription = sc.nextLine();

	                            admin.setMenu(foodName, foodPrice, foodDescription);
	                        } else {
	                            break;
	                        }
	                    }
	                } break;

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
	                } break;

	                case 3: {
	                    System.out.println("Enter the percentage you want to change to : ");
	                    int changedDiscount = sc.nextInt();
	                    sc.nextLine(); 

	                    admin.changeDiscountPercentage(changedDiscount);
	                } break;

	                case 4: {
	                    admin.setDeliveryAgent();
	                    ArrayList<DeliveryAgents> agentInfo = admin.getDeliveryAgent();
	                    
	                    for(DeliveryAgents agent : agentInfo) {
	                    	System.out.println(agent.toString());
	                    }
	                } break;

	                case 5: {
	                    isTrue = false;
	                    System.out.println("Exiting admin panel.");
	                } break;

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
	    
	    ArrayList<Menu> menuList = menu.getMenu();
	    
	    
	    
	    System.out.println("1. place order : ");
	    System.out.println("2. display bill : ");
	    System.out.println("3. Exit");
	    boolean isTrue = true;
	    
	    while(isTrue) {
	    	System.out.println("Enter your choice : ");
	    	int choice = sc.nextInt();
	    	
	    	switch(choice) {
	    	
	    	case 1: {
	    	    int i = 0;
	    	    int total = 0;
	    	    ArrayList<Menu> orderList = new ArrayList<>(); 

	    	    for (Menu item : menuList) {
	    	        System.out.println("[id : " + i++ + "] " + item.toString());
	    	    }

	    	    sc.nextLine(); 

	    	    while (true) {
	    	        System.out.println("Enter 1 to stop, 2 to continue order, 3 to display bill: ");
	    	        String doneContinue = sc.nextLine();

	    	        if (doneContinue.equals("2")) {
	    	            System.out.println("Enter id to add to cart: ");
	    	            int id = sc.nextInt();
	    	            
	    	            System.out.println("enter quantity to be added : ");
	    	            int quantity = sc.nextInt();
	    	            
	    	            sc.nextLine(); 

	    	            for(int in = 0 ; in < quantity ; in++) {
	    	            	 if (id >= 0 && id < menuList.size()) {
	 	    	                Menu item = menuList.get(id);
	 	    	                orderList.add(item);
	 	    	                total += item.getPrice();
	 	    	                System.out.println(item.getFoodName() + " added to cart.");
	 	    	            } else {
	 	    	                System.out.println("Invalid id.");
	 	    	            }
	    	            }
	    	           

	    	        } else if (doneContinue.equals("3")) {
	    	            System.out.println("Your Bill:");
	    	            for (Menu item : orderList) {
	    	                System.out.println("[ " + item.toString() + " ]");
	    	            }

	    	            System.out.println("Total payable amount: ₹" + total);
	    	            
	    	            //yet to be continued
	    	        } else if (doneContinue.equals("1")) {
	    	            break;
	    	        } else {
	    	            System.out.println("Invalid input.");
	    	        }
	    	    }

	    	} break;
	    
	    	}
	    }
	}
}
