
package com.tss.test;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class student {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("enter the number of friends : ");
		int number = scanner.nextInt();
		
		friends friend[] = new friends[number];

		for (int i = 0; i < number; i++) {
			System.out.print("Enter name : ");
			String name = scanner.next();
			friend[i] = new friends(name);
		}
		
		for(int i = 0 ; i < number - 1 ; i++) {
			friend[i].setBuddy(friend[i+1]);
		}
		
		System.out.println("Enter the name whose buddies needs to be printed : ");
		String friendName = scanner.next();
		
		for(friends f : friend) {
			
			
			if(f.getName().equals(friendName)) {
				printName(f);
			}
		}
	}
	
	public static void printName(friends f ) {
		try {
			System.out.println(f.buddy.name);
			if(f.buddy != null) {
				printName(f.buddy );
			}
			else {
				return;
			}
		}
		catch(Exception e) {
			return;
		}
	}
}