package com.tss.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.tss.model.CustomerModel;

public class CustomerTest {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<CustomerModel> customers = CustomerList(sc);
		
		for(CustomerModel customer : customers) {
			if(conditionCheck(customer)) {
				int amount = amountCalculate(customer);
				printMessage(customer ,  amount);
			}
		}
		
	}
	
	private static int amountCalculate(CustomerModel customer) {
		
		Function<CustomerModel , Integer> calculatedAmount = (customerInfo)->{
			int loanAmount = (int) (customerInfo.getIncome() * (customerInfo.getCreditScore() / 1000.0));
			
			return loanAmount;
		};
		
		return calculatedAmount.apply(customer);
	}

	public static ArrayList<CustomerModel> CustomerList(Scanner sc) {
		System.out.println("Enter the number of customers : ");
		int count = sc.nextInt();
		
		Supplier<ArrayList<CustomerModel>> customerList = ()->{
			ArrayList<CustomerModel> customerArrayList = new ArrayList<>();
			for(int i = 0 ; i < count ; i++) {
				CustomerModel customer = new CustomerModel();
				System.out.println("enter name : ");
				customer.setName(sc.next());
				System.out.println("enter age : ");
				customer.setAge(sc.nextInt());
				System.out.println("enter income : ");
				customer.setIncome(sc.nextInt());
				System.out.println("enter credit score : ");
				customer.setCreditScore(sc.nextInt());
				
				customerArrayList.add(customer);
			}
			
			for(CustomerModel customer : customerArrayList) {
				System.out.println(customer.toString());
			}
			
			return customerArrayList;
		};
		
		return customerList.get();
	}
	
	public static boolean conditionCheck(CustomerModel customer) {
		
		Predicate<CustomerModel> check = (customerCheck) ->{
			
			if(customerCheck.getAge() >= 21 && customerCheck.getIncome() >= 25000 && customerCheck.getCreditScore() >= 650) {
				return true;
			}
			else {
				return false;
			}
		};
		
		return check.test(customer);
	}
	
	public static void printMessage(CustomerModel customer , int amount) {
		
		Consumer<CustomerModel> printCustomerInfo = (customerDetails)->{
			System.out.println("Loan Approved for " + customerDetails.getName());
			System.out.println("Eligible Amount: " + "₹" + amount);
		};
		
		printCustomerInfo.accept(customer);
	}
	
}
