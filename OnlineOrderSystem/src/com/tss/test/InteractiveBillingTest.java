package com.tss.test;

import com.tss.model.Customer;
import com.tss.model.LineItem;
import com.tss.model.Order;
import com.tss.model.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class InteractiveBillingTest {

	private static final List<Product> availableProducts = new ArrayList<>();

	public static void main(String[] args) {
		initializeProducts();
		Scanner scanner = new Scanner(System.in);

		System.out.println("--- Shopping Cart Initialized ---");
		System.out.print("Enter customer name: ");
		String customerName = scanner.nextLine();

		List<LineItem> cartItems = runShoppingLoop(scanner);

		if (cartItems.isEmpty()) {
			System.out.println("\nCart is empty. Exiting.");
		} else {
			Order order = new Order(101, new Date(), cartItems);
			Customer customer = new Customer(1, customerName, new ArrayList<>(List.of(order)));
			printBill(customer, order);
		}

		scanner.close();
	}

	private static List<LineItem> runShoppingLoop(Scanner scanner) {
		List<LineItem> cartItems = new ArrayList<>();
		int lineItemIdCounter = 1;

		while (true) {
			displayAvailableProducts();
			System.out.print("\nEnter Product ID (or 'done' to finish): ");
			String input = scanner.nextLine();

			if ("done".equalsIgnoreCase(input)) {
				break;
			}

			try {
				int productId = Integer.parseInt(input);
				Product product = findProductById(productId);

				if (product == null) {
					System.out.println("ERROR: Invalid Product ID.");
					continue;
				}

				System.out.print("Enter quantity for '" + product.getName() + "': ");
				int quantity = Integer.parseInt(scanner.nextLine());

				if (quantity <= 0) {
					System.out.println("ERROR: Quantity must be positive.");
					continue;
				}

				cartItems.add(new LineItem(lineItemIdCounter++, quantity, product));
				System.out.println("-> Added " + quantity + "x " + product.getName());

			} catch (NumberFormatException e) {
				System.out.println("ERROR: Invalid input. Please enter a number.");
			}
		}
		return cartItems;
	}

	public static void printBill(Customer customer, Order order) {
		System.out.println("\n\n--- INVOICE ---");
		System.out.println("Customer: " + customer.getName());
		System.out.println("Date: " + order.getDate());
		System.out.println("-------------------------------------------------------------------");
		System.out.printf("%-20s %-5s %-12s %-15s %-12s\n", "Product", "Qty", "Price", "Discounted", "Total");
		System.out.println("-------------------------------------------------------------------");

		for (LineItem item : order.getItems()) {
			Product p = item.getProduct();
			System.out.printf("%-20s %-5d $%-11.2f $%-14.2f $%-11.2f\n", p.getName(), item.getQuantity(), p.getPrice(),
					p.calculateDiscountedPrice(), item.calculateLineItemCost());
		}

		System.out.println("-------------------------------------------------------------------");
		System.out.printf("GRAND TOTAL: $%.2f\n", order.calculateOrderPrice());
		System.out.println("-------------------------------------------------------------------");
	}

	private static Product findProductById(int id) {
		for (Product p : availableProducts) {
			if (p.getId() == id) {
				return p;
			}
		}
		return null;
	}

	private static void displayAvailableProducts() {
		System.out.println("\n--- Available Products ---");
		System.out.printf("%-10s %-20s %-10s\n", "ID", "Product", "Price");
		System.out.println("------------------------------------------");
		for (Product p : availableProducts) {
			System.out.printf("%-10d %-20s $%-10.2f\n", p.getId(), p.getName(), p.getPrice());
		}
	}

	private static void initializeProducts() {
		availableProducts.add(new Product(1, "Laptop", 1200.00, 10.0));
		availableProducts.add(new Product(2, "Mouse", 25.00, 5.0));
		availableProducts.add(new Product(3, "Keyboard", 75.00, 15.0));
		availableProducts.add(new Product(4, "Monitor", 300.00, 0.0));
		availableProducts.add(new Product(5, "Webcam", 50.00, 20.0));
		availableProducts.add(new Product(6, "USB Hub", 20.00, 0.0));
	}
}
