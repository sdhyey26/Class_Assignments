package com.tss.main;

import java.util.ArrayList;
import java.util.List;

import com.tss.model.AccountModel;

public class AccountTest {
	
	public static void main(String[] args) {
		AccountModel acc1 = new AccountModel(101, "Alice", 50000);
		AccountModel acc2 = new AccountModel(102, "Bob", 60000);
		AccountModel acc3 = new AccountModel(103, "Charlie", 55000);
		AccountModel acc4 = new AccountModel(104, "Diana", 70000);
		
		List<AccountModel> accountList = new ArrayList<>();
		
		accountList.add(acc1);
		accountList.add(acc2);
		accountList.add(acc3);
		accountList.add(acc4);
		

        AccountModel min = accountList.stream()
                .min((a, b) -> a.getSalary() - b.getSalary())
                .get();
        System.out.println("Minimum Balance: " + min.getName() + " - " + min.getSalary());

        AccountModel max = accountList.stream()
                .max((a, b) -> a.getSalary() - b.getSalary())
                .get();
        System.out.println("Maximum Balance: " + max.getName() + " - " + max.getSalary());

        System.out.println("Names longer than 6 characters:");
        accountList.stream()
                .filter(a -> a.getName().length() > 6)
                .forEach(a -> System.out.println(a.getName()));

        int total = accountList.stream()
                .map(a -> a.getSalary())
                .reduce(0, (a, b) -> a + b);
        System.out.println("Total Balance: " + total);

	}
	
}
